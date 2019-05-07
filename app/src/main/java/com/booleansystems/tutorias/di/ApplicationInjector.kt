package com.booleansystems.tutorias.di

import com.booleansystems.data.signin.SignInRepository
import com.booleansystems.data.signup.SignUpRepository
import com.booleansystems.interactors.signin.SignInUserInteractor
import com.booleansystems.interactors.signup.SignUpUserInteractor
import com.booleansystems.tutorias.Constants
import com.booleansystems.tutorias.dependencies.rest.UserEndpoints
import com.booleansystems.tutorias.view.login.signin.SignInRemoteDataSourceImpl
import com.booleansystems.tutorias.view.login.signin.viewmodel.SignInViewModel
import com.booleansystems.tutorias.view.login.signup.SignUpRemoteDataSourceImpl
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
    factory {
        val userEndpoints: UserEndpoints = get()
        return@factory SignInRemoteDataSourceImpl(userEndpoints)
    }

    factory {
        val remoteDataSource: SignInRemoteDataSourceImpl = get()
        return@factory SignInRepository(remoteDataSource)
    }

    factory {
        val signInInteractor = SignInUserInteractor(get())
        return@factory signInInteractor
    }

    viewModel { SignInViewModel(get()) }

    factory {
        val userEndpoints: UserEndpoints = get()
        return@factory SignUpRemoteDataSourceImpl(userEndpoints)
    }

    factory {
        val remoteDataSource: SignUpRemoteDataSourceImpl = get()
        return@factory SignUpRepository(remoteDataSource)
    }
    factory {
        val signUpNewUserInteractor = SignUpUserInteractor(get())
        return@factory signUpNewUserInteractor
    }
    viewModel { SignUpViewModel(get()) }


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
