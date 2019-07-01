package com.booleansystems.data.common

import com.booleansystems.domain.common.EnrollResponse

/**

Created by oscar on 19/05/19
operez@na-at.com.mx
 */
interface ISessionDataSource {
    fun saveSessionData(response: EnrollResponse, isLogged: Boolean)

}