package com.booleansystems.data.signin

import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.data.common.SessionDataSource
import com.booleansystems.domain.common.BaseResponse
import com.booleansystems.domain.signin.SignInRequest

/**

Created by oscar on 30/04/19
operez@na-at.com.mx
 */
class SignInRepository(val signUpRemoteDataSource: SignUpRemoteDataSource) {

    fun sendSignUpDataRequest(request: SignInRequest, result: IBaseResultListener<BaseResponse>) {
        signUpRemoteDataSource.sendSignUpDataRequest(request, result)
    }

    fun validateAlreadySignIn(): Boolean {
       return  signUpRemoteDataSource.validateAlreadySignIn()
    }

    interface SignUpRemoteDataSource : SessionDataSource {
        fun sendSignUpDataRequest(request: SignInRequest, result: IBaseResultListener<BaseResponse>)

        fun validateAlreadySignIn(): Boolean
    }

}