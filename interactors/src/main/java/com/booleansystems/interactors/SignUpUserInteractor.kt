package com.booleansystems.interactors

import com.booleansystems.data.SignUpRepository
import com.booleansystems.domain.UserEntity

/**

Created by oscar on 27/04/19
operez@na-at.com.mx
 */
class SignUpUserInteractor(val signUpRepository: SignUpRepository) {
    operator  fun  invoke(user: UserEntity)= signUpRepository.sendSignUpDataRequest(user)
}