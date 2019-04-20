package com.booleansystems.tutorias.ui.home.news.view

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.Utils
import com.prof.rssparser.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home_new.view.*

/**

Created by oscar on 19/04/19
operez@na-at.com.mx
 */
class NewsAdapter(val context: Context, val listArticles: List<Article>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var mContext = context

    private var mLayoutInflater: LayoutInflater? = null

    private var mListArticles = listArticles

    init {
        mLayoutInflater = LayoutInflater.from(mContext)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(mLayoutInflater!!.inflate(R.layout.item_home_new, parent, false))
    }

    override fun getItemCount(): Int {
        return mListArticles.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(mListArticles[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(article: Article) {
            val finalImage = article.image.replace("&amp;", "&")
            val finalDescription = article.description.replace("(Feed generated with <a href=\"http://fetchrss.com\" target=\"_blank\">FetchRSS</a>)", "")
            Picasso.get().load(finalImage).into(itemView.imgNew)
            itemView.tvNewTitle.text = article.title
            itemView.tvNewDescription.text = Utils.removeTags(finalDescription)!!.trimEnd()
        }

    }
}