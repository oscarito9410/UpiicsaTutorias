package com.booleansystems.tutorias.ui.login.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.view.View
import com.booleansystems.tutorias.Constants
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.dependencies.SingleLiveEvent

/**
 * Created by oscar on 18/04/19
 * operez@na-at.com.mx
 */
class SignUpViewModel : ViewModel() {
    val boleta = MutableLiveData<String>()
    val name = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val motherLastName = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val confirmPassword = MutableLiveData<String>()

    val errorBoleta = MutableLiveData<Boolean>()
    val errorName = MutableLiveData<Boolean>()
    val errorLastName = MutableLiveData<Boolean>()
    val errorMotherLastName = MutableLiveData<Boolean>()
    val errorPassword = MutableLiveData<Boolean>()
    val errorConfirmPassword = MutableLiveData<Boolean>()

    val isCorrectInfo = MutableLiveData<Boolean>()

    val toastMessageEvent = SingleLiveEvent<Int>()

    init {
        isCorrectInfo.value = false
    }


    open fun onSignUp(v: View) {
        errorBoleta.value = boleta.value.isNullOrEmpty() || boleta.value!!.count() < Constants.MAX_LENGTH_BOLETA
        errorName.value = name.value.isNullOrEmpty()
        errorLastName.value = lastName.value.isNullOrEmpty()
        errorMotherLastName.value = motherLastName.value.isNullOrEmpty()
        errorConfirmPassword.value = !password.value.equals(confirmPassword.value)
        errorPassword.value = password.value.isNullOrEmpty()

        if (errorBoleta.value!!)
            toastMessageEvent.value = R.string.error_min_length_boleta


        isCorrectInfo.value = !errorBoleta.value!! &&
                !errorName.value!! && !errorLastName.value!! &&
                !errorMotherLastName.value!! &&
                !errorPassword.value!! &&
                !errorConfirmPassword.value!!

    }


}
