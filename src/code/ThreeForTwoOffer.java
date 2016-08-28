package code;

/**
 * Created by JoséBraulio on 28/08/2016.
 */
public class ThreeForTwoOffer implements Offer {
    Product product;

    public ThreeForTwoOffer(Product product) {
        this.product = product;
    }

    @Override
    public double operateOffer() {
        return product.getPrice()*2;
    }

    @Override
    public Integer getProductAmount() {
        return 3;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offer offer = (Offer) o;

        if (product.equals(offer.getProduct()) && this.operateOffer() == offer.operateOffer() && this.getProductAmount() == offer.getProductAmount()){
            return true;
        }
        return  false;
    }
}
