package com.connectivity.manager.optview_test_android.screens.otp

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.connectivity.manager.optview_test_android.CommonConst
import com.connectivity.manager.optview_test_android.R
import com.connectivity.manager.optview_test_android.databinding.FragmentOtpBinding
import com.connectivity.manager.optview_test_android.screens.optdialog.OtpDialog
import com.google.android.material.snackbar.Snackbar


class OtpFragment : Fragment() {

    private var _binding:FragmentOtpBinding? = null
    var phoneNumber:String? = null
    var otp:String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOtpBinding.inflate(layoutInflater, container, false)
        phoneNumber = arguments?.getString(CommonConst.PHONE_NUM_KEY)
        otp = arguments?.getString(CommonConst.OTP_KEY)

        _binding?.phNumber?.text = CommonConst.CNTRY_CD.plus(" ").plus(phoneNumber)

        _binding?.phnumTL?.requestFocus()

        _binding?.submitBtn?.setOnClickListener {
            gotoProfile()
        }
        _binding?.backButton?.setOnClickListener {
            navigateBack()
        }
        _binding?.edtBtn?.setOnClickListener {
            navigateBack()
        }
        _binding?.resendTV?.setOnClickListener {
            sendOtp()
        }
        return _binding?.root
    }

    private fun navigateBack() {
        findNavController().popBackStack()
    }

    private fun gotoProfile() {
        val enteredOtp:String? = _binding?.otpET?.text?.take(4)?.toString()
        if (enteredOtp == otp){
            findNavController().navigate(R.id.action_otpFragment_to_profileFragment)
        }else{
            Snackbar.make(_binding?.phNumber!!, "Please enter valid otp!", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun sendOtp() {
            val otp = phoneNumber?.takeLast(4)?.toString()
            val otpDialog = OtpDialog(requireActivity(), otp?:"")
            otpDialog.show(this.childFragmentManager, "otpdialog")

            object : CountDownTimer(5000L, 1000L){
                override fun onTick(millisUntilFinished: Long) {
                    //
                }

                override fun onFinish() {
                    otpDialog.dismiss()
                }

            }.start()

    }


}