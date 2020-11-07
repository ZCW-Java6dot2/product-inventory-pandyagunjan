package services;

import models.Sneaker;
import services.*;

import org.junit.Assert;
import org.junit.Test;

public class SneakerServiceTest {

    @Test
    public void createTest(){

        // (1)
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        int expectedSize = 10;
        int expectedQty = 10;
        float expectedPrice = 80.00f;

        // (2)
        SneakerService sneakerService = new SneakerService();
        Sneaker testSneaker = sneakerService.create(expectedName, expectedBrand,expectedSport, expectedSize, expectedQty, expectedPrice);

        // (3)
        int actualId = testSneaker.getId();
        String actualName = testSneaker.getName();
        String actualBrand = testSneaker.getBrand();
        String actualSport = testSneaker.getSport();
        int actualSize = testSneaker.getSize();
        int actualQty = testSneaker.getQty();
        float actualPrice = testSneaker.getPrice();

        // (4)
        Assert.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedBrand, actualBrand);
        Assert.assertEquals(expectedSport, actualSport);
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedQty, actualQty);
        Assert.assertEquals(expectedPrice, actualPrice,0);

    }
    @Test
    public void findSneakerTest(){


        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        int expectedSize = 10;
        int expectedQty = 10;
        float expectedPrice = 80.00f;


        SneakerService sneakerService = new SneakerService();
        Sneaker testSneaker = sneakerService.create(expectedName, expectedBrand,expectedSport, expectedSize, expectedQty, expectedPrice);


        Sneaker expectedSneaker=sneakerService.findSneaker(0);
        Assert.assertEquals(expectedSneaker, testSneaker);

    }

    @Test
    public void findAllTest(){


        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        int expectedSize = 10;
        int expectedQty = 10;
        float expectedPrice = 80.00f;
        SneakerService sneakerService = new SneakerService();
        Sneaker testSneaker = sneakerService.create(expectedName, expectedBrand,expectedSport, expectedSize, expectedQty, expectedPrice);
        Sneaker expectedSneaker=sneakerService.findSneaker(0);
        Assert.assertEquals(expectedSneaker, testSneaker);


        //second value
        String expectedName1 = "Daksh Pandya";
        String expectedBrand1 = "Nike";
        String expectedSport1 = "Baseball";
        int expectedSize1 = 8;
        int expectedQty1 = 5;
        float expectedPrice1 = 55f;
        Sneaker testSneaker1 = sneakerService.create(expectedName1, expectedBrand1,expectedSport1, expectedSize1, expectedQty1, expectedPrice1);

        Sneaker expectedSneaker1=sneakerService.findSneaker(1);

        Sneaker[] sneakerArrayActual = new Sneaker[2];
        sneakerArrayActual[0]= testSneaker;
        sneakerArrayActual[1]= testSneaker1;

        Sneaker [] sneakerExpected = sneakerService.findAll();

        Assert.assertEquals(sneakerArrayActual[0], sneakerExpected[0]);
        Assert.assertEquals(sneakerArrayActual[1], sneakerExpected[1]);

    }
    @Test
    public void deleteTest(){
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        int expectedSize = 10;
        int expectedQty = 10;
        float expectedPrice = 80.00f;
        SneakerService sneakerService = new SneakerService();

        Sneaker testSneaker = sneakerService.create(expectedName, expectedBrand,expectedSport, expectedSize, expectedQty, expectedPrice);
       // Sneaker expectedSneaker=sneakerService.findSneaker(0);
       // Assert.assertEquals(expectedSneaker, testSneaker);

        //second value
        String expectedName1 = "Daksh Pandya";
        String expectedBrand1 = "Nike";
        String expectedSport1 = "Baseball";
        int expectedSize1 = 8;
        int expectedQty1 = 5;
        float expectedPrice1 = 55f;
        Sneaker testSneaker1 = sneakerService.create(expectedName1, expectedBrand1,expectedSport1, expectedSize1, expectedQty1, expectedPrice1);
        boolean sneakerExpected = sneakerService.delete(1);

        Assert.assertEquals(sneakerExpected, true);
        Assert.assertEquals(sneakerService.findSneaker(1), null);


    }


}