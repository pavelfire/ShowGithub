package com.vk.directop.showgithub.presentation.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.vk.directop.showgithub.R
import kotlin.system.exitProcess


class DetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    companion object {

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

    //открывает браузер и переходит по ссылке
//    val link = Uri.parse("https://ya.ru")
//    val intent = Intent(Intent.ACTION_VIEW, link)
//    startActivity(intent)
}