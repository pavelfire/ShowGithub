package com.vk.directop.showgithub.domain.usecase

import com.vk.directop.showgithub.domain.model.RepoDomain
import com.vk.directop.showgithub.domain.repository.GithubRepository

class LoginUseCase (private val githubRepository: GithubRepository) {

    suspend fun execute(name: String, token: String): List<RepoDomain> {
        val result = githubRepository.login(name, token)
        return result
    }
}