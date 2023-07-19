package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {


    @Test
    fun shouldDenoteValuesOverTime() {
        val item = Item("foo", 100, 200)
        val items = listOf(item)
        val app = GildedRose(items)

        val foundItem = app.items.find { it -> it.name == "foo" }!!
        assertEquals(100, foundItem.sellIn)
        assertEquals(200, foundItem.quality)
        app.updateQuality()
        assertEquals(99, foundItem.sellIn)
        assertEquals(199, foundItem.quality)
        app.updateQuality()
        assertEquals(98, foundItem.sellIn)
        assertEquals(198, foundItem.quality)
    }

}


