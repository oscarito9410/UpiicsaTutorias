package com.booleansystems.tutorias.base

import android.app.Application
import com.booleansystems.tutorias.dependencies.DataRepository
import org.koin.android.ext.android.startKoin

/**

Created by oscar on 18/04/19
operez@na-at.com.mx
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val moduleList = listOf(DataRepository)
        startKoin(this, moduleList)
    }
}