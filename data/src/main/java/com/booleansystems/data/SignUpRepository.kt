package com.booleansystems.data

import com.booleansystems.domain.UserEntity

/**

Created by oscar on 27/04/19
operez@na-at.com.mx
 */
class SignUpRepository(val signupRemoteDataSource: SignUpRemoteDataSource) {

    fun saveSignUpData(user: UserEntity) {
        signupRemoteDataSource.saveSignUpData(user)
    }

    interface SignUpRemoteDataSource {
        fun saveSignUpData(user: UserEntity)
    }
}