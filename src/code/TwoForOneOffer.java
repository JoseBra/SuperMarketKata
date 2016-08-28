package code;

/**
 * Created by infor on 26/08/2016.
 */
public class TwoForOneOffer implements Offer {
    private Product product;

    public TwoForOneOffer(Product product) {
        this.product = product;
    }

    @Override
    public double operateOffer() {
        return product.getPrice();
    }

    @Override
    public Integer getProductAmount() {
        return 2;
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
