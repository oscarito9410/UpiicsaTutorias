package com.booleansystems.data

import com.booleansystems.domain.UserEntity

/**

Created by oscar on 30/04/19
operez@na-at.com.mx
 */
class SignInRepository(val signUpRemoteDataSource: SignUpRemoteDataSource) {

    fun sendSignUpDataRequest(user: UserEntity) {
        signUpRemoteDataSource.sendSignUpDataRequest(user)
    }

    interface SignUpRemoteDataSource {
        fun sendSignUpDataRequest(user: UserEntity)
    }
}