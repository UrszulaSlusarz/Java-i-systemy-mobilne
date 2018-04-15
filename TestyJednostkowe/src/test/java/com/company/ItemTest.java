package com.company;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {


    //Sprawdza, czy funkcja rzuca wyjątek dla odpowiednich danych
    //Taki test jednostkowy nie przejdzie jeśli wyjątek nie zostanie rzucony.
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownIllegalArgumentException() {
        FulfillmentCenter fulfillmentCenter =new FulfillmentCenter();
        Item item1= new Item("rower", ItemCondition.NEW, 1001,0);
        fulfillmentCenter.addProduct(item1);
        item1.print();
    }

    @Test public void getQuantity(){
        Item item1= new Item("rower", ItemCondition.NEW, 258,3);
        assertTrue(item1.getQuantity() == 3);
    }

    @Test public void testCompareTo() {
        Item item1 = new Item("rower", ItemCondition.NEW, 56, 1);
        Item item2 = new Item("rower", ItemCondition.USED, 30, 1);
        assertEquals(item1.compareTo(item2), 0);
    }

    @Test public void testPrint(){
        Item item = new Item("biurko", ItemCondition.NEW, 45, 1);
        String expectedOutput = "name=biurko, quantity=1" ;
        Assert.assertEquals(expectedOutput, item.print());
    }


}