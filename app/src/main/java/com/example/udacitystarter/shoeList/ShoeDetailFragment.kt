package com.example.udacitystarter.shoeList

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.udacitystarter.R
import com.example.udacitystarter.databinding.FragmentShoeDetailBinding


class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java]
        binding.viewModel = viewModel

        binding.cancel.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_shoeDetailFragment_to_ShoeList)
        }

        binding.save.setOnClickListener {
            if (viewModel.hasShoe()) {
                view?.findNavController()?.navigate(R.id.action_shoeDetailFragment_to_ShoeList)
            } else {
                //--- Show error dialog for incomplete shoe data
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle(getString(R.string.missing_data_title))
                builder.setMessage(getString(R.string.missing_data))
                builder.setPositiveButton(getString(androidx.navigation.dynamicfeatures.fragment.R.string.ok), null)
                builder.show()
            }
        }
        return binding.root
    }
}