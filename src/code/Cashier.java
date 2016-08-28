package code;

import java.util.Map;

/**
 * Created by infor on 26/08/2016.
 */
public class Cashier {
    public Cashier() {
    }

    public double cashPurchase(Map<Product, Integer> purchaseMap){
        double purchaseTotal = 0;
        for (Map.Entry<Product, Integer> entry : purchaseMap.entrySet()){
            purchaseTotal += entry.getKey().getPrice() * entry.getValue();
        }
        return purchaseTotal;
    }
}
