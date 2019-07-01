package com.booleansystems.tutorias.view.login.signin.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.booleansystems.data.common.IBaseResultListener
import com.booleansystems.domain.common.BaseResponse
import com.booleansystems.domain.common.EnrollResponse
import com.booleansystems.domain.signin.SignInRequest
import com.booleansystems.interactors.signin.SignInUserInteractor
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.dependencies.SingleLiveEvent
import com.booleansystems.tutorias.utils.Constants.Companion.MAX_LENGTH_BOLETA
import retrofit2.HttpException

/**

Created by oscar on 14/04/19
operez@na-at.com.mx
 */
open class SignInViewModel(val signInUserInteractor: SignInUserInteractor) : ViewModel(),
    IBaseResultListener<EnrollResponse> {

    val password = MutableLiveData<String>()

    val boleta = MutableLiveData<String>()

    val errorBoleta = MutableLiveData<Boolean>()

    val errorPassword = MutableLiveData<Boolean>()

    val isCorrectInfo = MutableLiveData<Boolean>()


    var mIsLoading = SingleLiveEvent<Boolean>()

    val mSuccessSignIn = MutableLiveData<Boolean>()

    val mToastMessageEvent = SingleLiveEvent<Int>()

    val mRestServiceMessage = SingleLiveEvent<String>()

    init {
        isCorrectInfo.value = false
    }

    open fun onLoad() {
        if (signInUserInteractor.invoke())
            mSuccessSignIn.postValue(true)
    }

    open fun onSignUp(v: View) {
        errorBoleta.value = boleta.value.isNullOrEmpty() || boleta.value!!.count() < MAX_LENGTH_BOLETA
        errorPassword.value = password.value.isNullOrEmpty()

        if (errorBoleta.value!!)
            mToastMessageEvent.value = R.string.error_min_length_boleta

        if (!errorBoleta.value!! && !errorPassword.value!!) {

            val signInRequest = SignInRequest(
                boleta.value,
                password.value
            )

            mIsLoading.postValue(true)
            signInUserInteractor.invoke(signInRequest, this)

        }
    }

    override fun onSuccess(response: EnrollResponse) {
        mRestServiceMessage.postValue(response.message)
        mSuccessSignIn.postValue(true)
        mIsLoading.postValue(false)
    }

    override fun onError(error: Throwable) {

        if (error is HttpException) {
            when (error.code()) {
                404 -> {
                    mToastMessageEvent.postValue(R.string.student_not_found)
                }
            }
        }
        mIsLoading.postValue(false)
        mSuccessSignIn.postValue(false)
    }


}