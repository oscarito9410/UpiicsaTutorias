package com.booleansystems.tutorias.view.login.signin

import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.data.signin.SignInRepository
import com.booleansystems.data.user.UserDataRepository
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
class SignInRepositoryImpl(
    val userEndpoints: UserEndpoints,
    val userDataRepository: UserDataRepository
) : SignInRepository.SignUpRemoteDataSource {
    override fun isLogged(): Boolean = userDataRepository.alreadyLogged()

    var mDisaposable: Disposable? = null

    override fun sendSignUpDataRequest(request: SignInRequest, result: IBaseResultListener<EnrollResponse>) {
        mDisaposable = userEndpoints.signIn(request)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe({
                result.onSuccess(it)
                userDataRepository.saveSesionData(it, true)
                mDisaposable!!.dispose()
            }, {
                result.onError(it)
                mDisaposable!!.dispose()
            })
    }


}