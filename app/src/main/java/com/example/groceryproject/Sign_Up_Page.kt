package com.example.groceryproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Sign_Up_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up_page)
        val signupbtn=findViewById<Button>(R.id.signupbtn2)
        val username=findViewById<EditText>(R.id.username)
        val pwd1=findViewById<EditText>(R.id.password)
        val pwd2=findViewById<EditText>(R.id.confirmpwd)


        signupbtn.setOnClickListener {
            val usertext = username.text.toString()
            val pwd1text = pwd1.text.toString()
            val pwd2text = pwd2.text.toString()

            if (usertext.isEmpty() || pwd1text.isEmpty() || pwd2text.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                if (pwd1text != pwd2text) {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Redirecting to Log In Page", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, LogInPage::class.java)
                    startActivity(intent)
                }
            }
        }

    }
}