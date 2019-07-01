package com.booleansystems.tutorias.view.login.signin

import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.data.signin.SignInRepository
import com.booleansystems.domain.common.BaseResponse
import com.booleansystems.domain.common.EnrollResponse
import com.booleansystems.domain.signin.SignInRequest
import com.booleansystems.tutorias.dependencies.preferences.PreferenceHelper
import com.booleansystems.tutorias.dependencies.rest.UserEndpoints
import com.booleansystems.tutorias.utils.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**

Created by oscar on 06/05/19
operez@na-at.com.mx
 */
class SignInRemoteDataSourceImpl(
    val userEndpoints: UserEndpoints,
    val preferencesHelper: PreferenceHelper
) : SignInRepository.SignUpRemoteDataSource {
    override fun validateAlreadySignIn(): Boolean {
        return preferencesHelper.defaultPrefs().getBoolean(Constants.USER_LOGGED_IN, false)
    }

    var mDisaposable: Disposable? = null

    override fun sendSignUpDataRequest(request: SignInRequest, result: IBaseResultListener<EnrollResponse>) {
        mDisaposable = userEndpoints.signIn(request)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe({
                result.onSuccess(it)
                saveSessionData(it, true)
                mDisaposable!!.dispose()
            }, {
                result.onError(it)
                mDisaposable!!.dispose()
            })
    }

    override fun saveSessionData(response: EnrollResponse, isLogged: Boolean) {
        preferencesHelper.defaultPrefs().edit()
            .putString(Constants.USER_BOLETA, response.boleta)
            .putString(Constants.USER_NAME, "${response.nombre}${response.apPaterno}${response.apMaterno}")
            .putBoolean(Constants.USER_LOGGED_IN, true).apply()
    }

}