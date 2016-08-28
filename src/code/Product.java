package code;

import org.junit.Test;

/**
 * Created by infor on 26/08/2016.
 */
public class Product {
    String name;
    double price;
    String type;
    String barCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return barCode.equals(product.barCode);

    }

    @Override
    public int hashCode() {
        return barCode.hashCode();
    }

    public Product(String name, double price, String type, String barCode) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
