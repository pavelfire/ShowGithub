package com.vk.directop.showgithub.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.google.android.material.snackbar.Snackbar
import com.vk.directop.showgithub.databinding.FragmentLoginBinding
import kotlinx.coroutines.flow.collect


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    //private lateinit var viewModel: LoginViewModel

    private var name = ""

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        val view = binding.root

        //viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.btSignIn.setOnClickListener {
            name = binding.etUsername.text.toString()
            viewModel.loginClicked()
            viewModel.login(
                name,
                binding.etToken.text.toString()
            )
        }

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
                        onCredentialOk(name)
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onCredentialOk(name: String) {
        val action = LoginFragmentDirections.actionLoginFragmentToListRepoFragment(name = name)
        findNavController(this).navigate(action)
    }
}