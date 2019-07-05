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
            const val IFRAME_FACEBOOK = "<div align=\"center\">\n" +
                    "<iframe src=\"https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2FCoordinacion.Tutorias.Upiicsa%2F%3F__tn__%3D%252Cd%252CP-R%26eid%3DARCnHR6YHFoQeW_GnLjc9A7BNEmBZukmm-IcEnKrOP8whLGqMuekStFMYUJtWTawkR3T3NIPGPY38Gca&tabs=timeline&width=340&height=1000&small_header=false&adapt_container_width=true&hide_cover=false&show_facepile=true&appId=926010197556607\" width=\"340\" height=\"1000\" style=\"border:none;overflow:hidden\" scrolling=\"no\" frameborder=\"0\" allowTransparency=\"true\" allow=\"encrypted-media\"></iframe>\n" +
                    "</div>"
        }
    }
}