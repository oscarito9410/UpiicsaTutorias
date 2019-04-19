package com.booleansystems.tutorias.base

import android.content.Intent
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

/**

Created by oscar on 27/01/19
operez@na-at.com.mx
 */
abstract class BaseFragment : Fragment() {


    protected var rootView: View? = null


    abstract fun getResourceLayout(): Int


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(getResourceLayout(), container, false)
        return rootView!!
    }

    fun showSingleToast(@StringRes  message:Int){
        Toast.makeText(context!!,message,Toast.LENGTH_LONG).show()
    }

    fun goActivity(clazz: Class<out AppCompatActivity>) {
        val intent = Intent(activity, clazz)
        startActivity(intent)
    }


}