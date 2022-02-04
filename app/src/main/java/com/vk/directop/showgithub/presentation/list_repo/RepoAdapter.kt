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
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vk.directop.showgithub.R
import com.vk.directop.showgithub.domain.model.RepoDomain
import com.vk.directop.showgithub.presentation.login.LoginFragmentDirections

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.OneRepoViewHolder>() {

    inner class OneRepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffCallback = object : DiffUtil.ItemCallback<RepoDomain>() {
        override fun areItemsTheSame(oldItem: RepoDomain, newItem: RepoDomain): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: RepoDomain, newItem: RepoDomain): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneRepoViewHolder {
        val repoListItemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)

        return OneRepoViewHolder(repoListItemView)
    }

    override fun onBindViewHolder(holder: OneRepoViewHolder, position: Int) {
        val repo = differ.currentList[position]
        holder.itemView.apply {
            val tvName: TextView = this.findViewById(R.id.tv_name)
            val tvLanguage: TextView = this.findViewById(R.id.tv_language)
            val tvDescription: TextView = this.findViewById(R.id.tv_description)

            tvName.text = repo.name
            tvLanguage.text = repo.language
            tvDescription.text = repo.description

            val layoutItem: ConstraintLayout = this.findViewById(R.id.layout_item)
            layoutItem.setOnClickListener {

                Log.d("MyTag", "Pressed: ${repo.name}")
                val action = ListRepoFragmentDirections.actionListRepoFragmentToDetailFragment(
                    repo.html_url,
                    repo.license,
                    repo.stargazers_count,
                    repo.forks,
                    repo.watchers,
                    repo.description,
                    repo.name
                    )
                NavHostFragment.findNavController(this.findFragment()).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}
