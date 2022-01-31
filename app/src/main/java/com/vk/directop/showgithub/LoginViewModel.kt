package com.vk.directop.showgithub

import android.util.Log
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    fun loginClicked(){
        Log.d("MyTag", "login clicked in view model")
    }
}