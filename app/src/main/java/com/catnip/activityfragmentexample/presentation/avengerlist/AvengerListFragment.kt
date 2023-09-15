package com.catnip.activityfragmentexample.presentation.avengerlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.catnip.activityfragmentexample.data.AvengersDataSourceImpl
import com.catnip.activityfragmentexample.databinding.FragmentAvengerListBinding
import com.catnip.activityfragmentexample.model.Person

class AvengerListFragment : Fragment() {

    private lateinit var binding: FragmentAvengerListBinding

    private val adapter: AvengerListAdapter by lazy {
        AvengerListAdapter {
            navigateToFragmentTwo(it)
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
        adapter.setData(AvengersDataSourceImpl().getAvengersData())
    }

    private fun navigateToFragmentTwo(person: Person? = null) {

        val action = AvengerListFragmentDirections.navigateToDetail(person)
        findNavController().navigate(action)
    }

}