package com.vk.directop.showgithub.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubNetwork : GithubApi {


    override suspend fun getRepos(name: String): List<RepoDTO> {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(GithubApi.BASE_URL)
            .build()
            .create(GithubApi::class.java).getRepos(name)
    }

    override suspend fun getPVRepos(code: String, page: Int): List<RepoDTO> {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(GithubApi.BASE_URL)
            .build()
            .create(GithubApi::class.java).getPVRepos("user", 1)
    }
}