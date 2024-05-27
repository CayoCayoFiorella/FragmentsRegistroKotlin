package com.example.fragmentlamba

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView;
import androidx.fragment.app.commit
data class User(val firstName: String, val lastName: String, val email: String, val phone: String, val username: String, val password: String)
class MainActivity : AppCompatActivity() {
    private lateinit var textMensaje:TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textMensaje = findViewById<TextView>(R.id.txtMessage)

        val registerFragment = RegisterFragment.newInstance(response)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.frameLayout, registerFragment)
        }
    }

    val response: (User)->Unit ={user ->
        textMensaje.text = "Name: ${user.firstName} ${user.lastName}\nEmail: ${user.email}\nPhone: ${user.phone}\nUsername: ${user.username}"
    }

}