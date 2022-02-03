package com.vk.directop.showgithub.presentation.list_repo

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
import kotlinx.coroutines.launch

class ListRepoViewModel : ViewModel() {

    private val githubApi: GithubApi by lazy { GithubNetwork() }
    private val githubRepository by lazy { GithubRepositoryImpl(githubApi) }
    private val getReposUseCase by lazy { GetReposUseCase(githubRepository) }

    private val _response = MutableLiveData<List<RepoDomain>>()
    val response: LiveData<List<RepoDomain>>
        get() = _response

    fun getName(name: String): String {
        Log.d("MyTag", "name:::::::: $name")
        return if (name.isNotEmpty()) {
            name
        } else {
            "pavelfire"
        }
    }

    fun fillList(name: String){
        viewModelScope.launch {
            val dataList = getReposUseCase.execute(name = getName(name))
            Log.d("MyTag", "received: $dataList")
            _response.value = dataList
        }
    }


}