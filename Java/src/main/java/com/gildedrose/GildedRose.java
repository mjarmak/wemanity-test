package com.gildedrose;

import static com.gildedrose.SpecialItems.*;

class GildedRose {
    Item[] items;
    Integer maxQuality = 50;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(AGED_BRIE.toString())
                    && !items[i].name.equals(BACKSTAGE.toString())) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals(SULFURAS.toString())) {
                        if (!items[i].name.equals(CONJURED.toString())) {
                            items[i].quality = items[i].quality - 1;
                        } else {
                            items[i].quality = items[i].quality - 2;
                        }
                    }
                }
            } else {
                if (items[i].quality < maxQuality) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals(BACKSTAGE.toString())) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < maxQuality) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < maxQuality) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals(SULFURAS.toString())) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(AGED_BRIE.toString())) {
                    if (!items[i].name.equals(BACKSTAGE.toString())) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(SULFURAS.toString())) {
                                if (!items[i].name.equals(CONJURED.toString())) {
                                    items[i].quality = items[i].quality - 1;
                                } else {
                                    items[i].quality = items[i].quality - 2;
                                }
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < maxQuality) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
