package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GildedRoseTest {
    private GildedRose getGildedRose(String cake, int sellIn, int quality) {
        Item[] items = new Item[] {
                new Item(cake, sellIn, quality)
        };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        return gildedRose;
    }

    @Test
    public void nameIsNotAgedBrie() {
        GildedRose gildedRose = getGildedRose("cake", 0, 1);
        Assertions.assertEquals("cake, -1, 0", gildedRose.items[0].toString());
    }

    @Test
    public void nameIsNotAgedBrieAndQualityLessThan0() {
        GildedRose gildedRose = getGildedRose("cake", 0, -1);
        Assertions.assertEquals("cake, -1, -1", gildedRose.items[0].toString());
    }

    @Test
    public void nameIsSulfura() {
        GildedRose gildedRose = getGildedRose("Sulfuras, Hand of Ragnaros", 0, 1);
        Assertions.assertEquals("Sulfuras, Hand of Ragnaros, 0, 1", gildedRose.items[0].toString());
    }

    @Test
    public void nameIsAgedBrieAndQualityLessThan50() {
        GildedRose gildedRose = getGildedRose("Aged Brie", 4, 30);
        Assertions.assertEquals("Aged Brie, 3, 31", gildedRose.items[0].toString());
    }

    @Test
    public void nameIsAgedBrieAndQualityLargerThan50() {
        GildedRose gildedRose = getGildedRose("Aged Brie", 4, 56);
        Assertions.assertEquals("Aged Brie, 3, 56", gildedRose.items[0].toString());
    }

    @Test
    public void nameIsBackstageAndSellInLargerThan12() {
        GildedRose gildedRose = getGildedRose("Backstage passes to a TAFKAL80ETC concert", 20, 0);
        Assertions.assertEquals("Backstage passes to a TAFKAL80ETC concert, 19, 1", gildedRose.items[0].toString());
    }

    @Test
    public void nameIsBackstageAndSellInLessThan11QualityLessThan50() {
        GildedRose gildedRose = getGildedRose("Backstage passes to a TAFKAL80ETC concert", 8, 49);
        Assertions.assertEquals("Backstage passes to a TAFKAL80ETC concert, 7, 50", gildedRose.items[0].toString());
    }

    @Test
    public void nameIsBackstageAndSellInLessThan6() {
        GildedRose gildedRose = getGildedRose("Backstage passes to a TAFKAL80ETC concert", 4, 49);
        Assertions.assertEquals("Backstage passes to a TAFKAL80ETC concert, 3, 50", gildedRose.items[0].toString());
    }

    @Test
    public void nameIsNotBackstageAndSellInLessThan0() {
        GildedRose gildedRose = getGildedRose("food", -1, 3);
        Assertions.assertEquals("food, -2, 1", gildedRose.items[0].toString());
    }

    @Test
    public void nameIsSulfurasAndSellInLessThan0() {
        GildedRose gildedRose = getGildedRose("Sulfuras, Hand of Ragnaros", -1, 3);
        Assertions.assertEquals("Sulfuras, Hand of Ragnaros, -1, 3", gildedRose.items[0].toString());
    }

    @Test
    public void nameIsBackstageAndSellInLessThanZero() {
        GildedRose gildedRose = getGildedRose("Backstage passes to a TAFKAL80ETC concert", -1, 3);
        Assertions.assertEquals("Backstage passes to a TAFKAL80ETC concert, -2, 0", gildedRose.items[0].toString());
    }

    @Test
    public void nameIsAgedBrieAndSellInLessThanZero() {
        GildedRose gildedRose = getGildedRose("Aged Brie", -1, 3);
        Assertions.assertEquals("Aged Brie, -2, 5", gildedRose.items[0].toString());
    }

    @Test
    public void nameIsAgedBrieAndQualityLargerThan50AndSellInLessThan0() {
        GildedRose gildedRose = getGildedRose("Aged Brie", -1, 51);
        Assertions.assertEquals("Aged Brie, -2, 51", gildedRose.items[0].toString());
    }
}
