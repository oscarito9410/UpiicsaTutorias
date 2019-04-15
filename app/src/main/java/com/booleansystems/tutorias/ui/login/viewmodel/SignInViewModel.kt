package com.booleansystems.tutorias.ui.login.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.view.View

/**

Created by oscar on 14/04/19
operez@na-at.com.mx
 */
class SignInViewModel : ViewModel() {

    private val mPassword = MutableLiveData<String>()

    private val mBoleta = MutableLiveData<String>()

    private val mErrorBoleta = MutableLiveData<Boolean>()

    private val mErrorPassword = MutableLiveData<Boolean>()

    fun cleanPassword(v: View) {
        mPassword.value = ""
    }

    open fun onSignUp(v: View) {
        mErrorBoleta.value = mBoleta.value.isNullOrEmpty()
        mErrorPassword.value = mPassword.value.isNullOrEmpty()

        if (!mErrorBoleta.value!! && !mErrorPassword.value!!) {

        }
    }

    fun getPassword(): MutableLiveData<String> {
        return mPassword
    }

    fun getBoleta(): MutableLiveData<String> {
        return mBoleta
    }

    fun getErrorBoleta(): MutableLiveData<Boolean> {
        return mErrorBoleta
    }

    fun getErrorPassword(): MutableLiveData<Boolean> {
        return mErrorPassword
    }


    // private var mClient: MutableLiveData<ClientEnlaceBean>? = null


    /*
    fun getClient(): LiveData<ClientEnlaceBean> {
        if (mClient == null) {
            mClient = MutableLiveData<ClientEnlaceBean>()
            mClient!!.setValue(Session.getInstance().getSessionBean())
        }
        return mClient
    }*/

}