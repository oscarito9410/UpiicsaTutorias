package com.booleansystems.domain.common

import com.google.gson.annotations.SerializedName

/**
 * Created by Oscar Emilio Pérez Mtz on 30/06/2019.
operez@na-at.com.mx
 */
data class EnrollResponse(
    @SerializedName("boleta") val boleta: String?,
    @SerializedName("nombre") val nombre: String?,
    @SerializedName("ap_paterno") val apPaterno: String?,
    @SerializedName("ap_materno") val apMaterno: String?,
    @SerializedName("id_carrera") val idCarrera: Int?
) : BaseResponse()