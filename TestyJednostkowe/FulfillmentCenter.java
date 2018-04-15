package com.company;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FulfillmentCenter
{
     public String nameWarehouse="BudPol";
     public List<Item> listproduct=new ArrayList<Item>();
     public int maxCapacityproduct=1000000;
     public int  currentmass=0;


   public void addProduct(Item addproduct) {
      if(currentmass + addproduct.mass > maxCapacityproduct) {
          System.err.println("Magazyn jest pelny");
        }
        else {
          int comparison=0;
            listproduct.add(addproduct);
            currentmass += addproduct.mass;
            Iterator<Item> iterator = listproduct.iterator(); //przechodzi po koeljnych talicach listy
            while (comparison!=0 && iterator.hasNext()) {

              comparison=addproduct.name.compareTo(iterator.next().name);
          }
              if( comparison==0){
                  addproduct.quantity++;
              }
          }
        }

    public void getProduct(Item addproduct) {
        if(listproduct.contains(addproduct)) {
           listproduct.remove(addproduct);
    }
    if (addproduct.quantity==0) {
            listproduct.remove(addproduct);
            System.out.println("PRODUKT"+" "+addproduct +" " +"ZOSTAL USUNIETY!");
            System.out.println( "Liczba produktow: "+listproduct.size());
        } else {
            System.out.println("Usunelismy jeden produkt: " + addproduct);
            System.out.println( "liczba produktow w magazynie: "+listproduct.size());
        }
    }

   public void removeProduct(Item addproduct) {

       while( listproduct.remove(addproduct) ){
       }
       System.out.println("Usniecie produktu z magazynu." + addproduct);
       System.out.println("Liczba produktow w magazynie: " +listproduct.size());
    }

   public String search(String nameProduct)
    {
        for(Item current: listproduct){
            if (nameProduct.equals(current.name)){
                System.out.println("Produkt o podanej nazwie.");
                current.print();
            }
        }
       return nameProduct;
    }


    public String searchPartial(String nameProduct)
    {
        Iterator<Item> iterator=listproduct.iterator();
        List<Item> listItems = new ArrayList<Item>();
        while(iterator.hasNext()) {
            Item current=iterator.next();
            if(current.name.contains(nameProduct)){
                listItems.add(current);
                System.out.println(current);
            }
        }
        return nameProduct;
    }


    public int countByCondition(ItemCondition condition)
    {
        int number=0;
        Iterator<Item> iterator=listproduct.iterator();
        while (iterator.hasNext()){
            Item current=iterator.next();
           if( condition.compareTo(current.state)==0){
               number++;
           }
        }
        System.out.println("Liczba produktow o danym stanie: "+number);
          return 0;
    }

    void summary()
    {
        System.out.println("Informacje o produktach");
        Iterator<Item> iterator=listproduct.iterator();
        while (iterator.hasNext()){
            iterator.next().print();
        }
    }
    public void sortByName()
    {
        Collections.sort(listproduct);
        System.out.println(listproduct);
    }

    public void sortByAmount() {
        Collections.sort(listproduct, new Sort());
        System.out.println("Posortowane produkty po ilosci:" +listproduct);
    }
    //COMPARATOR do sortowania po ilosci
    private class Sort implements Comparator<Item> {

    public int compare(Item o1, Item o2) {
        int sorting=o1.getQuantity()-o2.getQuantity();
        if(sorting == 0) {
            return o1.compareTo(o2);
        }
        return sorting; }
    }

   public void max() {
        System.out.println("Najwieksza wartosc ilosci w produkcie: " + Collections.max(listproduct, new Sort()));
    }


    @Override
    public String toString() {
        return  "nameWarehouse='" + nameWarehouse + '\'' + ", listproduct=" + listproduct;
    }

//    public String getNameWarehouse() {
//        return nameWarehouse;
//    }
//
//    public void setNameWarehouse(String nameWarehouse) {
//        this.nameWarehouse = nameWarehouse;
//    }
//
//    public List<Item> getListproduct() {
//        return listproduct;
//    }
//
//    public void setListproduct(List<Item> listproduct) {
//        this.listproduct = listproduct;
//    }
//
//    public int getMaxCapacityproduct() {
//        return maxCapacityproduct;
//    }
//
//    public void setMaxCapacityproduct(int maxCapacityproduct) {
//        this.maxCapacityproduct = maxCapacityproduct;
//    }
//
//    public int getCurrentmass() {
//        return currentmass;
//    }
//
//    public void setCurrentmass(int currentmass) {
//        this.currentmass = currentmass;
//    }
//
//    public List<Item> getItems() { return listproduct; }
}
