package com.booleansystems.data.signup

import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.data.common.ISessionDataSource
import com.booleansystems.domain.common.EnrollResponse
import com.booleansystems.domain.signup.SignUpRequest

/**

Created by oscar on 27/04/19
operez@na-at.com.mx
 */
class SignUpRepository(val signupRemoteDataSource: SignUpRemoteDataSource) {

    fun sendSignUpDataRequest(request: SignUpRequest, result: IBaseResultListener<EnrollResponse>) {
        signupRemoteDataSource.sendSignUpDataRequest(request, result)
    }

    interface SignUpRemoteDataSource   {
        fun sendSignUpDataRequest(request: SignUpRequest, result: IBaseResultListener<EnrollResponse>)
    }
}