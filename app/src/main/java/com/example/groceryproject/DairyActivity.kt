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

class DairyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dairy)

        val btnAddMilk = findViewById<Button>(R.id.btnAddMilk)
        val btnAddMilkmaid = findViewById<Button>(R.id.btnAddMilkmaid)
        val btnAddCheese = findViewById<Button>(R.id.btnAddCheese)
        val btnAddYogurt= findViewById<Button>(R.id.btnAddYogurt)
        val btnAddButter = findViewById<Button>(R.id.btnAddButter)
        val fabCart = findViewById<FloatingActionButton>(R.id.fabCart)

        btnAddMilk.setOnClickListener {
            CartManager.addItem("Milk", 1)
            Toast.makeText(this, "1L Milk carton added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddMilkmaid.setOnClickListener {
            CartManager.addItem("Milkmaid", 1)
            Toast.makeText(this, "250g Milkmaid added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddCheese.setOnClickListener {
            CartManager.addItem("Cheese", 1)
            Toast.makeText(this, "100g Cheese added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddYogurt.setOnClickListener {
            CartManager.addItem("Yogurt", 1)
            Toast.makeText(this, "200g Yogurt added to cart", Toast.LENGTH_SHORT).show()
        }
        btnAddButter.setOnClickListener {
            CartManager.addItem("Butter", 1)
            Toast.makeText(this, "150g Butter added to cart", Toast.LENGTH_SHORT).show()
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