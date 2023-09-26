package com.connectivity.manager.optview_test_android.screens.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.connectivity.manager.optview_test_android.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        _binding?.backButton?.setOnClickListener {
            navigateBack()
        }
        return _binding?.root
    }
    
    private fun navigateBack() {
        findNavController().popBackStack()
    }

}