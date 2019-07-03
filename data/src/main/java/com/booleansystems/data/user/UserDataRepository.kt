package com.booleansystems.data.user

import com.booleansystems.domain.UserEntity
import com.booleansystems.domain.common.EnrollResponse

/**
 * Created by Oscar Emilio Pérez Mtz on 02/07/2019.
operez@na-at.com.mx
 */
class UserDataRepository(private val sessionDataSource: SessionDataSource) {

    fun saveSesionData(response: EnrollResponse, isLogged: Boolean) {
        sessionDataSource.saveSessionData(response, isLogged)
    }

    fun alreadyLogged() = sessionDataSource.alreadyLogged()

    interface SessionDataSource {
        fun saveSessionData(response: EnrollResponse, isLogged: Boolean)
        fun alreadyLogged(): Boolean
        fun getUserModel(): UserEntity
    }
}