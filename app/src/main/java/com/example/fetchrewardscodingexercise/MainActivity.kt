package com.example.fetchrewardscodingexercise

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Main activity for displaying the list of items grouped by list ID.
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var toggleButton: Button
    private lateinit var listItemAdapter: ItemAdapter // Adapter for the ListItem type
    private var isListVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        toggleButton = findViewById(R.id.toggleButton)

        // Set up RecyclerView with a linear layout manager.
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch items from the server.
        fetchItems()

        // Set up button click listener to toggle the visibility of the RecyclerView.
        toggleButton.setOnClickListener {
            toggleRecyclerView()
        }
    }

    // Toggles the visibility of the RecyclerView and updates the button text.
    private fun toggleRecyclerView() {
        isListVisible = !isListVisible
        if (isListVisible) {
            recyclerView.visibility = View.VISIBLE
            toggleButton.text = "Collapse"
            recyclerView.animate().alpha(1.0f).setDuration(300).start()
        } else {
            recyclerView.animate().alpha(0.0f).setDuration(300).withEndAction {
                recyclerView.visibility = View.GONE
                toggleButton.text = "Expand"
            }.start()
        }
    }

    // Fetches items from the API and populates the RecyclerView.
    private fun fetchItems() {
        val call = RetrofitClient.apiService.getItems()

        call.enqueue(object : Callback<List<Item>> {
            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                if (response.isSuccessful) {
                    // Filter and sort items, then group them by listId.
                    val items = response.body()?.filter { it.name != null && it.name.isNotBlank() }
                        ?.sortedWith(compareBy({ it.listId }, { it.name }))
                        ?: emptyList()

                    // Transform the fetched items into ListItem objects for display.
                    val listItems = mutableListOf<ListItem>()
                    val grouped = items.groupBy { it.listId }

                    for ((listId, itemList) in grouped) {
                        listItems.add(ListItem.CategoryHeader(listId, itemList.size))
                        itemList.forEach { item ->
                            listItems.add(ListItem.ItemDetail(item.id, item.listId, item.name!!))
                        }
                    }

                    // Set up the adapter with the grouped list items.
                    listItemAdapter = ItemAdapter(listItems)
                    recyclerView.adapter = listItemAdapter
                } else {
                    Log.e("MainActivity", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                Log.e("MainActivity", "Error fetching items", t)
            }
        })
    }
}
