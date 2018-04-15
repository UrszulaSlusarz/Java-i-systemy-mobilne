package com.company;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class FulfillmentCenterTest extends TestCase{
    FulfillmentCenter fulfillmentCenter =new FulfillmentCenter();


@Test public void testAddProduct(){
    Item item1= new Item("rower", ItemCondition.NEW, 568.8,0);
    fulfillmentCenter.addProduct(item1);
    Assert.assertNotNull(item1);
    item1.print();
}

// test ktory nie przejdzie
@Test public void testGetProduct(){
    Item item1= new Item("rolki", ItemCondition.USED, 25.98,0);
    fulfillmentCenter.addProduct(item1);
    fulfillmentCenter.addProduct(item1);
    Assert.assertTrue(item1.getQuantity() == 2);  //daj tu 3, to test nie przejdzie
    fulfillmentCenter.getProduct(item1);
}

@Test  public void testRemoveProduct() {
    Item item1= new Item("rolki", ItemCondition.USED, 25.98,0);
    Item item2= new Item("buty", ItemCondition.NEW, 12.05,0);
    fulfillmentCenter.listproduct.add(item1);
    fulfillmentCenter.listproduct.add(item1);
    fulfillmentCenter.listproduct.add(item2);
    fulfillmentCenter.removeProduct(item1);
    assertNotNull(fulfillmentCenter.listproduct);
    }

  @Test  public void testSearchPartial() {
      Item item1= new Item("kurtki", ItemCondition.NEW, 12.05,0);
      Item item2= new Item("buty", ItemCondition.NEW, 12.05,0);
      fulfillmentCenter.addProduct(item1);
      fulfillmentCenter.addProduct(item2);
      assertNotNull(fulfillmentCenter.searchPartial("bu"));
    }

   @Test public void testSearch() {
        Item item1= new Item("kurtki", ItemCondition.NEW, 12.05,0);
        Item item2= new Item("buty", ItemCondition.NEW, 12.05,0);
        fulfillmentCenter.addProduct(item1);
        fulfillmentCenter.addProduct(item2);
        Assert.assertEquals(fulfillmentCenter.search("buty"), item2.name);//porownanie dwoch wartosci
    }

  @Test  public void testcountByCondition() {
        Item item1= new Item("kurtki", ItemCondition.NEW, 12.05,0);
        Item item2= new Item("buty", ItemCondition.NEW, 12.05,0);
        Item item3= new Item("buty", ItemCondition.USED, 12.05,0);
        fulfillmentCenter.addProduct(item1);
        fulfillmentCenter.addProduct(item2);
        fulfillmentCenter.addProduct(item3);

        Assert.assertEquals(fulfillmentCenter.countByCondition(ItemCondition.NEW), 0);
        Assert.assertEquals(fulfillmentCenter.countByCondition(ItemCondition.USED), 0);
        Assert.assertEquals(fulfillmentCenter.countByCondition(ItemCondition.REFURBISHED), 0);
    }
}