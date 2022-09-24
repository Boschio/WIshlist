package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var items: List<WishlistItems>

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemInput = findViewById<EditText>(R.id.itemInput)
        val urlInput = findViewById<EditText>(R.id.urlInput)
        val priceInput = findViewById<EditText>(R.id.priceInput)
        val submitButton = findViewById<Button>(R.id.submitButton)

        // Lookup the RecyclerView in activity layout
        val wishlistRv = findViewById<RecyclerView>(R.id.WishlistRV)

        // Fetch items
        items = WishlistItemFetcher.getItems()

        // create instance of Wishlist adapter and give it list of items
        val wishlistItemAdapter = WishlistItemAdapter(items)

        // Attach the adapter to RV by setting its' "adapter" field
        wishlistRv.adapter = wishlistItemAdapter

        // Set layout manager for RV to tell it how to position items
        wishlistRv.layoutManager = LinearLayoutManager(this)

        submitButton.setOnClickListener {
            if(TextUtils.isEmpty(itemInput.text) or TextUtils.isEmpty(urlInput.text) or TextUtils.isEmpty(priceInput.text)) {
                Toast.makeText(this,"Invalid entry",Toast.LENGTH_SHORT).show()
            } else {
                WishlistItemFetcher.addNames(itemInput.text.toString())
                WishlistItemFetcher.addUrls(urlInput.text.toString())
                WishlistItemFetcher.addPrices(priceInput.text.toString().toDouble())

                itemInput.text.clear()
                urlInput.text.clear()
                priceInput.text.clear()

                items = WishlistItemFetcher.getItems()
                val wishlistItemAdapter = WishlistItemAdapter(items)
                wishlistRv.adapter = wishlistItemAdapter

                Toast.makeText(this,"Successfully added",Toast.LENGTH_SHORT).show()
            }
        }

    }
}