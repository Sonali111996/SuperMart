package com.stock;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String,StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if(item != null) {
            // check if already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // If there are already stocks on this item, adjust the quantity
            if(inStock != item) {
                item.adjustStockQuantity(inStock.getQuantity());
            }

            list.put(item.getName(), item);
            return item.getQuantity();
        }
        return 0;

        }


    public int sellStock(String itemName,int Quantity){
         StockItem inStock=list.getOrDefault(itemName,null);
        if((inStock != null) && (inStock.getQuantity() >= Quantity) && (Quantity >0)) {
            inStock.adjustStockQuantity(-Quantity);
            return Quantity;
        }
        return 0;
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }
    public StockItem get(String key){
        return list.get(key);
    }


    public Map<String,StockItem> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
       String s="Stock List\n";
       double total=0.0;
       for (Map.Entry<String,StockItem> item :list.entrySet()){
           StockItem stockItem=item.getValue();
           double itemCost=stockItem.getPrice()*stockItem.getQuantity();
           s=s+stockItem+" There are "+stockItem.getQuantity()+" in stock. Value of item :";
           s=s+itemCost+"\n";
           total+=itemCost;
       }
     return s+"  total "+ total;

    }

}
