package com.booleansystems.tutorias

import android.content.Context
import androidx.annotation.StringRes
import com.google.android.material.textfield.TextInputLayout

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
    }


}
