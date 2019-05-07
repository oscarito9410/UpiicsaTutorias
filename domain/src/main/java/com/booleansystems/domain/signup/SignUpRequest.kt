package com.booleansystems.domain.signup

import com.google.gson.annotations.SerializedName

/**

Created by oscar on 05/05/19
operez@na-at.com.mx
 */
data class SignUpRequest(
    @SerializedName("boleta") val boleta: String?,
    @SerializedName("nombre") val nombre: String?,
    @SerializedName("password") val password: String?,
    @SerializedName("ap_paterno") val ap_paterno: String?,
    @SerializedName("ap_materno") val ap_materno: String?,
    @SerializedName("id_carrera") val id_carrera: Int?
)