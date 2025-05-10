package com.example.groceryproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val cartTextView = findViewById<TextView>(R.id.cartTextView)
        val btnCheckout = findViewById<Button>(R.id.btnCheckout)

        val cartItems = CartManager.getItems()
        val cartText = cartItems.entries.joinToString("\n") { "${it.key}: ${it.value}" }
        cartTextView.text = if (cartText.isNotEmpty()) cartText else "Your cart is empty."

        btnCheckout.setOnClickListener {
            val intent = Intent(this, BillingActivity::class.java)
            startActivity(intent)
        }
    } override fun onCreateOptionsMenu(menu: Menu?): Boolean {
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
