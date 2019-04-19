package com.booleansystems.tutorias.dependencies

import com.booleansystems.tutorias.ui.login.signin.viewmodel.SignInViewModel
import com.booleansystems.tutorias.ui.login.signup.SignUpViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import org.koin.experimental.builder.single

/**

Created by oscar on 18/04/19
operez@na-at.com.mx
 */
val DataRepository = module(definition = {
    single<PreferenceHelper>()


    viewModel { SignInViewModel(get()) }

    viewModel { SignUpViewModel(get()) }
})