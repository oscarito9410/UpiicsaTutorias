package com.booleansystems.tutorias.view.home.search.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.booleansystems.domain.SubjectEntity
import com.booleansystems.tutorias.utils.IListenerClickItem
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Predicate
import kotlinx.android.synthetic.main.item_search_result.view.*


/**

Created by oscar on 20/04/19
operez@na-at.com.mx
 */
class SearchAdapter(iListenerClickItem: IListenerClickItem, context: Context, list: List<SubjectEntity>) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    var mList: MutableList<SubjectEntity>? = null

    var mOriginalList: MutableList<SubjectEntity>? = null

    var querySearch: String = ""

    var mContext: Context? = null

    var mLayoutInflater: LayoutInflater? = null

    var mDisaposable: Disposable? = null

    private var iListenerClickItem = iListenerClickItem;

    init {
        mContext = context
        mLayoutInflater = LayoutInflater.from(mContext)
        mList = list.toMutableList()
        mOriginalList = list.toMutableList()

    }


    fun filter(query: String) {
        querySearch = query.toLowerCase()
        if (query.isEmpty()) {
            mList!!.clear()
            mList!!.addAll(mOriginalList!!)
            notifyDataSetChanged()
        } else {
            mDisaposable = Observable.fromIterable(mList).filter(Predicate {
                return@Predicate it.nombre.toLowerCase().startsWith(query.toLowerCase()) || it.nombre
                    .toLowerCase().contains(query.toLowerCase())
            }).toList().subscribe(Consumer {
                mList!!.clear()
                mList!!.addAll(it)
                if (mDisaposable != null)
                    mDisaposable!!.dispose()

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
        holder.itemView.setOnClickListener {
            iListenerClickItem.onItemClicked(holder.itemView, mList!!.get(position))
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(item: SubjectEntity, querySearch: String) {
            itemView.tvSearchSubject.text = item.nombre
        }
    }
}