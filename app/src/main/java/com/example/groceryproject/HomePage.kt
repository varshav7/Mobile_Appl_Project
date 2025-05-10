package com.example.groceryproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val btnFruits = findViewById<ImageButton>(R.id.btnFruits)
        val btnVegetables = findViewById<ImageButton>(R.id.btnVegetables)
        val btnDairy = findViewById<ImageButton>(R.id.btnDairy)

        btnFruits.setOnClickListener {
            startActivity(Intent(this, FruitsActivity::class.java))
        }
        btnVegetables.setOnClickListener {
            startActivity(Intent(this, VegetablesActivity::class.java))
        }
        btnDairy.setOnClickListener {
            startActivity(Intent(this, DairyActivity::class.java))
        }
    }
    override fun onResume() {
        super.onResume()
        val toast = Toast.makeText(applicationContext, "Redirected to Home Page",
            Toast.LENGTH_LONG).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_profile -> startActivity(Intent(this, ProfileActivity::class.java))
            R.id.menu_about_us -> startActivity(Intent(this, AboutUsActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}
