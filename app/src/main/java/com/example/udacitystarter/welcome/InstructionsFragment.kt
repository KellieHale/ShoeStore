package com.example.udacitystarter.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.udacitystarter.R
import com.example.udacitystarter.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInstructionsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container, false)
        binding.instructionsSearch.setOnClickListener {view: View? ->
            view?.findNavController()!!.navigate(InstructionsFragmentDirections.actionInstructionsToShoeList())
        }
        return binding.root
    }

}