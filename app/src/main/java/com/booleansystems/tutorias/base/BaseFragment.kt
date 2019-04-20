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
import com.booleansystems.tutorias.R

/**

Created by oscar on 27/01/19
operez@na-at.com.mx
 */
abstract class BaseFragment : Fragment() {
    var mProgressDialog: BaseLoaderDialog? = null


    protected var rootView: View? = null


    abstract fun getResourceLayout(): Int


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(getResourceLayout(), container, false)
        return rootView!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


    fun showSingleToast(@StringRes message: Int) {
        Toast.makeText(context!!, message, Toast.LENGTH_LONG).show()
    }

    fun showProgressDialog(resMsg: Int) {
        if (mProgressDialog != null) {
            mProgressDialog!!.setTitle(getString(R.string.app_name))
            mProgressDialog!!.show()
        } else {
            mProgressDialog = BaseLoaderDialog(context!!)
            mProgressDialog!!.setTitle(getString(R.string.app_name))
            mProgressDialog!!.show()
        }
    }

    fun hideProgressDialog() {
        if (mProgressDialog!!.isShowing()) {
            mProgressDialog!!.dismiss()
        }
    }

    fun goActivity(clazz: Class<out AppCompatActivity>) {
        val intent = Intent(activity, clazz)
        startActivity(intent)
    }


}