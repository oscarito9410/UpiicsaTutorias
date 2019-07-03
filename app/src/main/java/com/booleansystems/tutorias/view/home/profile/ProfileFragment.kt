package com.booleansystems.tutorias.view.home.profile

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.base.BaseFragment
import com.booleansystems.tutorias.databinding.FragmentProfileBinding
import com.booleansystems.tutorias.databinding.FragmentSignInBinding
import com.booleansystems.tutorias.view.login.signin.viewmodel.SignInViewModel
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.android.viewmodel.ext.android.getViewModel
import java.lang.Exception

/**
 * Created by Oscar Emilio Pérez Mtz on 02/07/2019.
operez@na-at.com.mx
 */
class ProfileFragment : BaseFragment() {

    lateinit var target: Target

    var mBinding: FragmentProfileBinding? = null


    override fun getResourceLayout(): Int {
        return R.layout.fragment_profile
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        val viewModel = getViewModel<ProfileViewModel>()

        mBinding?.let {
            it.viewModel = viewModel
            it.lifecycleOwner = this
        }
        viewModel.user.observe(this, Observer {
            tv_profile_name.text = it.name
            tv_profile_boleta.text = it.boleta
        })
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        target = object : Target {
            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                print("Prepare load")
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                print("Failed")
            }

            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                cl_cardview_container.background = BitmapDrawable(context?.resources, bitmap)
            }

        }
        Picasso.get().load(R.drawable.minimalist_background).into(target)
        cl_cardview_container.tag = target

    }

}