package com.stock;

import java.util.Objects;

public class StockItem implements Comparable<StockItem> {
    private String name;
    private double price;
    private int quantity=0;

    public StockItem(String name, double price,int quantity) {
        this.name = name;
        this.price = price;
        this.quantity=quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setPrice(double price) {
        if(price>0) {
            this.price = price;
        }
    }
    public void adjustStockQuantity(int reqQuantity){
        int newQuantity=this.quantity+reqQuantity;
        if(newQuantity>=0){
            this.quantity=newQuantity;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        String objName = ((StockItem)o).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+31;
    }

    @Override
    public int compareTo(StockItem stockItem) {
        System.out.println("Enter stock item to compare");
        if(this==stockItem){
            return 0;
        }
        if(stockItem!=null){
            return this.name.compareTo(stockItem.getName());
        }
        throw new NullPointerException();
    }
    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }
}
