package com.example.fetchrewardscodingexercise

// Data class representing an item fetched from the server.
data class Item(
    val id: Int,        // Unique identifier for the item.
    val listId: Int,    // Identifier for the list the item belongs to.
    val name: String?   // Name of the item (nullable).
)
