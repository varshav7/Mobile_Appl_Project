package com.example.groceryproject

object CartManager {
    private val cartItems = mutableMapOf<String, Int>()

    fun addItem(itemName: String, quantity: Int) {
        cartItems[itemName] = cartItems.getOrDefault(itemName, 0) + quantity
    }

    fun removeItem(itemName: String) {
        cartItems.remove(itemName)
    }

    fun getItems(): Map<String, Int> {
        return cartItems
    }

    fun clearCart() {
        cartItems.clear()
    }
}
