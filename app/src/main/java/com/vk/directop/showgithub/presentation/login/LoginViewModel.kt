package com.vk.directop.showgithub.presentation.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vk.directop.showgithub.data.network.GithubApi
import com.vk.directop.showgithub.data.network.GithubNetwork
import com.vk.directop.showgithub.data.repository.GithubRepositoryImpl
import com.vk.directop.showgithub.domain.model.RepoDomain
import com.vk.directop.showgithub.domain.usecase.GetReposUseCase
import com.vk.directop.showgithub.domain.usecase.LoginUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _eventLogin = MutableLiveData<Boolean>()
    val eventLogin: LiveData<Boolean>
        get() = _eventLogin

    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Empty)
    val loginUiState: StateFlow<LoginUiState> = _loginUiState

    private val githubApi: GithubApi by lazy { GithubNetwork() }
    private val githubRepository by lazy { GithubRepositoryImpl(githubApi) }
    private val loginUseCase by lazy { LoginUseCase(githubRepository) }

    private val _response = MutableLiveData<List<RepoDomain>>()
    val response: LiveData<List<RepoDomain>>
        get() = _response


    fun login(username: String, token: String) = viewModelScope.launch {
        _loginUiState.value = LoginUiState.Loading
        //delay(1300L)

        if (username == "and" && token == "and") {
            //if (username.isNotEmpty() && token.isNotEmpty()) {

            _loginUiState.value = LoginUiState.Success
            _eventLogin.value = true
        } else if (username.isNotEmpty() && token.isEmpty()) {

            viewModelScope.launch {
                val dataList = loginUseCase.execute(name = username, token = token)
                Log.d("MyTag", "received: $dataList")
                //_response.value = dataList
            }

            _loginUiState.value = LoginUiState.Success
            _eventLogin.value = true
        } else if (username.isEmpty() || token.isEmpty()) {
            _loginUiState.value = LoginUiState.Error("Username and token must not be empty.")
        } else {
            _loginUiState.value =
                LoginUiState.Error("Wrong credentials! For enter write username: and token: and")
        }
    }

    sealed class LoginUiState {
        object Success : LoginUiState()
        data class Error(val message: String) : LoginUiState()
        object Loading : LoginUiState()
        object Empty : LoginUiState()
    }

    fun loginClicked() {
        Log.d("MyTag", "login clicked in view model")
    }


    init {

    }
}