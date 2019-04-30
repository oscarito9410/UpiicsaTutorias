package com.booleansystems.interactors

import com.booleansystems.data.SignInRepository
import com.booleansystems.domain.UserEntity

/**

Created by oscar on 30/04/19
operez@na-at.com.mx
 */
class SignInUserInteractor(val signInRepository: SignInRepository) {
    operator fun invoke(user: UserEntity) = signInRepository.sendSignUpDataRequest(user)
}