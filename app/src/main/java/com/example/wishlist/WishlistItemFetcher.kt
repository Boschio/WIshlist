package com.example.wishlist

class WishlistItemFetcher {
    companion object {
        val itemNames = mutableListOf("PLACEHOLDER")
        val prices = mutableListOf(1.00)
        val urls = mutableListOf("PLACEHOLDER")

        fun addNames(itemName: String) {
            itemNames += itemName
        }

        fun addPrices(price: Double) {
            prices += price
        }

        fun addUrls(url: String) {
            urls += url
        }

        fun getItems(): MutableList<WishlistItems> {
            var items : MutableList<WishlistItems> = ArrayList()
            for (i in 1..itemNames.size - 1) {
                val item = WishlistItems(itemNames[i], urls[i], prices[i])
                items.add(item)
            }
            return items
        }
    }
}