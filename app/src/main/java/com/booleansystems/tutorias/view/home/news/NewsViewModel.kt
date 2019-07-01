package com.booleansystems.tutorias.view.home.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.booleansystems.tutorias.utils.Constants
import com.prof.rssparser.Article
import com.prof.rssparser.OnTaskCompleted
import com.prof.rssparser.Parser

/**
 * Created by oscar on 19/04/19
 * operez@na-at.com.mx
 */
class NewsViewModel : ViewModel(), OnTaskCompleted {


    lateinit var listArticles: MutableLiveData<MutableList<Article>>

    val isLoading = MutableLiveData<Boolean>()

    var originaListArticles = arrayListOf<Article>().toMutableList()

    init {
        isLoading.value = false
    }


    fun loadNews() {
        if (originaListArticles.isNullOrEmpty()) {
            val parser = Parser()
            parser.onFinish(this)
            parser.execute(Constants.APIConfig.URL_FEED)
        } else {
            setArticleList(originaListArticles)
        }

    }

    override fun onError(e: Exception) {
        isLoading.value = false
    }

    override fun onTaskCompleted(list: MutableList<Article>) {
        originaListArticles = list
        setArticleList(list)
        isLoading.value = false
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
