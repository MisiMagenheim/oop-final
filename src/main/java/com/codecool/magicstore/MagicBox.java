package com.codecool.magicstore;

import com.codecool.magicstore.items.Item;

class MagicBox {
    private String owner;
    private String spell;
    private Item item;
    private int itemCount;

    public MagicBox(String owner, String spell, Item item, int itemCount) {
        this.owner = owner;
        this.spell = spell;
        this.item = item;
        this.itemCount = itemCount;
    }

    public void putItemsInBox(int numberOfItems) {
        if(numberOfItems <= 0)
            throw new IllegalArgumentException("Has to be positive");
        else
            itemCount += numberOfItems;
    }

    public int removeItems(String spell, int numberOfItems) {
        if (this.spell == spell && itemCount >= numberOfItems) {
            itemCount -= numberOfItems;
            return numberOfItems;
        }
        return 0;

    }

    public int getItemsValueInBox(int itemCount) {
        return item.getValueInGoldCoin();
    }


    public String getOwner() {
        return owner;
    }

    public String getSpell() {
        return spell;
    }

    public Item getItem() {
        return item;
    }

    public int getItemCount() {
        return itemCount;
    }

    //TODO your code comes here
}
