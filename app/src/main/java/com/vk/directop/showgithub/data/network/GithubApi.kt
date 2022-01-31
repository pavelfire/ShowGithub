package com.vk.directop.showgithub.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("/users/octocat/repos")
    suspend fun getRepos(
        @Query("username") name: String

    ): List<RepoDTO>

    @GET("/users/pavelfire/repos")
    suspend fun getPVRepos(
        @Query("code") code: String,
        @Query("p") page: Int
    ): List<RepoDTO>

    companion object{
        const val BASE_URL = "https://api.github.com"
    }
}