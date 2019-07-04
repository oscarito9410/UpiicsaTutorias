package com.booleansystems.tutorias.view.login.splash

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.base.BaseFragment
import com.booleansystems.tutorias.view.login.signin.viewmodel.SignInViewModel
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.android.synthetic.main.fragment_splash.*
import kotlinx.coroutines.*
import org.koin.android.viewmodel.ext.android.getViewModel
import java.util.concurrent.TimeUnit

/**
 * Created by Oscar Emilio Pérez Mtz on 03/07/2019.
operez@na-at.com.mx
 */
class SplashFragment : BaseFragment() {

    override fun getResourceLayout(): Int {
        return R.layout.fragment_splash
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val target = object : Target {
            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                print("Prepare load")
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                print("Failed")
            }

            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                splashParentLayout.background = BitmapDrawable(context?.resources, bitmap)
            }

        }
        Picasso.get().load(R.drawable.minimalist_background).into(target)
        splashParentLayout.tag = target
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        val viewModel = getViewModel<SignInViewModel>()
        viewModel.mSuccessSignIn.observe(this, Observer {
            if (it) notifyNavigateHome()
            else
                view?.let {
                    val controller =
                        Navigation.findNavController(it)
                    controller.navigate(R.id.action_fragmentSplash_to_signInFragment)
                }
        })

        CoroutineScope(Dispatchers.IO).launch {
            delay(TimeUnit.SECONDS.toMillis(5))
            withContext(Dispatchers.Main) {
                viewModel.onLoad()
            }
        }
        super.onActivityCreated(savedInstanceState)
    }
}
