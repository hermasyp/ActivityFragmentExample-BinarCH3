package com.catnip.activityfragmentexample.presentation.fragmenttwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import coil.load
import com.catnip.activityfragmentexample.R
import com.catnip.activityfragmentexample.databinding.FragmentTwoBinding
import com.catnip.activityfragmentexample.model.Person

class FragmentTwo : Fragment() {

    companion object{
        const val ARGS_PERSON = "ARGS_PERSON"
    }

    private lateinit var binding : FragmentTwoBinding

    private val person : Person? by lazy {
        //bundle arguments
        // arguments?.getParcelable(ARGS_PERSON)

        // SafeArgs
        FragmentTwoArgs.fromBundle(arguments as Bundle).person
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
        showProfileData()
    }

    private fun showProfileData() {
        if(person != null){
            binding.llProfile.isVisible = true
            binding.ivProfileImg.load(person?.profilePictUrl)
            binding.tvName.text = person?.name
            binding.tvJob.text = person?.job
            binding.tvProfileDesc.text = person?.profileDesc
        }else {
            binding.llProfile.isVisible = false
            Toast.makeText(requireContext(), "Profile is Null", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setClickListener() {
        binding.btnNavigate.setOnClickListener {
            navigateToFragmentThree()
        }
    }

    private fun navigateToFragmentThree() {
        findNavController().navigate(R.id.action_fragmentTwo_to_fragmentThree)
    }


}