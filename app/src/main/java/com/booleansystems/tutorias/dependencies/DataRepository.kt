package com.booleansystems.tutorias.dependencies

import org.koin.dsl.module.module
import org.koin.experimental.builder.single

/**

Created by oscar on 18/04/19
operez@na-at.com.mx
 */
val DataRepository = module(definition = {
    single<PreferenceHelper>()
})