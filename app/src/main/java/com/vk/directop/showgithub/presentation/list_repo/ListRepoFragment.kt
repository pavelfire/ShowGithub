package com.vk.directop.showgithub.presentation.list_repo

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.showgithub.R
import com.vk.directop.showgithub.data.network.RepoDTO
import com.vk.directop.showgithub.domain.model.RepoDomain
import kotlinx.coroutines.launch
import kotlin.system.exitProcess


class ListRepoFragment : Fragment() {

    private lateinit var viewModel: ListRepoViewModel

    private lateinit var listRepoAdapter: RepoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_repo, container, false)

        viewModel = ViewModelProvider(this).get(ListRepoViewModel::class.java)

        setHasOptionsMenu(true)

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_exit -> {
                exitProcess(-1)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }


}