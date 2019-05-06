package com.booleansystems.tutorias.view.login.signup

import com.booleansystems.data.SignUpRepository
import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.domain.SubjectEntity
import com.booleansystems.domain.signup.SignUpRequest
import com.booleansystems.tutorias.dependencies.rest.UserEndpoints


/**

Created by oscar on 27/04/19
operez@na-at.com.mx
 */
class SignUpRemoteDataSourceImpl(val userEndpoints: UserEndpoints) : SignUpRepository.SignUpRemoteDataSource {

    override fun sendSignUpDataRequest(request: SignUpRequest, result: IBaseResultListener<SubjectEntity>) {

    }


}