package tests;

import org.junit.Test;
import org.junit.Assert;
import code.Product;

/**
 * Created by infor on 26/08/2016.
 */
public class ItemTest {
    @Test
    public void createNewItem(){
        Product testCereals = new Product("Tiger Cereals", 2.0d, "Cereals", "0001");
        Assert.assertEquals("Tiger Cereals", testCereals.getName());
    }
}
