package com.vk.directop.showgithub.presentation.list_repo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.showgithub.R
import com.vk.directop.showgithub.domain.model.RepoDomain

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
    }
}