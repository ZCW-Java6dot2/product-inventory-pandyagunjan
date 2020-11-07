package models;

import org.junit.Assert;
import org.junit.Test;

public class WhiskeyTest {
    @Test // (1)
    public void constructorTest(){

        // (2)
        int expectedId = 6;
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        int expectedQty = 10;


        // (3)
        Whiskey testSneaker = new Whiskey(expectedId, expectedName, expectedBrand,expectedQty);

        // (4)
        Assert.assertEquals(expectedId, testSneaker.getId());
        Assert.assertEquals(expectedName, testSneaker.getName());
        Assert.assertEquals(expectedBrand, testSneaker.getBrand());
        Assert.assertEquals(expectedQty, testSneaker.getQty());

    }



}
