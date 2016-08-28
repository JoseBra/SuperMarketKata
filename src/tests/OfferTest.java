package tests;

import code.GenericOffer;
import code.Offer;
import code.Product;
import code.TwoForOneOffer;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by infor on 26/08/2016.
 */
public class OfferTest {

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
}
