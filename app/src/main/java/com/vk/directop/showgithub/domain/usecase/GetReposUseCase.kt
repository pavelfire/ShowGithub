package com.vk.directop.showgithub.domain.usecase

import com.vk.directop.showgithub.data.network.RepoDTO
import com.vk.directop.showgithub.domain.model.RepoDomain
import com.vk.directop.showgithub.domain.repository.GithubRepository

class GetReposUseCase (private val githubRepository: GithubRepository){

    suspend fun execute(name: String): List<RepoDomain>{
        val result = githubRepository.getUserRepos(name)
        return result
    }
}