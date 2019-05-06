package com.booleansystems.data

import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.domain.SubjectEntity
import com.booleansystems.domain.signup.SignUpRequest

/**

Created by oscar on 27/04/19
operez@na-at.com.mx
 */
class SignUpRepository(val signupRemoteDataSource: SignUpRemoteDataSource) {

    fun sendSignUpDataRequest(request: SignUpRequest, result: IBaseResultListener<SubjectEntity>) {
        signupRemoteDataSource.sendSignUpDataRequest(request, result)
    }

    interface SignUpRemoteDataSource {
        fun sendSignUpDataRequest(request: SignUpRequest, result: IBaseResultListener<SubjectEntity>)
    }


}