package code;

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
    public double getProductAmount() {
        return 2d;
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
