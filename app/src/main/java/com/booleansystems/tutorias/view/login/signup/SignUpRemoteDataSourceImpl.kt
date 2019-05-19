package com.booleansystems.tutorias.view.login.signup

import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.data.signup.SignUpRepository
import com.booleansystems.domain.common.BaseResponse
import com.booleansystems.domain.signup.SignUpRequest
import com.booleansystems.tutorias.Constants
import com.booleansystems.tutorias.dependencies.preferences.PreferenceHelper
import com.booleansystems.tutorias.dependencies.rest.UserEndpoints
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**

Created by oscar on 27/04/19
operez@na-at.com.mx
 */
class SignUpRemoteDataSourceImpl(
    val userEndpoints: UserEndpoints,
    val preferencesHelper: PreferenceHelper
) : SignUpRepository.SignUpRemoteDataSource {


    var mDisaposable: Disposable? = null

    override fun sendSignUpDataRequest(request: SignUpRequest, result: IBaseResultListener<BaseResponse>) {
        mDisaposable = userEndpoints.signUp(request).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe({
                saveSessionData(request.boleta!!, true)
                result.onSuccess(it)
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