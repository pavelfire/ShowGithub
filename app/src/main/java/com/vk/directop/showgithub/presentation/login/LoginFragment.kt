package com.vk.directop.showgithub.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.google.android.material.snackbar.Snackbar
//import androidx.navigation.fragment.NavHostFragment.findNavController
import com.vk.directop.showgithub.databinding.FragmentLoginBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    //private lateinit var viewModel: LoginViewModel

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        val view = binding.root

        //viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.btSignIn.setOnClickListener {
            viewModel.loginClicked()
            viewModel.login(
                binding.etUsername.text.toString(),
                binding.etToken.text.toString()
            )
        }

        viewModel.eventLogin.observe(viewLifecycleOwner, Observer { login ->
            if(login){
                val action =
                    LoginFragmentDirections.actionLoginFragmentToListRepoFragment()//viewModel.score.value ?: 0)
                findNavController(this).navigate(action)
            }
        })


        lifecycleScope.launchWhenCreated {
            viewModel.loginUiState.collect {
                when (it) {
                    is LoginViewModel.LoginUiState.Success -> {
                        Snackbar.make(
                            view,
                            "Successfully logged in",
                            Snackbar.LENGTH_LONG
                        ).show()
                        binding.progressBar.isVisible = false
                    }
                    is LoginViewModel.LoginUiState.Error -> {
                        Snackbar.make(
                            view,
                            it.message, //data class Error(val message: String) : LoginUiState()
                            Snackbar.LENGTH_LONG
                        ).show()
                        binding.progressBar.isVisible = false
                    }
                    is LoginViewModel.LoginUiState.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                    else -> Unit
                }
            }
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