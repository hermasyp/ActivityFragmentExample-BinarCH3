package com.catnip.activityfragmentexample.presentation.fragmentthree

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.catnip.activityfragmentexample.R
import com.catnip.activityfragmentexample.databinding.FragmentOneBinding
import com.catnip.activityfragmentexample.databinding.FragmentThreeBinding
import com.catnip.activityfragmentexample.databinding.FragmentTwoBinding

class FragmentThree : Fragment() {
    private lateinit var binding : FragmentThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThreeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}