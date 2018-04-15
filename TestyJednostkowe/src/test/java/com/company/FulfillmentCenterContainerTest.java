package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class FulfillmentCenterContainerTest {

    @Test public void testAddCenter(){

        FulfillmentCenterContainer fulfillmentCenterContainer=new FulfillmentCenterContainer();
        fulfillmentCenterContainer.addCenter("MagazineOfFlowers", 1256);
        assertNotNull(fulfillmentCenterContainer.warehouseMap.get("MagazineOfFlowers"));
    }
    @Test public void testRemoveCenter(){
        FulfillmentCenterContainer fulfillmentCenterContainer=new FulfillmentCenterContainer();

        fulfillmentCenterContainer.addCenter("MagazineOfEquipment",5555);
        assertNotNull(fulfillmentCenterContainer.warehouseMap.get("MagazineOfEquipment"));
        fulfillmentCenterContainer.removeCenter("MagazineOfEquipment");
        assertEquals(fulfillmentCenterContainer.warehouseMap.toString(), "{}");

    }

    @Test public void testFindEmpty() {
        FulfillmentCenterContainer fulfillmentCenterContainer = new FulfillmentCenterContainer();
        fulfillmentCenterContainer.addCenter("MagazineOfEquipment", 5555);
        assertNotNull(fulfillmentCenterContainer.warehouseMap.get("MagazineOfEquipment"));
        fulfillmentCenterContainer.findEmpty();
    }


}
