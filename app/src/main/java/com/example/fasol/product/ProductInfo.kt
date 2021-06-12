package com.example.fasol.product

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.fasol.ProfileManager
import com.example.fasol.R
import com.example.fasol.authorization.OrdersEmptyDirections
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.orders_empty.*
import kotlinx.android.synthetic.main.profile.*
import org.w3c.dom.Text

class ProductInfo: BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.product_info, container, false)

        return v
    }
}