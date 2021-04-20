package com.codecool.magicstore.items;

public abstract class Item {
    private int magicLevel;
    private int valueInGoldCoin;

    public Item(int magicLevel, int valueInGoldCoin) {
        this.magicLevel = magicLevel;
        this.valueInGoldCoin = valueInGoldCoin;
    }

    protected Item() {
    }

    public int getMagicLevel() {
        return magicLevel;
    }

    public int getValueInGoldCoin() {
        return valueInGoldCoin;
    }

    public void setMagicLevel(int magicLevel) {
        this.magicLevel = magicLevel;
    }

    public void setValueInGoldCoin(int valueInGoldCoin) {
        this.valueInGoldCoin = valueInGoldCoin;
        if (valueInGoldCoin <= 0)
        {
            throw new IllegalArgumentException("Non positive values are not permitted");
        }
    }

}
