package com.company;

public  class Item implements Comparable<Item> {
    protected String name;         //nazwa
    protected ItemCondition state; //stan
    protected double mass;         //masa
    protected int quantity;        //ilosc

    public Item(String name, ItemCondition state, double mass, int quantity)
    {
        if(mass>1000){
                throw new IllegalArgumentException("mass of product is too bigger!");
        }
        this.name = name;
        this.state = state;
        this.mass = mass;
        this.quantity = quantity;
    }

    public String print()
    {
        System.out.println("name=" + name  + " state="+state+ ", quantity=" + quantity);
        return "name=" + name  + ", quantity=" + quantity;
    }

    @Override
    public String toString()
    {
        return "name=" + name +  ", quantity=" + quantity ;
    }


    public int compareTo(Item object)
    {   int comparename=name.compareTo(object.name);
          return comparename;
    }


    public int getQuantity() {
        return quantity;
    }

//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public ItemCondition getState() {
//        return state;
//    }
//
//    public void setState(ItemCondition state) {
//        this.state = state;
//    }

//    public double getMass() {
//        return mass;
//    }
//
//    public void setMass(double mass) {
//        this.mass = mass;
//    }
}



