package code;

import java.util.ArrayList;
import java.util.List;

public class OfferManager {
    private List<Offer> offersList;

    public OfferManager() {
        offersList = new ArrayList<>();
    }

    public void addOffer(Offer offer) {
        offersList.add(offer);
    }

    public void clearOffers(){
        offersList.clear();
    }

    public List<Offer> detectProductOffer(Product product, double productAmount) {
        List<Offer> possibleOffers = new ArrayList<>();
        for (Offer offer : offersList) {
            if (offer.getProduct().equals(product) && productAmount >= offer.getProductAmount()){
                possibleOffers.add(offer);
            }
        }
        return calculateBestOffersCombination(possibleOffers, productAmount);
    }

    private List<Offer> calculateBestOffersCombination(List<Offer> offersList, double productAmount) {
        List<Offer> bestOfferCombination = new ArrayList<>();
        double bestPriceFound = -1;
        int timesOfferCanApply;
        for (Offer offer : offersList) {
            timesOfferCanApply = (int)(productAmount/offer.getProductAmount());
            double totalOffersPrice = offer.operateOffer()*timesOfferCanApply;
            double spareProductsPrice = (productAmount - (timesOfferCanApply*offer.getProductAmount()))*offer.getProduct().getPrice();
            if (bestPriceFound < 0 || (totalOffersPrice + spareProductsPrice) < bestPriceFound){
                bestPriceFound = totalOffersPrice + spareProductsPrice;
                bestOfferCombination.clear();
                for (int i = 0; i<timesOfferCanApply; i++) bestOfferCombination.add(offer);
            }
        }
        return bestOfferCombination;
    }
}
