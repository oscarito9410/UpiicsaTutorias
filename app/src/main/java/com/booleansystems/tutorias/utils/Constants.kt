package com.booleansystems.tutorias.utils

/**

Created by oscar on 18/04/19
operez@na-at.com.mx
 */
class Constants {
    companion object {
        const val MAX_LENGTH_BOLETA = 10;
        const val USER_NAME = "user_name"
        const val USER_PASSWORD = "user_password"
        const val USER_BOLETA = "user_boleta"
        const val USER_LOGGED_IN = "user_logged_in"
    }



    class APIConfig {
        companion object {
            const val BASE_URL = "http://sosmex9410-001-site2.etempurl.com/api/upiicsa/";
            const val URL_FEED = "http://fetchrss.com/rss/5d1921e48a93f8093a8b45685d1922a18a93f8f1408b4567.xml"
        }
    }
}