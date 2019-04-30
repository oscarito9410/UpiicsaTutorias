package com.booleansystems.data

import com.booleansystems.domain.UserEntity

/**

Created by oscar on 27/04/19
operez@na-at.com.mx
 */
class SignUpRepository(val signupRemoteDataSource: SignUpRemoteDataSource) {

    fun sendSignUpDataRequest(user: UserEntity) {
        signupRemoteDataSource.sendSignUpDataRequest(user)
    }

    interface SignUpRemoteDataSource {
        fun sendSignUpDataRequest(user: UserEntity)
    }
}