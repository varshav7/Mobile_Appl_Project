package com.example.groceryproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FruitsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits)

        val btnAddApple = findViewById<Button>(R.id.btnAddApple)
        val btnAddOrange = findViewById<Button>(R.id.btnAddOrange)
        val btnAddBanana = findViewById<Button>(R.id.btnAddBanana)
        val btnAddStrb = findViewById<Button>(R.id.btnAddStrb)
        val btnAddMusk = findViewById<Button>(R.id.btnAddMusk)
        val btnAddWtrm = findViewById<Button>(R.id.btnAddWtrm)
        val btnAddPeach = findViewById<Button>(R.id.btnAddPeach)
        val fabCart = findViewById<FloatingActionButton>(R.id.fabCart)

        btnAddApple.setOnClickListener {
            CartManager.addItem("Apple", 1)
            Toast.makeText(this, "500g Apple added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddOrange.setOnClickListener {
            CartManager.addItem("Orange", 1)
            Toast.makeText(this, "500g Orange added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddBanana.setOnClickListener {
            CartManager.addItem("Banana", 1)
            Toast.makeText(this, "500g Banana added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddStrb.setOnClickListener {
            CartManager.addItem("Strawberry", 1)
            Toast.makeText(this, "500g Strawberry added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddMusk.setOnClickListener {
            CartManager.addItem("Muskmelon", 1)
            Toast.makeText(this, "500g Muskmelon added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddWtrm.setOnClickListener {
            CartManager.addItem("Watermelon", 1)
            Toast.makeText(this, "500g Watermelon added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddPeach.setOnClickListener {
            CartManager.addItem("Peach", 1)
            Toast.makeText(this, "500g Peach added to cart", Toast.LENGTH_SHORT).show()
        }

        fabCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
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