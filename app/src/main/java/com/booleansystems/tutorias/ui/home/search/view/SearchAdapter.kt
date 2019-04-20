package com.booleansystems.tutorias.ui.home.search.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.booleansystems.tutorias.ui.home.search.model.SearchResponse
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Predicate
import kotlinx.android.synthetic.main.item_search_result.view.*


/**

Created by oscar on 20/04/19
operez@na-at.com.mx
 */
@SuppressLint("CheckResult")
class SearchAdapter(context: Context, list: List<SearchResponse>) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    var mList: MutableList<SearchResponse>? = null

    var mOriginalList: MutableList<SearchResponse>? = null

    var querySearch: String = ""

    var mContext: Context? = null

    var mLayoutInflater: LayoutInflater? = null

    init {
        mContext = context
        mLayoutInflater = LayoutInflater.from(mContext)
        mList = list.toMutableList()
        mOriginalList = list.toMutableList()

    }


    fun filter(query: String) {
        querySearch = query.toLowerCase()
        if (query.isNullOrEmpty()) {
            mList!!.clear()
            mList!!.addAll(mOriginalList!!)
            notifyDataSetChanged()
        } else {
            Observable.fromIterable(mList).filter(Predicate {
                return@Predicate it.nombre.toLowerCase().startsWith(query.toLowerCase()) || it.nombre
                    .toLowerCase().contains(query.toLowerCase())
            }).toList().subscribe(Consumer {
                mList!!.clear()
                mList!!.addAll(it)
                notifyDataSetChanged()
            })
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            mLayoutInflater!!.inflate(
                com.booleansystems.tutorias.R.layout.item_search_result,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mList!!.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(mList!![position], querySearch)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(item: SearchResponse, querySearch: String) {
            itemView.tvSearchSubject.text = item.nombre
        }
    }
}