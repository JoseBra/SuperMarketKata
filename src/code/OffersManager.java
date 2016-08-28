package code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JoséBraulio on 28/08/2016.
 */
public class OffersManager {
    ArrayList<Offer> offersList;
    OffersManager instance;

    public OffersManager(ArrayList<Offer> offersList) {
        this.offersList = offersList;
    }

    public void addOffer(Offer offer){
        offersList.add(offer);
    }

    public  void addOffer(List<Offer> offer){
        offer.forEach((offerElement) -> offersList.add(offerElement));
    }

    public void removeOffer(Offer offer){
        offersList.remove(offer);
    }
}
