package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class FulfillmentCenterContainer  {

    Map<String, FulfillmentCenter> warehouseMap = new HashMap<String, FulfillmentCenter>();

   public void addCenter(String nameWarehouse, int maxCapacityproduct){
       FulfillmentCenter fulfillmentCenter=new FulfillmentCenter();
       warehouseMap.put(nameWarehouse,fulfillmentCenter);
       System.out.println("Warehouse: " + nameWarehouse);
    }

   public void removeCenter(String newWarehouse) {
       warehouseMap.remove(newWarehouse);
       System.out.println("Warehouse after remove: " + warehouseMap);
   }

   public void findEmpty() {
    List<FulfillmentCenter> emptyfulfillmentCenter = new ArrayList<FulfillmentCenter>();
    for (String key : warehouseMap.keySet()) {
        FulfillmentCenter value = warehouseMap.get(key);
        if (value.listproduct.size() == 0) {
            emptyfulfillmentCenter.add(value);
        }
    }System.out.println( "Puste magazyny: " +warehouseMap.keySet());
   }

    public void summary(){
    for(String key: warehouseMap.keySet()) {  /// lece przez cala mape(magazyn), keyset zwraca zbior kluczy
        FulfillmentCenter value = warehouseMap.get(key);   //do konkretnego magaynu przypisuje (sciagam wartosc konkretnego klucza), kluczem jest nazwa magazynu,
        System.out.println(key+"-"+(value.currentmass/value.maxCapacityproduct)*100+"%");
    }
   }

    @Override
    public String toString() {
        return "FulfillmentCenterContainer{" + "warehouse=" + warehouseMap + '}';
    }
}
