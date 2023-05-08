package com.example.udacitystarter.shoeList


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.udacitystarter.R
import com.example.udacitystarter.databinding.FragmentShoeListBinding
import com.example.udacitystarter.databinding.ShoeRowBinding


class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(requireActivity())[ShoeListViewModel::class.java]
        binding.shoeListViewModel = viewModel
        setHasOptionsMenu(true)

        binding.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_ShoeList_to_shoeDetailFragment)
        }

        addDefaultShoes()

        if (viewModel.hasShoe()) {
            addShoeToList(viewModel.getCurrentShoe())
            viewModel.clearShoe()
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.log_out -> {
                findNavController().navigate(R.id.action_ShoeList_to_login_fragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addDefaultShoes() {
        for (shoe in viewModel.shoeList) {
            addShoeToList(shoe)
        }
    }

    private fun addShoeToList(shoeDataModel: ShoeDataModel) {
        val rowBinding: ShoeRowBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.shoe_row, null, false)
        rowBinding.shoeDataModel = shoeDataModel

        binding.shoeList.addView(rowBinding.root)
    }
}
