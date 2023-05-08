package com.example.udacitystarter.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.udacitystarter.R
import com.example.udacitystarter.databinding.FragmentLoginFragmentBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLoginFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_fragment, container, false)
        binding.newLogin.setOnClickListener {
            view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcome())
        }
        binding.login.setOnClickListener { view: View? ->
            view?.findNavController()?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcome())
        }
        return binding.root
    }

}
