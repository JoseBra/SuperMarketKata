package code;

public class GenericOffer implements Offer {
    private Product product;
    private double price;
    private double productAmount;

    public GenericOffer(Product product, double price, double productAmount) {
        this.product = product;
        this.price = price;
        this.productAmount = productAmount;
    }

    @Override
    public double operateOffer() {
        return price;
    }

    @Override
    public double getProductAmount() {
        return this.productAmount;
    }

    @Override
    public Product getProduct() {
        return this.product;
    }
}
