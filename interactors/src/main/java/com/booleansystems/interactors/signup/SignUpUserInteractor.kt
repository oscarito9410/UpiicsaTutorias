package com.booleansystems.interactors.signup

import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.data.signup.SignUpRepository
import com.booleansystems.domain.common.BaseResponse
import com.booleansystems.domain.common.EnrollResponse
import com.booleansystems.domain.signup.SignUpRequest

/**

Created by oscar on 27/04/19
operez@na-at.com.mx
 */
class SignUpUserInteractor(val signUpRepository: SignUpRepository) {
    operator fun invoke(request: SignUpRequest, baseResult: IBaseResultListener<EnrollResponse>) =
        signUpRepository.sendSignUpDataRequest(request, baseResult)
}