package com.gildedrose

private const val TTICKET_NAME = "Backstage passes to a TAFKAL80ETC concert"
private const val SULFURAS_NAME = "Sulfuras, Hand of Ragnaros"
private const val AGED_BRIE_NAME = "Aged Brie"

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            val currentItem = items[i]
            if (currentItem.name != AGED_BRIE_NAME && currentItem.name != TTICKET_NAME) {
                if (currentItem.quality > 0) {
                    if (currentItem.name != SULFURAS_NAME) {
                        currentItem.quality = currentItem.quality - 1
                    }
                }
            } else {
                if (currentItem.quality < 50) {
                    currentItem.quality = currentItem.quality + 1

                    if (currentItem.name == TTICKET_NAME) {
                        if (currentItem.sellIn < 11) {
                            if (currentItem.quality < 50) {
                                currentItem.quality = currentItem.quality + 1
                            }
                        }

                        if (currentItem.sellIn < 6) {
                            if (currentItem.quality < 50) {
                                currentItem.quality = currentItem.quality + 1
                            }
                        }
                    }
                }
            }

            if (currentItem.name != SULFURAS_NAME) {
                currentItem.sellIn = currentItem.sellIn - 1
            }

            if (currentItem.sellIn < 0) {
                currentItem.quality = when {
                    currentItem.name == AGED_BRIE_NAME && currentItem.quality < 50 -> currentItem.quality + 1
                    currentItem.name == TTICKET_NAME -> 0
                    currentItem.quality > 0 && currentItem.name != SULFURAS_NAME -> currentItem.quality - 1
                    else -> {
                        return
                    }
                }
            }
        }
    }

}




