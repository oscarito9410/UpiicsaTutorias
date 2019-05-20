package com.booleansystems.tutorias.base

import androidx.lifecycle.Observer
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.utils.Utils
import com.google.android.material.textfield.TextInputLayout

/**
 * Created by oscar on 18/04/19
 * operez@na-at.com.mx
 */
class BaseFieldObserver(val inputLayout: TextInputLayout?, val message: Int = R.string.text_field_required) :
    Observer<Boolean> {


    override fun onChanged(t: Boolean?) {
        if (t != null)
            Utils.notifyFieldIsCorrect(inputLayout!!.context, inputLayout, t, message)
    }


}
