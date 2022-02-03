package com.vk.directop.showgithub.data.network


import android.util.Base64
import android.util.Base64.encodeToString
import retrofit2.http.GET
import retrofit2.http.Query
import java.io.UnsupportedEncodingException
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit

import okhttp3.Interceptor

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.http.Header
import retrofit2.http.Path


interface GithubApi {

    @GET("/users/{username}/repos")
    suspend fun getUserRepos(
        @Path("username") username: String
    ) : List<RepoDTO>


    @GET("/users/{username}/repos")
    suspend fun login(
        @Path("username") username: String,
        //@Header("Authorization") authHeader: String
    ) : List<RepoDTO>


    companion object{
        const val BASE_URL = "https://api.github.com"
    }


    @Throws(UnsupportedEncodingException::class)
    fun getBase64String(value: String): String? {
        return Base64.encodeToString(value.toByteArray(charset("UTF-8")), Base64.NO_WRAP)
    }

}
//https://docs.github.com/en