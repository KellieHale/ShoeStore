package com.example.udacitystarter.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.udacitystarter.R
import com.example.udacitystarter.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding.welcomeSearch.setOnClickListener {view: View? ->
            view?.findNavController()!!.navigate(WelcomeFragmentDirections.actionWelcomeToShoeList())
        }
        binding.instructionsButton.setOnClickListener {view: View? ->
            view?.findNavController()!!.navigate(WelcomeFragmentDirections.actionWelcomeToInstructions())
        }
        return binding.root
    }
}