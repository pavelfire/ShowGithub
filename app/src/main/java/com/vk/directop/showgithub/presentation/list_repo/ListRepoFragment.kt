package com.vk.directop.showgithub.presentation.list_repo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.showgithub.R
import com.vk.directop.showgithub.data.network.RepoDTO
import com.vk.directop.showgithub.domain.model.RepoDomain


class ListRepoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_repo, container, false)

        val reposRecyclerView: RecyclerView = view.findViewById(R.id.repos_recycler_view)
        reposRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        reposRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.HORIZONTAL
            )
        )
        reposRecyclerView.adapter = ListRepoAdapter(repoList)

        return view
    }

    companion object {
        val repoList = listOf(
            RepoDomain(name = "moko-web3", language = "Kotlin", description = "Ethereum Web3 implementation for mobile (android & ios) Kotlin Multiplatform development"),
            RepoDomain(name = "moko-resources", language = "Kotlin", description = "Resources access for mobile (android & ios) Kotlin Multiplatform development"),
            RepoDomain(name = "libs.kmp.icerock.dev", language = "JavaScript", description = "O it is description of this repo."),
            RepoDomain(name = "kmm.icerock.dev", language = "JavaScript", description = ""),
            RepoDomain(name = "moko-web3", language = "Kotlin", description = "Ethereum Web3 implementation for mobile (android & ios) Kotlin Multiplatform development"),
            RepoDomain(name = "moko-resources", language = "Kotlin", description = "O it is description of this repo."),
            RepoDomain(name = "libs.kmp.icerock.dev", language = "JavaScript", description = "O it is description of this repo."),
            RepoDomain(name = "Its name", language = "Kotlin", description = "O it is description of this repo."),
            RepoDomain(name = "moko-web3", language = "Kotlin", description = "Ethereum Web3 implementation for mobile (android & ios) Kotlin Multiplatform development"),
            RepoDomain(name = "moko-resources", language = "Kotlin", description = "O it is description of this repo."),
            RepoDomain(name = "libs.kmp.icerock.dev", language = "JavaScript", description = "O it is description of this repo."),
            RepoDomain(name = "Its name", language = "Kotlin", description = "O it is description of this repo."),
        )

    }
}