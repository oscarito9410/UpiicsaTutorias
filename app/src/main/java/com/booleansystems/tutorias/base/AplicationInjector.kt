package com.booleansystems.tutorias.base

import com.booleansystems.data.SignUpRepository
import com.booleansystems.interactors.SignUpUserInteractor
import com.booleansystems.tutorias.dependencies.preferences.PreferenceHelper
import com.booleansystems.tutorias.dependencies.rest.UserEndpoints
import com.booleansystems.tutorias.view.login.signin.viewmodel.SignInViewModel
import com.booleansystems.tutorias.view.login.signup.SignUpRemoteDataSourceImpl
import com.booleansystems.tutorias.view.login.signup.SignUpViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import org.koin.experimental.builder.single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**

Created by oscar on 18/04/19
operez@na-at.com.mx
 */
val ApplicationModule = module(definition = {
    single<PreferenceHelper>()
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

    single {
        Retrofit.Builder()
            .baseUrl("https://android.jlelse.eu/koin-simple-android-di-a47827a707ce/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(UserEndpoints::class.java) }
}
