package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {


    @Test
    fun shouldDenoteValuesOverTime() {
        val item = Item("foo", 100, 200)
        val items = listOf(item)
        val app = GildedRose(items)

        val foundItem = app.items.find { it.name == "foo" }!!
        assertEquals(100, foundItem.sellIn)
        assertEquals(200, foundItem.quality)
        app.updateQuality()
        assertEquals(99, foundItem.sellIn)
        assertEquals(199, foundItem.quality)
        app.updateQuality()
        assertEquals(98, foundItem.sellIn)
        assertEquals(198, foundItem.quality)
    }

    @Test
    fun shouldDenoteValuesOverTimeAfterSell() {
        val item = Item("foo", 1, 200)
        val items = listOf(item)
        val app = GildedRose(items)

        val foundItem = app.items.find { it.name == "foo" }!!
        assertEquals(1, foundItem.sellIn)
        assertEquals(200, foundItem.quality)
        app.updateQuality()
        assertEquals(0, foundItem.sellIn)
        assertEquals(199, foundItem.quality)
        app.updateQuality()
        assertEquals(-1, foundItem.sellIn)
        assertEquals(197, foundItem.quality)
    }

    @Test
    fun itemQualityCantBeNegative() {
        val item = Item("foo", 100, 1)
        val items = listOf(item)
        val app = GildedRose(items)

        app.updateQuality()
        app.updateQuality()
        app.updateQuality()

        val foundItem = app.items.find { it.name == "foo" }!!
        assertEquals(0, foundItem.quality)
    }

    @Test
    fun agedBrieShouldIncreaseItsQualityOverTime() {
        val item = Item("Aged Brie", 10, 1)
        val items = listOf(item)
        val app = GildedRose(items)

        app.updateQuality()
        app.updateQuality()
        app.updateQuality()
        app.updateQuality()

        val foundItem = app.items.find { it.name == "Aged Brie" }!!
        assertEquals(5, foundItem.quality)
    }

    @Test
    fun qualityOfItemCannotBeMoreThan50() {
        val item = Item("Aged Brie", 10, 45)
        val items = listOf(item)
        val app = GildedRose(items)

        app.updateQuality()
        app.updateQuality()
        app.updateQuality()
        app.updateQuality()
        app.updateQuality()

        val foundItem = app.items.find { it.name == "Aged Brie" }!!
        assertEquals(50, foundItem.quality)
        assertEquals(5, foundItem.sellIn)
    }

    @Test
    fun backstagePassesShouldIncreaseItsQualityOverTime() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 10, 45)
        val items = listOf(item)
        val app = GildedRose(items)

        app.updateQuality()
        app.updateQuality()
        app.updateQuality()
        app.updateQuality()

        val foundItem = app.items.find { it.name == "Backstage passes to a TAFKAL80ETC concert" }!!
        assertEquals(50, foundItem.quality)
        assertEquals(6, foundItem.sellIn)
    }

    @Test
    fun backstagePassesTestOfBehaviour() {
        val item = Item("Backstage passes to a TAFKAL80ETC concert", 10, 1)
        val items = listOf(item)
        val app = GildedRose(items)

        app.updateQuality()
        app.updateQuality()
        app.updateQuality()
        app.updateQuality()
        app.updateQuality()

        val foundItem = app.items.find { it.name == "Backstage passes to a TAFKAL80ETC concert" }!!
        assertEquals(11, foundItem.quality)
        assertEquals(5, foundItem.sellIn)
        app.updateQuality()
        app.updateQuality()
        app.updateQuality()
        assertEquals(20, foundItem.quality)
        assertEquals(2, foundItem.sellIn)
    }


    @Test
    fun sulfurasTest() {
        val item = Item("Sulfuras, Hand of Ragnaros", 10, 80)
        val items = listOf(item)
        val app = GildedRose(items)

        app.updateQuality()
        app.updateQuality()
        app.updateQuality()
        app.updateQuality()

        val foundItem = app.items.find { it.name == "Sulfuras, Hand of Ragnaros" }!!
        assertEquals(80, foundItem.quality)
        assertEquals(10, foundItem.sellIn)
    }


    @Test
    fun conjuredItemsDevoteTwiceFast() {
        val item = Item("Conjured apple", 3, 40)
        val items = listOf(item)
        val app = GildedRose(items)

        val foundItem = app.items.find { it.name == "Conjured apple" }!!
        assertEquals(3, foundItem.sellIn)
        assertEquals(40, foundItem.quality)
        app.updateQuality()
        assertEquals(2, foundItem.sellIn)
        assertEquals(38, foundItem.quality)
        app.updateQuality()
        assertEquals(1, foundItem.sellIn)
        assertEquals(36, foundItem.quality)
        app.updateQuality()
        assertEquals(0, foundItem.sellIn)
        assertEquals(34, foundItem.quality)
        app.updateQuality()
        assertEquals(-1, foundItem.sellIn)
        assertEquals(30, foundItem.quality)
    }
}


