package com.booleansystems.tutorias.view.login.signup

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.domain.common.BaseResponse
import com.booleansystems.domain.signup.SignUpRequest
import com.booleansystems.interactors.signup.SignUpUserInteractor
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.dependencies.SingleLiveEvent
import com.booleansystems.tutorias.utils.Constants
import com.google.gson.Gson
import retrofit2.HttpException

/**
 * Created by oscar on 18/04/19
 * operez@na-at.com.mx
 */
open class SignUpViewModel(val signUpUser: SignUpUserInteractor) : ViewModel(), IBaseResultListener<BaseResponse> {

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

    val mIsCorrectInfo = MutableLiveData<Boolean>()
    val mSuccessSignUp = MutableLiveData<Boolean>()
    val mToastMessageEvent = SingleLiveEvent<Int>()
    val mRestServiceMessage = SingleLiveEvent<String>()
    var mIsLoading = SingleLiveEvent<Boolean>()

    init {
        mIsCorrectInfo.value = false
    }


    open fun onSignUp(v: View) {
        errorBoleta.value = boleta.value.isNullOrEmpty() || boleta.value!!.count() < Constants.MAX_LENGTH_BOLETA
        errorName.value = name.value.isNullOrEmpty()
        errorLastName.value = lastName.value.isNullOrEmpty()
        errorMotherLastName.value = motherLastName.value.isNullOrEmpty()
        errorConfirmPassword.value = !password.value.equals(confirmPassword.value)
        errorPassword.value = password.value.isNullOrEmpty()

        if (errorBoleta.value!!)
            mToastMessageEvent.value = R.string.error_min_length_boleta


        mIsCorrectInfo.value = !errorBoleta.value!! &&
                !errorName.value!! && !errorLastName.value!! &&
                !errorMotherLastName.value!! &&
                !errorPassword.value!! &&
                !errorConfirmPassword.value!!

        if (mIsCorrectInfo.value!!) {

            mIsLoading.postValue(true)

            val signUpRequest = SignUpRequest(
                boleta.value!!,
                name.value!!, password.value!!,
                lastName.value!!, motherLastName.value!!, 1
            )

            signUpUser.invoke(signUpRequest, this)
        }

    }


    override fun onSuccess(response: BaseResponse) {
        mRestServiceMessage.postValue(response.message)
        mSuccessSignUp.postValue(true)
        mIsLoading.postValue(false)
    }

    override fun onError(error: Throwable) {
        if (error is HttpException) {
            when (error.code()) {
                409 -> {
                    val response = Gson().newBuilder().create()
                        .fromJson(error.response().errorBody()!!.string(), BaseResponse::class.java)
                    mRestServiceMessage.postValue(response.message)
                }
                else -> {
                    mRestServiceMessage.postValue(error.message)
                }
            }
        }
        mSuccessSignUp.postValue(false)
        mIsLoading.postValue(false)
    }

}
