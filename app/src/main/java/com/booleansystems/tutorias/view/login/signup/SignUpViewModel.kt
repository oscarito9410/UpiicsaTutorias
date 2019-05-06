package com.booleansystems.tutorias.view.login.signup

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.domain.SubjectEntity
import com.booleansystems.domain.UserEntity
import com.booleansystems.interactors.SignUpUserInteractor
import com.booleansystems.tutorias.Constants
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.dependencies.SingleLiveEvent

/**
 * Created by oscar on 18/04/19
 * operez@na-at.com.mx
 */
open class SignUpViewModel(val signUpUser: SignUpUserInteractor) : ViewModel(), IBaseResultListener<SubjectEntity> {

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

        if (isCorrectInfo.value!!) {
            signUpUser.invoke(UserEntity(), this)
        }

    }

    override fun onSuccess(response: SubjectEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(error: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
