package com.booleansystems.tutorias.view.home.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.booleansystems.domain.UserEntity

/**
 * Created by Oscar Emilio Pérez Mtz on 02/07/2019.
operez@na-at.com.mx
 */
class ProfileViewModel(userEntity: UserEntity) : ViewModel() {
    val user = MutableLiveData<UserEntity>()

    init {
        user.postValue(userEntity)
    }


}