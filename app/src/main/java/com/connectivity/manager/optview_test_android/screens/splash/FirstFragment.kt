package com.connectivity.manager.optview_test_android.screens.splash

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.connectivity.manager.optview_test_android.R
import com.connectivity.manager.optview_test_android.databinding.FragmentFirstBinding
import kotlin.time.Duration.Companion.seconds


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return _binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        object :CountDownTimer(5000L,1000L){
            override fun onTick(millisUntilFinished: Long) {
                //
            }

            override fun onFinish() {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }

        }.start()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}