package com.vk.directop.showgithub.data.repository

import com.vk.directop.showgithub.data.network.GithubApi
import com.vk.directop.showgithub.data.network.RepoDTO
import com.vk.directop.showgithub.data.network.toRepoDomain
import com.vk.directop.showgithub.domain.model.RepoDomain
import com.vk.directop.showgithub.domain.repository.GithubRepository

class GithubRepositoryImpl(private val githubApi: GithubApi) : GithubRepository {

    override suspend fun getUserRepos(name: String): List<RepoDomain> {
        val result = githubApi.getUserRepos(name)
        return mapToDomainRepo(result)
    }

    private fun mapToDomainRepo(oldList: List<RepoDTO>) : List<RepoDomain>{
        return oldList.map { it.toRepoDomain() }
    }
}