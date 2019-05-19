package com.booleansystems.tutorias.view.login.signin

import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.data.signin.SignInRepository
import com.booleansystems.domain.common.BaseResponse
import com.booleansystems.domain.signin.SignInRequest
import com.booleansystems.tutorias.Constants
import com.booleansystems.tutorias.dependencies.preferences.PreferenceHelper
import com.booleansystems.tutorias.dependencies.rest.UserEndpoints
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

    override fun sendSignUpDataRequest(request: SignInRequest, result: IBaseResultListener<BaseResponse>) {
        mDisaposable = userEndpoints.signIn(request)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe({
                result.onSuccess(it)
                saveSessionData(request.boleta!!, true)
                mDisaposable!!.dispose()
            }, {
                result.onError(it)
                mDisaposable!!.dispose()
            })
    }

    override fun saveSessionData(boleta: String, isLogged: Boolean) {
        preferencesHelper.defaultPrefs().edit()
            .putString(Constants.USER_BOLETA, boleta)
            .putBoolean(Constants.USER_LOGGED_IN, true).apply()
    }

}