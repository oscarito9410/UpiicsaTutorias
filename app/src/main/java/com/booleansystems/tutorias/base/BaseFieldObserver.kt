package com.booleansystems.tutorias.base

import android.arch.lifecycle.Observer
import android.support.annotation.StringRes
import android.support.design.widget.TextInputLayout
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.Utils

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
