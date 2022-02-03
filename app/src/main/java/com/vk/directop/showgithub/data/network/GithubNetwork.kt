package com.vk.directop.showgithub.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubNetwork : GithubApi {


    override suspend fun getUserRepos(username: String): List<RepoDTO> {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(GithubApi.BASE_URL)
            .build()
            .create(GithubApi::class.java).getUserRepos(username = username)
    }

    override suspend fun login(username : String): List<RepoDTO> {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(GithubApi.BASE_URL)
            .build()
            .create(GithubApi::class.java).login(username = username)//, authHeader = authHeader)
    }


}

/*
Basic authentication
$ curl -u "username" https://api.github.com
OAuth2 token (sent in a header)
$ curl -H "Authorization: token OAUTH-TOKEN" https://api.github.com
 */