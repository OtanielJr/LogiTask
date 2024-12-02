package com.example.logitask.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.logitask.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)


        val logoutButton = view.findViewById<Button>(R.id.logout)

        logoutButton.setOnClickListener {
            val message : String = "Tens a certeza?"
            showCustomDialogBox(message)
        }


        return view
    }
    private fun showCustomDialogBox(message: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.alert_modal)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val confirmButton = dialog.findViewById<Button>(R.id.confirmModalBtn)
        val rejectButton = dialog.findViewById<Button>(R.id.rejectModalBtn)
        val modalDescription = dialog.findViewById<TextView>(R.id.modalMessage)

        modalDescription.text = message

        confirmButton.setOnClickListener {

        }
        rejectButton.setOnClickListener {

        }
        dialog.show()
    }
}