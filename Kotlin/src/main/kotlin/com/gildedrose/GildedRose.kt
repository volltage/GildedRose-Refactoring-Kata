package com.gildedrose

private const val TTICKET_NAME = "Backstage passes to a TAFKAL80ETC concert"
private const val SULFURAS_NAME = "Sulfuras, Hand of Ragnaros"
private const val AGED_BRIE_NAME = "Aged Brie"

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val currentItem = items[i]

            val itsAgedBrie = currentItem.name == AGED_BRIE_NAME
            val itsTicket = currentItem.name == TTICKET_NAME
            val itsNotSulfuras = currentItem.name != SULFURAS_NAME
            currentItem.sellIn = if (itsNotSulfuras) currentItem.sellIn - 1 else return

            if (itsAgedBrie || itsTicket || currentItem.quality <= 0) {
                if (currentItem.quality < 50) {
                    currentItem.quality = currentItem.quality + 1
                    if (itsTicket && currentItem.quality < 50 && currentItem.sellIn < 5) {
                        currentItem.quality = currentItem.quality + 1
                    }
                    if (itsTicket && currentItem.quality < 50 && currentItem.sellIn < 10) {
                        currentItem.quality = currentItem.quality + 1
                    }
                }
            } else {
                currentItem.quality = currentItem.quality - 1
            }

            if (currentItem.sellIn < 0 && itsAgedBrie && currentItem.quality < 50) currentItem.quality =
                currentItem.quality + 1
            else if (currentItem.sellIn < 0 && itsTicket) currentItem.quality = 0
            else if (currentItem.sellIn < 0 && currentItem.quality > 0) currentItem.quality =
                currentItem.quality - 1


        }
    }

}




