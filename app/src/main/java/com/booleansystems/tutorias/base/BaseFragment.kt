package com.booleansystems.tutorias.base

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**

Created by oscar on 27/01/19
operez@na-at.com.mx
 */
abstract class BaseFragment : android.support.v4.app.Fragment() {


    protected var rootView: View? = null


    abstract fun getResourceLayout(): Int


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(getResourceLayout(), container, false)
        return rootView!!
    }

    fun goActivity(clazz: Class<out AppCompatActivity>) {
        val intent = Intent(activity, clazz)
        startActivity(intent)
    }


}