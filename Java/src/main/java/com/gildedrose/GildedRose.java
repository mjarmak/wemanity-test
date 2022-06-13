package com.gildedrose;

import static com.gildedrose.SpecialItems.*;

class GildedRose {
    Item[] items;
    Integer maxQuality = 50;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(AGED_BRIE.toString())
                && !item.name.equals(BACKSTAGE.toString())) {
                if (item.quality > 0) {
                    if (!item.name.equals(SULFURAS.toString())) {
                        if (!item.name.equals(CONJURED.toString())) {
                            item.quality = item.quality - 1;
                        } else {
                            item.quality = item.quality - 2;
                        }
                    }
                }
            } else {
                if (item.quality < maxQuality) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE.toString())) {
                        if (item.sellIn < 11) {
                            if (item.quality < maxQuality) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < maxQuality) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS.toString())) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE.toString())) {
                    if (!item.name.equals(BACKSTAGE.toString())) {
                        if (item.quality > 0) {
                            if (!item.name.equals(SULFURAS.toString())) {
                                if (!item.name.equals(CONJURED.toString())) {
                                    item.quality = item.quality - 1;
                                } else {
                                    item.quality = item.quality - 2;
                                }
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < maxQuality) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
