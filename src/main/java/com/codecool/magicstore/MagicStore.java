package com.codecool.magicstore;

import com.codecool.magicstore.items.Item;

import java.util.ArrayList;
import java.util.List;

class MagicStore extends MagicBox {
    List<MagicBox> magicBoxes;

    public MagicStore(String owner, String spell, Item item, int itemCount) {
        super(owner, spell, item, itemCount);
    }

    public void addMagicBox(MagicBox magicBox) {
        magicBoxes.add(magicBox);
    }

    public int getValueOfAllItemsInStore() {
        return 10;
    }
    //TODO Your code comes here
}
