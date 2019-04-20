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

    lateinit var listArticles: MutableLiveData<MutableList<Article>>

    val isLoading = MutableLiveData<Boolean>()

    var originaListArticles = arrayListOf<Article>()

    init {
        isLoading!!.value = false
    }


    fun loadNews() {
        if (originaListArticles.isNullOrEmpty()) {
            isLoading!!.value = true
            val parser = Parser()
            parser.onFinish(object : Parser.OnTaskCompleted {
                override fun onTaskCompleted(list: ArrayList<Article>) {
                    originaListArticles = list
                    setArticleList(list)
                    isLoading.value = false
                }

                override fun onError() {
                    isLoading.value = false
                }

            })
            parser.execute(Constants.APIConfig.URL_FEED)
        } else {
            setArticleList(originaListArticles)
        }

    }


    fun getArticleList(): MutableLiveData<MutableList<Article>> {
        if (!::listArticles.isInitialized) {
            listArticles = MutableLiveData()
        }
        return listArticles
    }

    private fun setArticleList(articleList: MutableList<Article>) {
        listArticles.postValue(articleList)
    }
}
