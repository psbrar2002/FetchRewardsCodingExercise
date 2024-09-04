package com.example.fetchrewardscodingexercise

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter class for displaying list items with different view types in a RecyclerView.
class ItemAdapter(private val itemList: List<ListItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        // Constants to define view types for different list items.
        private const val VIEW_TYPE_CATEGORY_HEADER = 0
        private const val VIEW_TYPE_ITEM_DETAIL = 1
    }

    // ViewHolder for category header items.
    class CategoryHeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryTextView: TextView = view.findViewById(R.id.categoryTextView)
    }

    // ViewHolder for item detail entries.
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idTextView: TextView = view.findViewById(R.id.idTextView)
        val listIdTextView: TextView = view.findViewById(R.id.listIdTextView)
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
    }

    // Determines the view type based on the item at the given position.
    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]) {
            is ListItem.CategoryHeader -> VIEW_TYPE_CATEGORY_HEADER
            is ListItem.ItemDetail -> VIEW_TYPE_ITEM_DETAIL
        }
    }

    // Creates ViewHolder instances based on the view type.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_CATEGORY_HEADER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.category_header_layout, parent, false)
                CategoryHeaderViewHolder(view)
            }
            VIEW_TYPE_ITEM_DETAIL -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
                ItemViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    // Binds data to the ViewHolder based on the position.
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CategoryHeaderViewHolder -> {
                val categoryHeader = itemList[position] as ListItem.CategoryHeader
                holder.categoryTextView.text = "listId: ${categoryHeader.listId} (Count: ${categoryHeader.count})"
            }
            is ItemViewHolder -> {
                val itemDetail = itemList[position] as ListItem.ItemDetail

                // Bold only the 'ID:' part
                val idText = SpannableString("id: ${itemDetail.id}")
                idText.setSpan(StyleSpan(Typeface.BOLD), 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                holder.idTextView.text = idText

                // Bold only the 'List ID:' part
                val listIdText = SpannableString("listId: ${itemDetail.listId}")
                listIdText.setSpan(StyleSpan(Typeface.BOLD), 0, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                holder.listIdTextView.text = listIdText

                // Bold only the 'Name:' part
                val nameText = SpannableString("name: ${itemDetail.name}")
                nameText.setSpan(StyleSpan(Typeface.BOLD), 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                holder.nameTextView.text = nameText
            }
        }
    }

    // Returns the total number of items in the list.
    override fun getItemCount(): Int {
        return itemList.size
    }
}
