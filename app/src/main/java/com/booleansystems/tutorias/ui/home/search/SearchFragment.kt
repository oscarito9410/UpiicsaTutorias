package com.booleansystems.tutorias.ui.home.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.base.BaseFragment
import com.booleansystems.tutorias.databinding.FragmentSearchBinding
import com.booleansystems.tutorias.ui.home.search.model.SearchResponse
import com.booleansystems.tutorias.ui.home.search.view.SearchAdapter
import kotlinx.android.synthetic.main.fragment_search.*


/**

Created by oscar on 19/04/19
operez@na-at.com.mx
 */
class SearchFragment : BaseFragment(), Observer<MutableList<SearchResponse>>, SearchView.OnQueryTextListener {

    var mBinding: FragmentSearchBinding? = null

    var mAdapter: SearchAdapter? = null

    override fun getResourceLayout(): Int {
        return R.layout.fragment_search
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        val viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        mBinding!!.viewModel = viewModel
        mBinding!!.lifecycleOwner = this
        return mBinding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        searchViewFilter.setOnQueryTextListener(this)
        mBinding!!.viewModel!!.loadDummyData()
        mBinding!!.viewModel!!.listSearchResults.observe(this, this)
    }

    override fun onChanged(t: MutableList<SearchResponse>?) {
        mAdapter = SearchAdapter(context!!, t!!.toList())
        rvListSearch.layoutManager = LinearLayoutManager(context!!)
        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        rvListSearch.addItemDecoration(dividerItemDecoration)
        rvListSearch.adapter = mAdapter
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        mAdapter!!.filter(query!!)
        return true;
    }

    override fun onQueryTextChange(query: String?): Boolean {
        mAdapter!!.filter(query!!)
        return true
    }
}