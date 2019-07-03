package com.booleansystems.interactors.signin

import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.data.signin.SignInRepository
import com.booleansystems.domain.common.BaseResponse
import com.booleansystems.domain.common.EnrollResponse
import com.booleansystems.domain.signin.SignInRequest

/**

Created by oscar on 30/04/19
operez@na-at.com.mx
 */
class SignInUserInteractor(val signInRepository: SignInRepository) {
    operator fun invoke(request: SignInRequest, result: IBaseResultListener<EnrollResponse>) =
        signInRepository.sendSignUpDataRequest(request, result)

    operator fun invoke() = false
}