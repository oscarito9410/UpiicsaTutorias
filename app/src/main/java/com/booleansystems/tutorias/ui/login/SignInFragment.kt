package com.booleansystems.tutorias.ui.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.base.BaseFragment
import com.booleansystems.tutorias.databinding.FragmentSignInBinding
import com.booleansystems.tutorias.ui.login.viewmodel.SignInViewModel
import kotlinx.android.synthetic.main.fragment_sign_in.*

/**

Created by oscar on 14/04/19
operez@na-at.com.mx
 */
class SignInFragment : BaseFragment(), View.OnClickListener {

    var mBinding: FragmentSignInBinding? = null

    override fun getResourceLayout(): Int {
        return R.layout.fragment_sign_in
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentSignInBinding.inflate(layoutInflater, container, false)
        val viewModel = ViewModelProviders.of(this).get(SignInViewModel::class.java)
        mBinding!!.viewModel = viewModel
        mBinding!!.viewModel!!.getErrorBoleta().observe(this, Observer { t ->
            ilBoletaSignUp.isErrorEnabled = t!!
            ilBoletaSignUp.error = if (t) getString(R.string.text_field_required) else null
        })
        mBinding!!.viewModel!!.getErrorPassword().observe(this, Observer { t ->
            ilPasswordSignUp.isErrorEnabled = t!!
            ilPasswordSignUp.error = if (t) getString(R.string.text_field_required) else null
        })

        mBinding!!.lifecycleOwner = this
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvSignUp.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        Navigation.findNavController(v!!).navigate(R.id.action_signInFragment_to_signUpFragment)
    }
}