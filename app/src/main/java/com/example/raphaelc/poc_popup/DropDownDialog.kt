package com.example.raphaelc.poc_popup

import android.app.Dialog
import android.databinding.DataBindingUtil
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import com.example.raphaelc.poc_popup.databinding.CustomDialogBinding

class DropDownDialog : DialogFragment() {

    private lateinit var dataBinding: CustomDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.custom_dialog, null, false
        )

        dataBinding.dialog = this
        dataBinding.setLifecycleOwner(this)

        return dataBinding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)

        dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)

        return dialog
    }

    override fun onStart() {
        super.onStart()

        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    fun onBackgroundClick() {
        dismiss()
    }

    fun clearFilter() {
        Toast.makeText(context!!, "Limpar filtros", Toast.LENGTH_LONG).show()
    }

}