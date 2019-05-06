package com.booleansystems.interactors

import com.booleansystems.data.SignUpRepository
import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.domain.SubjectEntity
import com.booleansystems.domain.signup.SignUpRequest

/**

Created by oscar on 27/04/19
operez@na-at.com.mx
 */
class SignUpUserInteractor(val signUpRepository: SignUpRepository) {
    operator fun invoke(request: SignUpRequest, baseResult: IBaseResultListener<SubjectEntity>) =
        signUpRepository.sendSignUpDataRequest(request, baseResult)
}