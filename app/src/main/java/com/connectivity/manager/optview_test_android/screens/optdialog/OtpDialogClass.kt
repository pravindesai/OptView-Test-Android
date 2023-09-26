package com.connectivity.manager.optview_test_android.screens.optdialog
import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.connectivity.manager.optview_test_android.databinding.OtpDialogLayoutBinding

class OtpDialog(val context: Activity, val otpText:String? = null) : DialogFragment(){

    lateinit var binding: OtpDialogLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OtpDialogLayoutBinding.inflate(inflater, container, false)
        binding.otp.text = otpText?:""
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val dialog: Dialog? = dialog
        val back = ColorDrawable(Color.TRANSPARENT)
        val margin = 40
        val inset = InsetDrawable(back, margin)

        if (dialog != null) {
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.window?.setBackgroundDrawable(inset)
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
        }

    }

}