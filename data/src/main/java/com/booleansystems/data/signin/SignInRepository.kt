package com.booleansystems.data.signin

import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.data.common.ISessionDataSource
import com.booleansystems.domain.common.EnrollResponse
import com.booleansystems.domain.signin.SignInRequest

/**

Created by oscar on 30/04/19
operez@na-at.com.mx
 */
class SignInRepository(private val signUpRemoteDataSource: SignUpRemoteDataSource) {

    fun sendSignUpDataRequest(request: SignInRequest, result: IBaseResultListener<EnrollResponse>) {
        signUpRemoteDataSource.sendSignUpDataRequest(request, result)
    }

    fun validateAlreadySignIn(): Boolean {
       return  signUpRemoteDataSource.validateAlreadySignIn()
    }

    interface SignUpRemoteDataSource : ISessionDataSource {
        fun sendSignUpDataRequest(request: SignInRequest, result: IBaseResultListener<EnrollResponse>)

        fun validateAlreadySignIn(): Boolean
    }

}