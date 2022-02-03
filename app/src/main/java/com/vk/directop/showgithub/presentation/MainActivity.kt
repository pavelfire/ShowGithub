package com.vk.directop.showgithub.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.vk.directop.showgithub.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = this.findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }

}

//https://docs.github.com/en
//https://kmm.icerock.dev/university/android-basics/practice
//https://api.github.com/users/octocat/repos

//https://yandex.ru/search/?clid=1882628&text=curl+-i+-u+your_username%3Ayour_token+https%3A%2F%2Fapi.github.com%2Fuser+to+get+retrofit&l10n=ru&lr=47
//https://www.andreyolegovich.ru/testing/api/github.php