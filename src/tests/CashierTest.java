package tests;

import code.Cashier;
import code.Product;
import org.junit.Test;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by infor on 26/08/2016.
 */
public class CashierTest {

    @Test
    public void cashEmptyPurchase() throws Exception {
        Map<Product, Integer> purchaseMap = new HashMap<>();
        Cashier cashier = new Cashier();
        Assert.assertEquals(0, cashier.cashPurchase(purchaseMap), 0);
    }

    @Test
    public void cashOneItemPurchase(){
        Map<Product, Integer> purchaseMap = new HashMap<>();
        purchaseMap.put(new Product("Tiger Cereals" , 2.4, "Cereals", "0001"), 2);
        Cashier cashier = new Cashier();
        Assert.assertEquals(4.8, cashier.cashPurchase(purchaseMap), 0);
    }

    @Test
    public void cashMultipleItemsPurchase() throws Exception {
        Map<Product, Integer> purchaseMap = new HashMap<>();
        purchaseMap.put(new Product("Tiger Cereals" , 2.5, "Cereals", "0001"), 2);
        purchaseMap.put(new Product("Socks" , 3, "Cloth", "0002"), 4);
        purchaseMap.put(new Product("Tomato Soup" , 5, "Can Food", "0003"), 6);
        purchaseMap.put(new Product("Onions Net" , 10, "Vegetable", "0004"), 1);
        Cashier cashier = new Cashier();
        Assert.assertEquals(57, cashier.cashPurchase(purchaseMap), 0);
    }
}
