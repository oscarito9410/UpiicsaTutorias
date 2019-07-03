package com.booleansystems.tutorias.view.home.profile

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.base.BaseFragment
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.android.synthetic.main.fragment_profile.*
import java.lang.Exception

/**
 * Created by Oscar Emilio Pérez Mtz on 02/07/2019.
operez@na-at.com.mx
 */
class ProfileFragment : BaseFragment() {

    lateinit var target: Target

    override fun getResourceLayout(): Int {
        return R.layout.fragment_profile
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