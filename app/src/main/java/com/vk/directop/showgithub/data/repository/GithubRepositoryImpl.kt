package com.vk.directop.showgithub.data.repository

import com.vk.directop.showgithub.data.network.GithubApi
import com.vk.directop.showgithub.data.network.RepoDTO
import com.vk.directop.showgithub.domain.repository.GithubRepository

class GithubRepositoryImpl(private val githubApi: GithubApi) : GithubRepository {
    override suspend fun getUserRepos(name: String): List<RepoDTO> {
        val result = githubApi.getRepos(name)
        return result
    }
}