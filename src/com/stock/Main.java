package com.stock;

public class Main {
    private static StockList stockList=new StockList();
    public static void main(String[] args) {
        StockItem temp=new StockItem("Body Lotion",240,5);
        stockList.addStock(temp);

        temp=new StockItem("Face Wash",70,5);
        stockList.addStock(temp);

        temp=new StockItem("Soap",40,5);
        stockList.addStock(temp);

        Basket myBasket = new Basket("Body Lotion");
        myBasket.addToBasket(temp,2);
        myBasket=new Basket("Face Wash");
        myBasket.addToBasket(temp,2);

        System.out.println(myBasket);

    }
}
