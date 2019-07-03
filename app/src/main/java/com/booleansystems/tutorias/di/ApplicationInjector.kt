package com.booleansystems.tutorias.di

import com.booleansystems.data.signin.SignInRepository
import com.booleansystems.data.signup.SignUpRepository
import com.booleansystems.data.user.UserDataRepository
import com.booleansystems.interactors.signin.SignInUserInteractor
import com.booleansystems.interactors.signup.SignUpUserInteractor
import com.booleansystems.tutorias.dependencies.preferences.PreferenceHelper
import com.booleansystems.tutorias.dependencies.rest.UserEndpoints
import com.booleansystems.tutorias.utils.Constants
import com.booleansystems.tutorias.view.home.profile.ProfileViewModel
import com.booleansystems.tutorias.view.login.UserDataRepositoryImpl
import com.booleansystems.tutorias.view.login.signin.SignInRepositoryImpl
import com.booleansystems.tutorias.view.login.signin.viewmodel.SignInViewModel
import com.booleansystems.tutorias.view.login.signup.SignUpRepositoryImpl
import com.booleansystems.tutorias.view.login.signup.SignUpViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**

Created by oscar on 18/04/19
operez@na-at.com.mx
 */
val ApplicationModule = module(definition = {

    single {
        PreferenceHelper(get())
    }

    factory {
        return@factory UserDataRepositoryImpl(get())
    }


    factory {
        val repository: UserDataRepositoryImpl = get()
        return@factory UserDataRepository(repository)
    }

    factory {
        val repository: SignInRepositoryImpl = get()
        return@factory SignInRepository(repository)
    }

    factory {
        val userEndpoints: UserEndpoints = get()
        val repository: UserDataRepository = get()
        return@factory SignInRepositoryImpl(userEndpoints, repository)
    }



    factory {
        return@factory SignInUserInteractor(get())
    }

    viewModel { SignInViewModel(get()) }

    factory {
        val userEndpoints: UserEndpoints = get()
        val repository: UserDataRepository = get()
        return@factory SignUpRepositoryImpl(userEndpoints, repository)
    }

    factory {
        val remoteDataSource: SignUpRepositoryImpl = get()
        return@factory SignUpRepository(remoteDataSource)
    }
    factory {
        return@factory SignUpUserInteractor(get())
    }
    viewModel { SignUpViewModel(get()) }


    factory {
        val repository: UserDataRepositoryImpl = get()
        return@factory repository.getUserModel()
    }

    viewModel {
        ProfileViewModel(get())
    }


})


val NetModule = module {


    factory {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return@factory loggingInterceptor
    }

    single {
        Retrofit.Builder()
            .baseUrl(Constants.APIConfig.BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single { get<Retrofit>().create(UserEndpoints::class.java) }
}
