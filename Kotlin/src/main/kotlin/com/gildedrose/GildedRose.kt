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
            val itsSulfuras = currentItem.name != SULFURAS_NAME
            if (!itsAgedBrie && !itsTicket && currentItem.quality > 0 && itsSulfuras) {
                currentItem.quality = currentItem.quality - 1
            } else {
                if (currentItem.quality < 50) {
                    currentItem.quality = currentItem.quality + 1

                    if (currentItem.name == TTICKET_NAME && currentItem.quality < 50) {
                        if (currentItem.sellIn < 6) {
                            currentItem.quality = currentItem.quality + 1
                        }
                        if (currentItem.sellIn < 11) {
                            currentItem.quality = currentItem.quality + 1
                        }
                    }
                }
            }

            if (itsSulfuras) {
                currentItem.sellIn = currentItem.sellIn - 1
            }

            if (currentItem.sellIn < 0) {
                currentItem.quality = when {
                    itsAgedBrie && currentItem.quality < 50 -> currentItem.quality + 1
                    itsTicket -> 0
                    currentItem.quality > 0 && itsSulfuras -> currentItem.quality - 1
                    else -> {
                        return
                    }
                }
            }
        }
    }

}




