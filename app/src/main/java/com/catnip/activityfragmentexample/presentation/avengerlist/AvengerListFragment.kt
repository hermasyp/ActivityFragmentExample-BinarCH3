package com.catnip.activityfragmentexample.presentation.avengerlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.catnip.activityfragmentexample.data.AvengersDataSource
import com.catnip.activityfragmentexample.data.AvengersDataSourceImpl
import com.catnip.activityfragmentexample.databinding.FragmentAvengerListBinding
import com.catnip.activityfragmentexample.model.Person

class AvengerListFragment : Fragment() {

    private lateinit var binding: FragmentAvengerListBinding

    private val dataSource : AvengersDataSource by lazy {
        AvengersDataSourceImpl()
    }

    private val adapter: AvengerListAdapter by lazy {
        AvengerListAdapter { person ->
            navigateToFragmentTwo(person)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAvengerListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerview()
    }

    private fun setupRecyclerview() {
        binding.rvAvengers.adapter = adapter
        binding.rvAvengers.layoutManager = LinearLayoutManager(requireContext())

        //grid list
        //binding.rvAvengers.layoutManager = GridLayoutManager(requireContext(),2)

        //horizontal list
        //binding.rvAvengers.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        adapter.setData(dataSource.getAvengersData())
    }

    private fun navigateToFragmentTwo(person: Person? = null) {

        val action = AvengerListFragmentDirections.navigateToDetail(person)
        findNavController().navigate(action)
    }

}