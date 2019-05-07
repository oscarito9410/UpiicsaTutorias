package com.booleansystems.domain.signin
import com.google.gson.annotations.SerializedName

/**

Created by oscar on 06/05/19
operez@na-at.com.mx
 */
data class SignInRequest(
    @SerializedName("boleta") val boleta: String?,
    @SerializedName("password") val password: String?
)