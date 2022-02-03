package com.vk.directop.showgithub.domain.repository

import com.vk.directop.showgithub.domain.model.RepoDomain

interface GithubRepository {

    suspend fun getUserRepos(name: String): List<RepoDomain>

    suspend fun login(username: String, token: String): List<RepoDomain>
}