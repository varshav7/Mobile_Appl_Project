package com.example.groceryproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LogInPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        supportActionBar?.hide()
        setContentView(R.layout.activity_log_in_page)
        val loginbtn=findViewById<Button>(R.id.login2)
        val username=findViewById<EditText>(R.id.username)
        val pwd1=findViewById<EditText>(R.id.password)


        loginbtn.setOnClickListener{
            val usertext=username.text.toString()
            val pwd1text=pwd1.text.toString()
            if(usertext.isEmpty()||pwd1text.isEmpty())
            {
                Toast.makeText(this,"Fill all fields", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this,"Welcome Back!", Toast.LENGTH_SHORT).show()
                val intent= Intent(this,HomePage::class.java)
                startActivity(intent)

            }
        }
    }
}