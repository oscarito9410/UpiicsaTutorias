package com.booleansystems.tutorias.ui.home.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.base.BaseFragment
import com.booleansystems.tutorias.databinding.FragmentNewsBinding
import com.booleansystems.tutorias.ui.home.news.view.NewsAdapter
import com.prof.rssparser.Article
import kotlinx.android.synthetic.main.fragment_news.*

/**

Created by oscar on 19/04/19
operez@na-at.com.mx
 */
class NewsFragment : BaseFragment(), Observer<MutableList<Article>> {

    var mBinding: FragmentNewsBinding? = null

    var mAdapter: NewsAdapter? = null


    override fun getResourceLayout(): Int {
        return R.layout.fragment_news
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentNewsBinding.inflate(layoutInflater, container, false)
        val viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        mBinding!!.viewModel = viewModel
        mBinding!!.lifecycleOwner = this
        return mBinding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mBinding!!.viewModel!!.loadNews()
        mBinding!!.viewModel!!.getArticleList().observe(this, this)
        mBinding!!.viewModel!!.isLoading.observe(this, Observer { t ->
            if (t) showProgressDialog(R.string.app_name) else hideProgressDialog()
        })
    }

    override fun onChanged(t: MutableList<Article>?) {
        mAdapter = NewsAdapter(context!!, t!!.toMutableList().toList())
        rvListNews.layoutManager = LinearLayoutManager(context!!)
        rvListNews.adapter = mAdapter
    }


}