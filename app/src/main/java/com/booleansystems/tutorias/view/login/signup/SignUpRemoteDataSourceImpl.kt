package com.booleansystems.tutorias.view.login.signup

import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.data.signup.SignUpRepository
import com.booleansystems.domain.common.BaseResponse
import com.booleansystems.domain.signup.SignUpRequest
import com.booleansystems.tutorias.dependencies.rest.UserEndpoints
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**

Created by oscar on 27/04/19
operez@na-at.com.mx
 */
class SignUpRemoteDataSourceImpl(val userEndpoints: UserEndpoints) : SignUpRepository.SignUpRemoteDataSource {

    var mDisaposable: Disposable? = null

    override fun sendSignUpDataRequest(request: SignUpRequest, result: IBaseResultListener<BaseResponse>) {
        mDisaposable = userEndpoints.signUp(request).observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe({
                result.onSuccess(it)
                mDisaposable!!.dispose()

            }, {
                result.onError(it)
                mDisaposable!!.dispose()
            })
    }

}