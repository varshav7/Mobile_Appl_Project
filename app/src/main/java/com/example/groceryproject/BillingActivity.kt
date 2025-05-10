package com.example.groceryproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BillingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_billing)

        val billTextView = findViewById<TextView>(R.id.billTextView)
        val deliveryAddress = findViewById<EditText>(R.id.etDeliveryAddress)
        val btnConfirmOrder = findViewById<Button>(R.id.btnConfirmOrder)

        val cartItems = CartManager.getItems()

        var totalAmount = 0

        val billDetails = StringBuilder().apply {
            cartItems.forEach { (item, quantity) ->
                val pricePerItem = when {
                    item.contains("Fruit", true) || item in listOf("Apple", "Orange", "Banana", "Strawberry", "Watermelon", "Muskmelon", "Peach") -> 200
                    item.contains("Vegetable", true) || item in listOf("Onion", "Potato", "Tomato", "Cucumber", "Brinjal", "Carrot") -> 150
                    item.contains("Dairy", true) || item in listOf("Milk", "Cheese", "Milkmaid", "Yogurt", "Butter") -> 250
                    else -> 0
                }
                val itemTotal = pricePerItem * quantity
                totalAmount += itemTotal
                append("$item x $quantity = Rs. $itemTotal\n")
            }
        }

        val taxAmount = totalAmount * 0.05
        val totalWithTax = totalAmount + taxAmount
        val discountAmount = totalWithTax * 0.035
        val finalTotal = totalWithTax - discountAmount

        billDetails.append("\nSubtotal: Rs. $totalAmount")
        billDetails.append("\nTax (5%): Rs. ${"%.2f".format(taxAmount)}")
        billDetails.append("\nDiscount (3.5%): Rs. ${"%.2f".format(discountAmount)}")
        billDetails.append("\nTotal Payable: Rs. ${"%.2f".format(finalTotal)}")


        billTextView.text = billDetails.toString()

        btnConfirmOrder.setOnClickListener {
            val address = deliveryAddress.text.toString().trim()
            if (address.isEmpty()) {
                Toast.makeText(this, "Please enter a delivery address!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Order placed successfully!\nDelivery to: $address", Toast.LENGTH_LONG).show()
                CartManager.clearCart()
                val intent=Intent(this,HomePage::class.java)
                startActivity(intent)
            }
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
