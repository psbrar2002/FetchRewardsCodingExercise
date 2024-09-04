package com.example.fetchrewardscodingexercise

// Sealed class representing different types of items in the list.
sealed class ListItem {
    // Represents a category header in the list, showing list ID and item count.
    data class CategoryHeader(val listId: Int, val count: Int) : ListItem()

    // Represents an individual item detail entry in the list.
    data class ItemDetail(val id: Int, val listId: Int, val name: String) : ListItem()
}
