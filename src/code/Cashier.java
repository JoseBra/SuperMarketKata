package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cashier {
    private List<Offer> appliedOffers;

    public Cashier() {
        appliedOffers = new ArrayList<>();
    }

    public double cashPurchase(Map<Product, Double> purchaseMap, OfferManager offerManager){
        double purchaseTotal = 0;
        for (Map.Entry<Product, Double> entry : purchaseMap.entrySet()){
            List<Offer> productOffers = offerManager.detectProductOffer(entry.getKey(), entry.getValue());
            for (Offer offer : productOffers){
                purchaseTotal += offer.operateOffer();
                entry.setValue(entry.getValue() - offer.getProductAmount());
                appliedOffers.add(offer);
            }
            purchaseMap.entrySet().removeIf( e-> e.getValue() <= 0);
            purchaseTotal += entry.getKey().getPrice() * entry.getValue();
        }
        return purchaseTotal;
    }
}
