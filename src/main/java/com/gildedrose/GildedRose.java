package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            qualityUpdating(item);

            itemIfExpired(item);

            conjuredItem(item);
        }
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstage(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAged(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isConjured(Item item) {
        return item.name.startsWith("Conjured");
    }

    private void itemIfExpired(Item item) {
        if (item.sellIn < 0) {
            disposeExpired(item);
        }
    }

    private void qualityUpdating(Item item) {
        if (!isAged(item) && !isBackstage(item)) {
            if (item.quality > 0) {
                if (!isSulfuras(item)) {
                    item.quality--;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality++;

                if (isBackstage(item)) {
                    if (item.sellIn < 11) {
                        qualityCheck(item);
                    }

                    if (item.sellIn < 6) {
                        qualityCheck(item);
                    }
                }
            }
        }

        if (!isSulfuras(item)) {
            item.sellIn--;
        }
    }

    private void conjuredItem(Item item) {
        if(isConjured(item)) {
            item.quality -= 2;
            if (item.quality < 0) {
                item.quality = 0;
            }
            item.sellIn--;
        }
    }

    private void disposeExpired(Item item) {
        if (!isAged(item)) {
            if (!isBackstage(item)) {
                if (item.quality > 0) {
                    if (!isSulfuras(item)) {
                        item.quality--;
                    }
                }
            } else {
                item.quality = 0;
            }
        } else {
            qualityCheck(item);
        }
    }

    private void qualityCheck(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}