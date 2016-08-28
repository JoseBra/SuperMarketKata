package code;

/**
 * Created by infor on 26/08/2016.
 */
public class GenericOffer implements Offer {
    private Product product;
    private double price;
    private Integer productAmount;

    public GenericOffer(Product product, double price, Integer productAmount) {
        this.product = product;
        this.price = price;
        this.productAmount = productAmount;
    }

    @Override
    public double operateOffer() {
        return price;
    }

    @Override
    public Integer getProductAmount() {
        return this.productAmount;
    }

    @Override
    public Product getProduct() {
        return this.product;
    }
}
