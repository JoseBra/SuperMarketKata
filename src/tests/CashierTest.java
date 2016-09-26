package tests;

import code.Cashier;
import code.GenericOffer;
import code.OfferManager;
import code.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;


public class CashierTest {
    private Map<Product, Double> purchaseMap;
    private OfferManager offerManager;
    private Cashier cashier;

    @Before
    public void setUp() throws Exception {
        purchaseMap = new HashMap<>();
        cashier = new Cashier();
        offerManager = new OfferManager();
    }

    @Test
    public void cashEmptyPurchase() throws Exception {
        Assert.assertEquals(0, cashier.cashPurchase(purchaseMap, offerManager), 0);
    }

    @Test
    public void cashOneItemPurchase(){
        purchaseMap.put(new Product("Tiger Cereals" , 2.4, "Cereals", "0001"), 2d);
        Assert.assertEquals(4.8, cashier.cashPurchase(purchaseMap, offerManager), 0);
    }

    @Test
    public void cashMultipleItemsPurchase() throws Exception {
        purchaseMap.put(new Product("Tiger Cereals" , 2.5, "Cereals", "0001"), 2d);
        purchaseMap.put(new Product("Socks" , 3, "Cloth", "0002"), 4d);
        purchaseMap.put(new Product("Tomato Soup" , 5, "Can Food", "0003"), 6d);
        purchaseMap.put(new Product("Onions Net" , 10, "Vegetable", "0004"), 1d);
        Assert.assertEquals(57, cashier.cashPurchase(purchaseMap, offerManager), 0);
    }

    @Test
    public void cashPurchaseDetectingOneGenericOffer() throws Exception {
        Product tigerCereals = new Product("Tiger Cereals" , 2.5, "Cereals", "0001");
        purchaseMap.put(tigerCereals, 6d);
        offerManager.addOffer(new GenericOffer(tigerCereals,5,3d));
        Assert.assertEquals(10, cashier.cashPurchase(purchaseMap, offerManager), 0);
    }

    @Test
    public void cashPurchaseDetectionBestOffer() throws Exception{
        Product tigerCereals = new Product("Tiger Cereals" , 2.5, "Cereals", "0001");
        purchaseMap.put(tigerCereals, 7d);
        offerManager.addOffer(new GenericOffer(tigerCereals,5,5d));
        offerManager.addOffer(new GenericOffer(tigerCereals,1,3d));
        Assert.assertEquals(4.5, cashier.cashPurchase(purchaseMap, offerManager), 0);
    }
}
