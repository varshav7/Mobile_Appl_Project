package com.example.groceryproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val signupbtn=findViewById<Button>(R.id.signupbtn)
        val loginbutton=findViewById<Button>(R.id.loginbtn)
        signupbtn.setOnClickListener{
            Toast.makeText(this,"Signing Up",Toast.LENGTH_SHORT).show()
            val intent1= Intent(this,Sign_Up_Page::class.java)
            startActivity(intent1)
        }
        loginbutton.setOnClickListener{
            Toast.makeText(this,"Taking you to log in page",Toast.LENGTH_LONG).show()
            val intent2= Intent(this,LogInPage::class.java)
            startActivity(intent2)
        }
    }
}