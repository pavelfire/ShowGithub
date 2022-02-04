package com.vk.directop.showgithub.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class RepoDomain(
    val id: Int,
    val name: String,
    val language: String?,
    val description: String,
    val forks: Int,
    val html_url: String,
    val license: String,
    val stargazers_count: Int,
    val watchers: Int,
) {
}