package com.codecool.magicstore;

import cccr.CCCRTestExecutionListener;
import com.codecool.magicstore.items.Item;
import com.codecool.magicstore.items.MagicWand;
import com.codecool.magicstore.items.GoldCoin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({CCCRTestExecutionListener.class})
class MagicStoreTest {
    private MagicStore magicStore;
    private MagicBox magicBox;
    private MagicBox magicBoxForWand;
    private Item goldCoin;
    private Item magicWand;

    @BeforeEach
    void init(){
        magicStore = new MagicStore();
        goldCoin = new GoldCoin();
        magicBox = new MagicBox("Gandalf","abrakadabra", goldCoin, 100);
        magicWand = new MagicWand(10);
        magicBoxForWand = new MagicBox("Harry Potter","alohomora", magicWand, 3);
    }

    @Test
    void addMagicBoxWorks() {
        magicStore.addMagicBox(magicBox);
        assertTrue(magicStore.getMagicBoxes().contains(magicBox));
    }

    @Test
    void getValueOfAllItemsInStoreWorks() {
        magicStore.addMagicBox(magicBoxForWand);
        magicStore.addMagicBox(magicBox);
        assertEquals(130, magicStore.getValueOfAllItemsInStore());
    }

    @Test
    void goldCoinValueIsOneByDefault(){
        assertEquals(1, goldCoin.getValueInGoldCoin());
    }

    @Test
    void magicWandValueIsSetCorrectlyByConstructor(){
        magicWand = new MagicWand(5);
        assertEquals(5, magicWand.getValueInGoldCoin());
    }

    @Test
    void magicWandValueIsSetCorrectlyBySetter(){
        magicWand.setValueInGoldCoin(10);
        assertEquals(10, magicWand.getValueInGoldCoin());
    }

    @Test
    void exceptionThrownWhenTryToSetToInvalidValueInGoldCoin(){
        assertThrows(IllegalArgumentException.class, () -> magicWand.setValueInGoldCoin(0));
    }

    @Test
    void exceptionThrownWhenConstructorCalledWithInvalidValueInGoldCoin(){
        assertThrows(IllegalArgumentException.class, () -> new MagicWand(-0));
    }

    @Test
    void goldCoinDefaultMagicLevelIsZero(){
        assertEquals(0, goldCoin.getMagicLevel());
    }

    @Test
    void magicWandDefaultMagicLevelIsFive(){
        magicWand = new MagicWand(5);
        assertEquals(5, magicWand.getMagicLevel());
    }

    @Test
    void getOwnerWorks() {
        assertEquals("Gandalf", magicBox.getOwner());
    }

    @Test
    void getSpellWorks() {
        assertEquals("abrakadabra", magicBox.getSpell());
    }

    @Test
    void getItemWorks() {
        assertEquals(goldCoin, magicBox.getItem());
    }

    @Test
    void putItemsInBoxWorks() {
        magicBox.putItemsInBox(100);
        assertEquals(200, magicBox.getItemCount());
    }

    @Test
    void putItemsInBoxWorksThrowsException() {
        assertThrows(IllegalArgumentException.class, ()-> magicBox.putItemsInBox(-1));
    }

    @Test
    void removeItemsWorks() {
        magicBox.removeItems("abrakadabra", 10);
        assertEquals(90, magicBox.getItemCount());
    }

    @Test
    void removeItemsReturnsNumberOfItemsCorrectly() {
        assertEquals(2, magicBox.removeItems("abrakadabra", 2));
    }

    @Test
    void removeItemsReturnsZeroForUnCorrectSpell() {
        assertEquals(0, magicBox.removeItems("abrakadabraa", 100));
    }

    @Test
    void removeItemsReturnsZeroIfNotEnoughItems() {
        assertEquals(0, magicBox.removeItems("abrakadabra", 5000));
    }

    @Test
    void getItemsValueWorks(){
        assertEquals(30, magicBoxForWand.getItemsValueInBox());
    }
}