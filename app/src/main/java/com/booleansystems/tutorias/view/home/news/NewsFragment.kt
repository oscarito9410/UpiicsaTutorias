package com.booleansystems.tutorias.view.home.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import androidx.lifecycle.ViewModelProviders
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.base.BaseFragment
import com.booleansystems.tutorias.databinding.FragmentNewsBinding
import com.booleansystems.tutorias.utils.Constants
import kotlinx.android.synthetic.main.fragment_news.*

/**

Created by oscar on 19/04/19
operez@na-at.com.mx
 */
class NewsFragment : BaseFragment() {

    var mBinding: FragmentNewsBinding? = null


    override fun getResourceLayout(): Int {
        return R.layout.fragment_news
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentNewsBinding.inflate(layoutInflater, container, false)
        val viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        mBinding?.viewModel = viewModel
        mBinding?.lifecycleOwner = this
        return mBinding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        webViewNews.webChromeClient = WebChromeClient()
        webViewNews.settings?.run {
            this.javaScriptEnabled = true
        }
        webViewNews.loadData(
            Constants.APIConfig.IFRAME_FACEBOOK,
            "text/html", "UTF-8"
        )
    }


}