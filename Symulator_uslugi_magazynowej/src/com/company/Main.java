package com.company;

public class Main
{
    public static void main(String[] args)
    {
        FulfillmentCenter fulfillmentCenter =new FulfillmentCenter();

        Item item1= new Item("piec", ItemCondition.NEW, 568.8,0);
        Item item2= new Item("uszczelki", ItemCondition.USED, 4.9,0);
        Item item3= new Item("paleta", ItemCondition.USED, 877,0);

        //DODWANIE I WYSWIETLANIE PRODUKTU
        System.out.println("Dodano produkty:");
        fulfillmentCenter.addProduct(item1);
        fulfillmentCenter.addProduct(item1);
        item1.print();
        fulfillmentCenter.addProduct(item2);
        fulfillmentCenter.addProduct(item2);
        fulfillmentCenter.addProduct(item2);
        fulfillmentCenter.addProduct(item2);
        item2.print();
        fulfillmentCenter.addProduct(item3);
        item3.print();


        //USUNIECIE JEDNEGO PRODUKTU, JESLI "ILOSC" JEST =0, TO CALKOWITE USUNIECIE
          //fulfillmentCenter.getProduct(item3);
         // fulfillmentCenter.getProduct(item2);

        //USUNIECIE PRODUKTU CALKOWICIE Z MAGAZYNU
         //fulfillmentCenter.removeProduct(item2);
         //fulfillmentCenter.removeProduct(item2);

        //ROZPOZNAJE PRODUKT PO PODANEJ NAZWIE
         fulfillmentCenter.search("paleta") ;

        //ROZPOZNAWANIE PRODUKTU PO PARTII NAZWY
         //fulfillmentCenter.searchPartial("pa");

        //ZWRACA ILOSC PRODUKTOW O DANYM STANIE
         //fulfillmentCenter.countByCondition(ItemCondition.USED);

        //SORTOWANIE PO NAZWIE
         //fulfillmentCenter.sortByName();

        //SORTOWANIE PO ILOSCI
         //fulfillmentCenter.sortByAmount();

        //MAXYMALNA WARTOSC ILOSCI
        //fulfillmentCenter.max();

        //WYSWITLANIE DANYCH O PRODUKTACH WSZYSTKICH
        // fulfillmentCenter.summary();

        //WYSWIETLANIE MAGAZYNU
          System.out.println(fulfillmentCenter);


        ////////////////////////// ZADANIE Z MAP ////////////////////////////////


        FulfillmentCenterContainer fulfillmentCenterContainer= new FulfillmentCenterContainer();

        //DODAWANIE MAGAZYNU
        //fulfillmentCenterContainer.addCenter("Karmelowy",12222222);
        //fulfillmentCenterContainer.addCenter("InterTrade",4564422);

        //USUWANIE MAGAZYNU
        //fulfillmentCenterContainer.removeCenter("Karmelowy");  //usuwanie danego magazynu-dziala

        //WYSWIETL PUSTE MAGAZYNY
        //fulfillmentCenterContainer.findEmpty();

        //ZWRACA NAZWE MAGAZYNU I PROCENTOWE ZAPELNIENIE
        //fulfillmentCenterContainer.summary();

    }
}
