package com.booleansystems.tutorias.view.home.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.booleansystems.domain.SubjectEntity
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.base.BaseFragment
import com.booleansystems.tutorias.databinding.FragmentSearchBinding
import com.booleansystems.tutorias.utils.IListenerClickItem
import com.booleansystems.tutorias.view.home.search.view.SearchAdapter
import kotlinx.android.synthetic.main.fragment_search.*


/**

Created by oscar on 19/04/19
operez@na-at.com.mx
 */
class SearchFragment : BaseFragment(), Observer<MutableList<SubjectEntity>>, SearchView.OnQueryTextListener,
    IListenerClickItem {

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

    override fun onChanged(t: MutableList<SubjectEntity>?) {
        mAdapter = SearchAdapter(this, context!!, t!!.toList())
        rvListSearch.layoutManager = LinearLayoutManager(context!!)
        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        rvListSearch.addItemDecoration(dividerItemDecoration)
        rvListSearch.adapter = mAdapter
    }

    override fun onItemClicked(view: View, item: Any) {
        Navigation.findNavController(view).navigate(R.id.action_searchFragment_to_detailFragment)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        filterAdapter(query)
        return true;
    }

    override fun onQueryTextChange(query: String?): Boolean {
        filterAdapter(query)
        return true
    }

    fun filterAdapter(query: String?) {
        mAdapter!!.filter(query!!)

    }
}