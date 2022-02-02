package com.vk.directop.showgithub.presentation.list_repo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.showgithub.R
import com.vk.directop.showgithub.data.network.RepoDTO
import com.vk.directop.showgithub.domain.model.RepoDomain
import kotlinx.coroutines.launch


class ListRepoFragment : Fragment() {

    private lateinit var viewModel: ListRepoViewModel

    private lateinit var listRepoAdapter: RepoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_repo, container, false)

        viewModel = ViewModelProvider(this).get(ListRepoViewModel::class.java)

        val reposRecyclerView: RecyclerView = view.findViewById(R.id.repos_recycler_view)
        reposRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        reposRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.HORIZONTAL
            )
        )


        //reposRecyclerView.adapter = ListRepoAdapter(repoList)
        //reposRecyclerView.adapter = viewModel.response.value?.let { ListRepoAdapter(it) }
        reposRecyclerView.apply {
            listRepoAdapter = RepoAdapter()
            adapter = listRepoAdapter
            layoutManager = LinearLayoutManager(context)
        }
        viewModel.response.observe(viewLifecycleOwner, Observer { list ->
            listRepoAdapter.differ.submitList(list)

        })

        return view
    }

    companion object {
        val repoList = listOf(
            RepoDomain(
                name = "moko-web3",
                language = "Kotlin",
                description = "Ethereum Web3 implementation for mobile (android & ios) Kotlin Multiplatform development"
            ),
            RepoDomain(
                name = "moko-resources",
                language = "Kotlin",
                description = "Resources access for mobile (android & ios) Kotlin Multiplatform development"
            ),
            RepoDomain(
                name = "libs.kmp.icerock.dev",
                language = "JavaScript",
                description = "O it is description of this repo."
            ),
            RepoDomain(
                name = "kmm.icerock.dev",
                language = "JavaScript",
                description = ""
            ),
            RepoDomain(
                name = "moko-web3",
                language = "Kotlin",
                description = "Ethereum Web3 implementation for mobile (android & ios) Kotlin Multiplatform development"
            ),
            RepoDomain(
                name = "moko-resources",
                language = "Kotlin",
                description = "O it is description of this repo."
            ),
            RepoDomain(
                name = "libs.kmp.icerock.dev",
                language = "JavaScript",
                description = "O it is description of this repo."
            ),
            RepoDomain(
                name = "Its name",
                language = "Kotlin",
                description = "O it is description of this repo."
            ),
            RepoDomain(
                name = "moko-web3",
                language = "Kotlin",
                description = "Ethereum Web3 implementation for mobile (android & ios) Kotlin Multiplatform development"
            ),
            RepoDomain(
                name = "moko-resources",
                language = "Kotlin",
                description = "O it is description of this repo."
            ),
            RepoDomain(
                name = "libs.kmp.icerock.dev",
                language = "JavaScript",
                description = "O it is description of this repo."
            ),
            RepoDomain(
                name = "Its name",
                language = "Kotlin",
                description = "O it is description of this repo."
            ),
        )

    }
}