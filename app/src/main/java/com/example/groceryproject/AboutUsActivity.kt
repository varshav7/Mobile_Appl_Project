package com.example.groceryproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about_us)
        val feedbackEmail=findViewById<EditText>(R.id.feedbackEmail)
        val feedbackText=findViewById<EditText>(R.id.feedbackText)
        val sendFeedbackButton=findViewById<Button>(R.id.sendFeedbackButton)
        sendFeedbackButton.setOnClickListener{
            val email=feedbackEmail.text.toString().trim()
            val body= feedbackText.text.toString().trim()
            if(email.isEmpty()||body.isEmpty())
            {
                Toast.makeText(this,"Fill all fields", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val intent= Intent(Intent.ACTION_SEND).apply{
                    type="text/plain"
                    putExtra(Intent.EXTRA_EMAIL,arrayOf(email))
                    putExtra(Intent.EXTRA_TEXT,body)
                }
                try {

                    startActivity(Intent.createChooser(intent,"Choose email client"))
                }
                catch(ex:Exception)
                {
                    Toast.makeText(this,"No email client found", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}