package com.booleansystems.tutorias

import android.content.Context
import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputLayout
import java.util.Collections.replaceAll
import java.util.regex.Pattern


/**
 * Created by oscar on 14/04/19
 * operez@na-at.com.mx
 */
class Utils {
    companion object {
        fun notifyFieldIsCorrect(
            context: Context, inputLayout: TextInputLayout,
            isErrorEnabled: Boolean, @StringRes stringRes: Int = R.string.text_field_required
        ) {
            inputLayout.isErrorEnabled = isErrorEnabled
            inputLayout.error = if (isErrorEnabled) context.getString(stringRes) else null
        }

        private val REMOVE_TAGS = Pattern.compile("<.+?>")

        fun removeTags(string: String?): String? {
            if (string == null || string.length == 0) {
                return string
            }

            val m = REMOVE_TAGS.matcher(string)
            return m.replaceAll("")
        }
    }


}
