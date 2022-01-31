package com.vk.directop.showgithub.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
//import androidx.navigation.fragment.NavHostFragment.findNavController
import com.vk.directop.showgithub.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        val view = binding.root

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        //binding.name.text = viewModel.name
        binding.btSignIn.setOnClickListener {
            viewModel.loginClicked()
            val action = LoginFragmentDirections.actionLoginFragmentToListRepoFragment()//viewModel.score.value ?: 0)
            findNavController(this).navigate(action)
            //val

        }

        return view
    }

    companion object {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}