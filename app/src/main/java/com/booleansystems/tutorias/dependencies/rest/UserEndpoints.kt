package com.booleansystems.tutorias.dependencies.rest

import com.booleansystems.domain.common.BaseResponse
import com.booleansystems.domain.common.EnrollResponse
import com.booleansystems.domain.signin.SignInRequest
import com.booleansystems.domain.signup.SignUpRequest
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by oscar on 19/04/19
 * operez@na-at.com.mx
 */
interface UserEndpoints {
    @POST("login/validate")
    fun signIn(@Body signInRequest: SignInRequest): Observable<EnrollResponse>

    @POST("login/register")
    fun signUp(@Body signUpRequest: SignUpRequest): Observable<EnrollResponse>
}
