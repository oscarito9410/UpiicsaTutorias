package com.booleansystems.tutorias.view.login

import com.booleansystems.data.user.UserDataRepository
import com.booleansystems.domain.UserEntity
import com.booleansystems.domain.common.EnrollResponse
import com.booleansystems.tutorias.dependencies.preferences.PreferenceHelper
import com.booleansystems.tutorias.utils.Constants

/**
 * Created by Oscar Emilio Pérez Mtz on 02/07/2019.
operez@na-at.com.mx
 */
class UserDataRepositoryImpl(private val preferencesHelper: PreferenceHelper) : UserDataRepository.SessionDataSource {

    private val sharedPreferences = preferencesHelper.defaultPrefs()

    override fun alreadyLogged(): Boolean {
        return preferencesHelper.defaultPrefs().getBoolean(Constants.USER_LOGGED_IN, false)
    }


    override fun saveSessionData(response: EnrollResponse, isLogged: Boolean) {
        sharedPreferences.edit()
            .putString(Constants.USER_BOLETA, response.boleta)
            .putString(
                Constants.USER_NAME, "${response.nombre}" +
                        " " + "${response.apPaterno}" + " " + "${response.apMaterno}"
            )
            .putBoolean(Constants.USER_LOGGED_IN, true).apply()

    }

    override fun getUserModel(): UserEntity {
        return UserEntity(
            sharedPreferences.getString(Constants.USER_BOLETA, ""),
            sharedPreferences.getString(Constants.USER_NAME, "")
        )
    }


}