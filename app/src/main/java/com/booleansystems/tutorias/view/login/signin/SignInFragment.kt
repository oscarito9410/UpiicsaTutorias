package com.booleansystems.tutorias.view.login.signin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.base.BaseFieldObserver
import com.booleansystems.tutorias.base.BaseFragment
import com.booleansystems.tutorias.databinding.FragmentSignInBinding
import com.booleansystems.tutorias.view.home.HomeActivity
import com.booleansystems.tutorias.view.login.signin.viewmodel.SignInViewModel
import kotlinx.android.synthetic.main.fragment_sign_in.*
import org.koin.android.viewmodel.ext.android.getViewModel

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
        val viewModel = getViewModel<SignInViewModel>()
        mBinding!!.viewModel = viewModel
        mBinding!!.lifecycleOwner = this
        return mBinding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        mBinding!!.viewModel!!.onLoad()
        mBinding!!.viewModel!!.errorBoleta.observe(this, BaseFieldObserver(ilBoletaSignIn!!))
        mBinding!!.viewModel!!.errorPassword.observe(this, BaseFieldObserver(ilPasswordSignIn!!))
        mBinding!!.viewModel!!.mToastMessageEvent.observe(this, Observer { t -> showSingleToast(t!!) })
        mBinding!!.viewModel!!.mToastMessageEvent.observe(this, Observer { t -> showSingleToast(t!!) })
        mBinding!!.viewModel!!.mRestServiceMessage.observe(this, Observer {
            showSingleToast(it)
        })
        mBinding!!.viewModel!!.mSuccessSignIn.observe(this, Observer {
            if (it) notifyNavigateHome()
        })
        mBinding!!.viewModel!!.mIsLoading.observe(
            this,
            Observer { if (it) showProgressDialog(R.string.app_name) else hideProgressDialog() })

        super.onActivityCreated(savedInstanceState)
    }

    fun notifyNavigateHome() {
        activity?.apply {
            startActivity(Intent(context, HomeActivity::class.java))
            finish()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvSignUp.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        Navigation.findNavController(v!!).navigate(R.id.action_signInFragment_to_signUpFragment)
    }
}