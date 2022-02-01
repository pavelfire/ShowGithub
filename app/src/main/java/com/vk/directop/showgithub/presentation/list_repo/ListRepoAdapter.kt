package com.vk.directop.showgithub.presentation.list_repo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.showgithub.R
import com.vk.directop.showgithub.domain.model.RepoDomain
import com.vk.directop.showgithub.presentation.login.LoginFragmentDirections

class ListRepoAdapter (private val repoList: List<RepoDomain>) : RecyclerView.Adapter<RepoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val repoListItemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)

        return RepoViewHolder(repoListItemView)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val repo = repoList[position]
        holder.bind(repo)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }
}

class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(repo: RepoDomain){
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvLanguage: TextView = itemView.findViewById(R.id.tv_language)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_description)

        tvName.text = repo.name
        tvLanguage.text = repo.language
        tvDescription.text = repo.description

        val layoutItem : ConstraintLayout = itemView.findViewById(R.id.layout_item)
        layoutItem.setOnClickListener {

            Log.d("MyTag", "Pressed: ${repo.name}")
            val action = ListRepoFragmentDirections.actionListRepoFragmentToDetailFragment()
            NavHostFragment.findNavController(itemView.findFragment()).navigate(action)
        }
    }
}