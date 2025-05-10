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

class VegetablesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vegetables)

        val btnAddOnion = findViewById<Button>(R.id.btnAddOnion)
        val btnAddPotato = findViewById<Button>(R.id.btnAddPotato)
        val btnAddCucumber = findViewById<Button>(R.id.btnAddCucumber)
        val btnAddTomato= findViewById<Button>(R.id.btnAddTomato)
        val btnAddBrinjal = findViewById<Button>(R.id.btnAddBrinjal)
        val btnAddCarrot = findViewById<Button>(R.id.btnAddCarrot)
        val fabCart = findViewById<FloatingActionButton>(R.id.fabCart)

        btnAddOnion.setOnClickListener {
            CartManager.addItem("Onion", 1)
            Toast.makeText(this, "500g Onion added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddPotato.setOnClickListener {
            CartManager.addItem("Potato", 1)
            Toast.makeText(this, "500g Potato added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddCucumber.setOnClickListener {
            CartManager.addItem("Cucumber", 1)
            Toast.makeText(this, "500g Cucumber added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddTomato.setOnClickListener {
            CartManager.addItem("Tomato", 1)
            Toast.makeText(this, "500g Tomato added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddBrinjal.setOnClickListener {
            CartManager.addItem("Brinjal", 1)
            Toast.makeText(this, "500g Brinjal added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddCarrot.setOnClickListener {
            CartManager.addItem("Carrot", 1)
            Toast.makeText(this, "500g Carrot added to cart", Toast.LENGTH_SHORT).show()
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