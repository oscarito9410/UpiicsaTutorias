package com.booleansystems.tutorias.view.login.signup

import com.booleansystems.data.SignUpRepository
import com.booleansystems.domain.UserEntity
import com.booleansystems.tutorias.dependencies.rest.UserEndpoints
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**

Created by oscar on 27/04/19
operez@na-at.com.mx
 */
class SignUpRemoteDataSourceImpl(val userEndpoints: UserEndpoints) : SignUpRepository.SignUpRemoteDataSource,
    Callback<UserEntity> {
    override fun onFailure(call: Call<UserEntity>, t: Throwable) {
        if (t != null) {

        }
    }

    override fun onResponse(call: Call<UserEntity>, response: Response<UserEntity>) {
        if (response != null) {

        }
    }

    override fun saveSignUpData(user: UserEntity) {
        userEndpoints.prueba().enqueue(this)
    }
}