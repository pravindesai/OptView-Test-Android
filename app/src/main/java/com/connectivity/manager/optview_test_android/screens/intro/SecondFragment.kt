package com.connectivity.manager.optview_test_android.screens.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.connectivity.manager.optview_test_android.R
import com.connectivity.manager.optview_test_android.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        _binding?.startBtn?.setOnClickListener {
            navigateToPhoneNumberScreen()
        }
        return _binding?.root

    }

    private fun navigateToPhoneNumberScreen() {
        findNavController().navigate(R.id.action_SecondFragment_to_phoneNumberFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}