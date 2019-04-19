package com.booleansystems.tutorias.dependencies

import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by oscar on 19/04/19
 * operez@na-at.com.mx
 * https://stackoverflow.com/questions/53592233/dependency-injection-with-koin
 */

fun NetModule(baseUrl: String) = module {

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(ApiInterface::class.java) }
}

