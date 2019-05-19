package com.booleansystems.data.common

/**

Created by oscar on 19/05/19
operez@na-at.com.mx
 */
interface SessionDataSource {
    fun saveSessionData(boleta: String, isLogged: Boolean)

}