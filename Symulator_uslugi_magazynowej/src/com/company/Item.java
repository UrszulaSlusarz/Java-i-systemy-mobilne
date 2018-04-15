package com.company;

public  class Item implements Comparable<Item> {
    protected String name;         //nazwa
    protected ItemCondition state; //stan
    protected double mass;         //masa
    protected int quantity;        //ilosc

    public Item(String name, ItemCondition state, double mass, int quantity)
    {
        this.name = name;
        this.state = state;
        this.mass = mass;
        this.quantity = quantity;
    }

    void print()
    {
        System.out.println( "name='" + name + '\'' + ", state=" + state + ", quantity=" + quantity);
    }

    @Override
    public String toString()
    {
        return "name='" + name +  ", quantity=" + quantity + '}';
    }

    @Override
    public int compareTo(Item object)
    {   int comparename=name.compareTo(object.name);
          return comparename;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




    }



