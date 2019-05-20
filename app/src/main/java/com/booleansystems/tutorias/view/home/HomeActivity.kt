package com.booleansystems.tutorias.view.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.booleansystems.tutorias.R
import com.booleansystems.tutorias.view.home.search.SearchFragment
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.booleansystems.tutorias.R.layout.activity_home)
        fabSearch.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val ft = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        if (ft !is SearchFragment) {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            navHostFragment.navController.navigate(R.id.action_newsFragment_to_searchFragment)
        }

    }
}
