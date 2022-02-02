package com.vk.directop.showgithub.presentation.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _eventLogin = MutableLiveData<Boolean>()
    val eventLogin: LiveData<Boolean>
        get() = _eventLogin

    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Empty)
    val loginUiState : StateFlow<LoginUiState> = _loginUiState

    fun login(username: String, token: String) = viewModelScope.launch {
        _loginUiState.value = LoginUiState.Loading
        delay(2000L)
        if(username == "and" && token == "and"){
            _loginUiState.value = LoginUiState.Success
            _eventLogin.value = true
        }else if(username.isEmpty() || token.isEmpty()){
            _loginUiState.value = LoginUiState.Error("Username and token must not be empty.")
        }else{
            _loginUiState.value = LoginUiState.Error("Wrong credentials.")
        }
    }

    sealed class LoginUiState {
        object Success : LoginUiState()
        data class Error(val message: String) : LoginUiState()
        object Loading : LoginUiState()
        object Empty : LoginUiState()
    }

    fun loginClicked(){
        Log.d("MyTag", "login clicked in view model")
    }
}