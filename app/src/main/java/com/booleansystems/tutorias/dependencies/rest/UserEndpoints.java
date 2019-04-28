package com.booleansystems.tutorias.dependencies.rest;

import com.booleansystems.domain.UserEntity;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by oscar on 19/04/19
 * operez@na-at.com.mx
 */
public interface UserEndpoints {
    @GET("prueba")
    Call<UserEntity> prueba();
}
