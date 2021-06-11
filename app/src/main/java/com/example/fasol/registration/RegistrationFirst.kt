package com.example.fasol.registration

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fasol.*
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_subcategories.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationFirst : Fragment() {
    private lateinit var communicator: Communicator
    private lateinit var tbLogin: TextInputEditText
    private lateinit var tbPassword: TextInputEditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_reg, container, false)


        val button: Button = v.findViewById(R.id.reg_next)
        button.setOnClickListener {
            communicator = this.activity as Communicator
            communicator.passData(R.id.authorizationFragment, RegistrationSecond())
        }
        return v
    }
}