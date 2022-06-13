package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QualityTest {

    @Test
    void QualityDegrades() {
        Item[] items = new Item[] { new Item("foo", 10, 100) };
        GildedRose app = new GildedRose(items);

        assertEquals(100, app.items[0].quality);
        app.updateQuality();
        assertEquals(99, app.items[0].quality);
        app.updateQuality();
        assertEquals(98, app.items[0].quality);
        app.updateQuality();
        assertEquals(97, app.items[0].quality);
    }

    @Test
    void QualityDegradesTwiceAsFast() {
        Item[] items = new Item[] { new Item("foo", 1, 100) };
        GildedRose app = new GildedRose(items);

        assertEquals(100, app.items[0].quality);
        app.updateQuality();
        assertEquals(99, app.items[0].quality);
        app.updateQuality();
        assertEquals(97, app.items[0].quality);
        app.updateQuality();
        assertEquals(95, app.items[0].quality);
    }

    @Test
    void QualityIsNeverNegatice() {
        Item[] items = new Item[] { new Item("foo", 0, 1) };
        GildedRose app = new GildedRose(items);

        assertEquals(1, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void AgedBrieIncreaseInQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 1) };
        GildedRose app = new GildedRose(items);

        assertEquals(1, app.items[0].quality);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);

//        then the quality increases twice as fast
        app.updateQuality();
        assertEquals(5, app.items[0].quality);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
    }

    @Test
    void QualityNeverMoreThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 48) };
        GildedRose app = new GildedRose(items);

        assertEquals(48, app.items[0].quality);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    @Test
    void SulfurasNeverDecreaseInQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 80) };
        GildedRose app = new GildedRose(items);

        assertEquals(80, app.items[0].quality);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void BackstagePassesQualityIncrease() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 1) };
        GildedRose app = new GildedRose(items);

        assertEquals(1, app.items[0].quality);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
        app.updateQuality();
        assertEquals(5, app.items[0].quality);
    }
    @Test
    void BackstagePassesQualityIncreaseBy2Before10Days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 1) };
        GildedRose app = new GildedRose(items);

        assertEquals(1, app.items[0].quality);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }
    @Test
    void BackstagePassesQualityIncreaseBy3Before5Days() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 1) };
        GildedRose app = new GildedRose(items);

        assertEquals(1, app.items[0].quality);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

}
