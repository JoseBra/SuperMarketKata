package tests;
import code.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class OfferTest {
    private OfferManager offerManager;
    private Product tigerCereals;

    @Before
    public void setUp() throws Exception {
        offerManager = new OfferManager();
        tigerCereals = new Product("Tiger Cereals", 10, "Cereals", "00001");
    }

    @Test
    public void createGenericOffer(){
        Offer offer = new GenericOffer(new Product("Tiger Cereals", 2.5, "Cereals", "0001"), 3.75, 2);
        Assert.assertEquals(new Product("Tiger Cereals", 2.5, "Cereals", "0001"), offer.getProduct());
    }

    @Test
    public void create2x1Offer() throws Exception {
        Offer offer = new TwoForOneOffer(new Product("Tiger Cereals", 2.5, "Cereals", "0001"));
        Assert.assertEquals(new Product("Tiger Cereals", 2.5, "Cereals", "0001"), offer.getProduct());
    }

    @Test
    public void detectGenericOfferSecondUnitHalfPrice(){
        offerManager.clearOffers();
        offerManager.addOffer(new GenericOffer(tigerCereals,tigerCereals.getPrice()*1.5,2));
        Assert.assertEquals(1, offerManager.detectProductOffer(tigerCereals, 2).size());
    }

    @Test
    public void detectBestOfferWhenMultiplePossibleOffers() throws Exception {
        offerManager.clearOffers();
        offerManager.addOffer(new GenericOffer(tigerCereals,tigerCereals.getPrice()*1.5,2));
        offerManager.addOffer(new GenericOffer(tigerCereals,tigerCereals.getPrice()*1,3));
        List<Offer> availableOffers = offerManager.detectProductOffer(tigerCereals, 4);
        double offersFinalPrice = 0;
        for (Offer offer: availableOffers) {
            offersFinalPrice += offer.operateOffer();
        }
        Assert.assertEquals(1, availableOffers.size());
        Assert.assertEquals(tigerCereals.getPrice(), offersFinalPrice, 0);
    }

    @Test
    public void detectOfferCanBeAppliedMultipleTimes(){
        offerManager.clearOffers();
        offerManager.addOffer(new GenericOffer(tigerCereals,tigerCereals.getPrice()*1,2));
        List<Offer> availableOffers = offerManager.detectProductOffer(tigerCereals, 6);
        double offersFinalPrice = 0;
        for (Offer offer: availableOffers) {
            offersFinalPrice += offer.operateOffer();
        }
        Assert.assertEquals(3, availableOffers.size());
        Assert.assertEquals(tigerCereals.getPrice()*3, offersFinalPrice, 0);
    }

    @Test
    public void detectTwoForOneOffer(){
        offerManager.clearOffers();
        offerManager.addOffer(new TwoForOneOffer(tigerCereals));
        List<Offer> availableOffers = offerManager.detectProductOffer(tigerCereals, 2);
        Assert.assertEquals(1, availableOffers.size());
    }

    @Test
    public void detectBestOfferWhenMultipleTypesOfOffer(){
        offerManager.clearOffers();
        offerManager.addOffer(new TwoForOneOffer(tigerCereals));
        offerManager.addOffer(new GenericOffer(tigerCereals,tigerCereals.getPrice()*1.5,5));
        List<Offer> availableOffers = offerManager.detectProductOffer(tigerCereals, 5);
        double offersFinalPrice = 0;
        for (Offer offer: availableOffers) {
            offersFinalPrice += offer.operateOffer();
        }
        Assert.assertEquals(1, availableOffers.size());
        Assert.assertEquals(tigerCereals.getPrice()*1.5, offersFinalPrice, 0);
    }
}
