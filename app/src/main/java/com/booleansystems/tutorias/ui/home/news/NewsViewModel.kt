package com.booleansystems.tutorias.ui.home.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.booleansystems.tutorias.Constants
import com.prof.rssparser.Article
import com.prof.rssparser.Parser

/**
 * Created by oscar on 19/04/19
 * operez@na-at.com.mx
 */
class NewsViewModel : ViewModel() {

    val listArticles: MutableLiveData<ArrayList<Article>>? = null

    fun loadNews() {
        val parser = Parser()
        parser.onFinish(object : Parser.OnTaskCompleted {
            override fun onTaskCompleted(list: ArrayList<Article>) {
                listArticles!!.value = list
            }

            override fun onError() {
            }

        })
        parser.execute(Constants.APIConfig.URL_FEED)
    }
}
