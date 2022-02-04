package com.vk.directop.showgithub.presentation.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.vk.directop.showgithub.R
import com.vk.directop.showgithub.databinding.FragmentDetailBinding
import kotlin.system.exitProcess


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        _binding = FragmentDetailBinding.inflate(layoutInflater)
        val view = binding.root


        val htmlUrl = DetailFragmentArgs.fromBundle(arguments!!).htmlUrl
        val licenseName = DetailFragmentArgs.fromBundle(arguments!!).license
            .substringAfter("name=")
            .substringBefore(',')

        val repo = DetailFragmentArgs.fromBundle(arguments!!).stars
        Log.d("MyTag", "--------Received id: ${repo}")
        //viewModel.fillList(ListRepoFragmentArgs.fromBundle(arguments!!).name)

        (activity as AppCompatActivity).supportActionBar?.title = DetailFragmentArgs.fromBundle(arguments!!).name
        binding.apply {
            tvLink.text = htmlUrl
            tvLicense.text = licenseName
            tvStargazersCount.text = DetailFragmentArgs.fromBundle(arguments!!).stars.toString()
            tvFoks.text = DetailFragmentArgs.fromBundle(arguments!!).forks.toString()
            tvWatchers.text = DetailFragmentArgs.fromBundle(arguments!!).watchers.toString()
            tvText.text = DetailFragmentArgs.fromBundle(arguments!!).description

            tvLink.setOnClickListener {
                val link = Uri.parse(htmlUrl)
                val intent = Intent(Intent.ACTION_VIEW, link)
                startActivity(intent)
            }
        }


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