package com.booleansystems.tutorias.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_sign_in.*

/**

Created by oscar on 14/04/19
operez@na-at.com.mx
 */
class SignInFragment : BaseFragment(), View.OnClickListener {


    override fun getResourceLayout(): Int {
        return R.layout.fragment_sign_in;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvSignUp.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        Navigation.findNavController(v!!).navigate(R.id.action_signInFragment_to_signUpFragment)
    }
}