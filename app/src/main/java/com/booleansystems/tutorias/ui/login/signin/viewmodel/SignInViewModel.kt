package com.booleansystems.tutorias.ui.login.signin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.view.View
import com.booleansystems.tutorias.Constants.Companion.MAX_LENGTH_BOLETA
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.dependencies.PreferenceHelper
import com.booleansystems.tutorias.dependencies.SingleLiveEvent

/**

Created by oscar on 14/04/19
operez@na-at.com.mx
 */
class SignInViewModel(val preferenceHelper: PreferenceHelper) : ViewModel() {

    val password = MutableLiveData<String>()

    val boleta = MutableLiveData<String>()

    val errorBoleta = MutableLiveData<Boolean>()

    val errorPassword = MutableLiveData<Boolean>()

    val isCorrectInfo = MutableLiveData<Boolean>()

    val toastMessageEvent = SingleLiveEvent<Int>()

    init {
        isCorrectInfo.value = false
    }

    open fun onSignUp(v: View) {
        errorBoleta.value = boleta.value.isNullOrEmpty() || boleta.value!!.count() < MAX_LENGTH_BOLETA
        errorPassword.value = password.value.isNullOrEmpty()

        if (errorBoleta.value!!)
            toastMessageEvent.value = R.string.error_min_length_boleta

        if (!errorBoleta.value!! && !errorPassword.value!!)

            isCorrectInfo.value = true
    }


}