package com.vk.directop.showgithub.domain.repository

import com.vk.directop.showgithub.data.network.RepoDTO

interface GithubRepository {

    suspend fun getUserRepos(name: String): List<RepoDTO>
}