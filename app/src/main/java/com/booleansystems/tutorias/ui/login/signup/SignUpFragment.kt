package com.booleansystems.tutorias.ui.login.signup

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.base.BaseFieldObserver
import com.booleansystems.tutorias.base.BaseFragment
import com.booleansystems.tutorias.databinding.FragmentSignUpBinding
import kotlinx.android.synthetic.main.fragment_sign_up.*

/**

Created by oscar on 14/04/19
operez@na-at.com.mx
 */
class SignUpFragment : BaseFragment() {

    var mBinding: FragmentSignUpBinding? = null


    override fun getResourceLayout(): Int {
        return R.layout.fragment_sign_up
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentSignUpBinding.inflate(layoutInflater, container, false)
        val viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)
        mBinding!!.viewModel = viewModel
        mBinding!!.lifecycleOwner = this
        return mBinding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        mBinding!!.viewModel!!.errorBoleta.observe(this, BaseFieldObserver(ilBoletaSignUp))
        mBinding!!.viewModel!!.errorName.observe(this, BaseFieldObserver(ilNameSignUp))
        mBinding!!.viewModel!!.errorLastName.observe(this, BaseFieldObserver(ilLastNameSignUp))
        mBinding!!.viewModel!!.errorMotherLastName.observe(this, BaseFieldObserver(ilMotherLastNameSignUp))
        mBinding!!.viewModel!!.errorPassword.observe(this, BaseFieldObserver(ilPasswordSignUp))
        mBinding!!.viewModel!!.errorConfirmPassword.observe(this, BaseFieldObserver(ilPasswordConfirmSignUp,
            R.string.error_confirm_password))
        super.onActivityCreated(savedInstanceState)

    }
}

