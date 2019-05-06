package com.booleansystems.tutorias.dependencies.rest

import com.booleansystems.domain.SubjectEntity
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by oscar on 19/04/19
 * operez@na-at.com.mx
 */
interface UserEndpoints {
    @GET("prueba")
    fun prueba(): Observable<Response<SubjectEntity>>
}
