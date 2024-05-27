package com.example.fragmentlamba

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    private lateinit var clickBtnRegister: (User) -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        val edtFirstName = view.findViewById<EditText>(R.id.editFirstname)
        val edtLastName = view.findViewById<EditText>(R.id.editLastname)
        val edtEmail = view.findViewById<EditText>(R.id.editEmail)
        val edtPhone = view.findViewById<EditText>(R.id.editPhone)
        val edtUsername = view.findViewById<EditText>(R.id.editUsername2)
        val edtPassword = view.findViewById<EditText>(R.id.editPsw)
        val btnRegister = view.findViewById<Button>(R.id.buttonRegister)

        btnRegister.setOnClickListener {
            val firstName = edtFirstName.text.toString()
            val lastName = edtLastName.text.toString()
            val email = edtEmail.text.toString()
            val phone = edtPhone.text.toString()
            val username = edtUsername.text.toString()
            val password = edtPassword.text.toString()
            val user = User(firstName, lastName, email, phone, username, password)
            clickBtnRegister(user)

        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(clickBtnRegister: (User) -> Unit): RegisterFragment {
            val registerFragment = RegisterFragment()
            registerFragment.clickBtnRegister = clickBtnRegister
            return registerFragment
        }
    }
}