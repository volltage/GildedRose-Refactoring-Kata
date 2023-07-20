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

            if (itsTicket) {
                if (currentItem.sellIn < 0) {
                    currentItem.quality = 0
                } else if (currentItem.quality < 50) {
                    currentItem.quality++
                    if (currentItem.quality < 50 && currentItem.sellIn < 5) {
                        currentItem.quality++
                    }
                    if (currentItem.quality < 50 && currentItem.sellIn < 10) {
                        currentItem.quality++
                    }
                }
            } else if (itsAgedBrie && currentItem.quality < 50) {
                currentItem.quality++
                if (currentItem.sellIn < 0) {
                    currentItem.quality++
                }
            } else if (currentItem.quality <= 0) {
                currentItem.quality++
            } else {
                currentItem.quality--
            }

            if (currentItem.sellIn < 0 && currentItem.quality > 0) {
                currentItem.quality--
            }

        }
    }

}




