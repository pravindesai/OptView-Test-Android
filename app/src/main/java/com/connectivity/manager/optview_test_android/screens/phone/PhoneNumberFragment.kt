package com.connectivity.manager.optview_test_android.screens.phone

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.connectivity.manager.optview_test_android.CommonConst
import com.connectivity.manager.optview_test_android.R
import com.connectivity.manager.optview_test_android.databinding.FragmentPhoneNumberBinding
import com.connectivity.manager.optview_test_android.screens.optdialog.OtpDialog
import com.google.android.material.snackbar.Snackbar

class PhoneNumberFragment : Fragment() {
    private var _binding: FragmentPhoneNumberBinding? = null
    private var otpDialog:OtpDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhoneNumberBinding.inflate(layoutInflater, container, false)

        _binding?.otpBtn?.setOnClickListener {
            sendOtp()
        }
        _binding?.backButton?.setOnClickListener {
            navigateBack()
        }

        _binding?.phnumTL?.requestFocus()
        return _binding?.root
    }

    private fun navigateBack() {
        findNavController().popBackStack()
    }

    private fun sendOtp() {
        val phoneNumber = _binding?.phNumberET?.text?.toString()
        if ((phoneNumber?.length?:0)>=10){
            val otp = phoneNumber?.takeLast(4)?.toString()
            otpDialog = OtpDialog(requireActivity(), otp?:"")
            otpDialog?.show(this.childFragmentManager, "otpdialog")

            object :CountDownTimer(5000L, 1000L){
                override fun onTick(millisUntilFinished: Long) {
                    //
                }

                override fun onFinish() {
                    otpDialog?.dismiss()
                    val bundle = Bundle()
                    bundle.apply {
                        putString(CommonConst.PHONE_NUM_KEY, phoneNumber)
                        putString(CommonConst.OTP_KEY, otp)
                    }
                    findNavController().navigate(R.id.action_phoneNumberFragment_to_otpFragment, bundle)
                }

            }.start()
        }else{
            Snackbar.make(_binding?.phNumberET!!, "Please enter valid phone number!", Snackbar.LENGTH_SHORT).show()
        }

    }


}