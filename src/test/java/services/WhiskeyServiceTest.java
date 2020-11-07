package services;

import models.Whiskey;

import org.junit.Assert;
import org.junit.Test;

public class WhiskeyServiceTest {

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
        WhiskeyService WhiskeyService = new WhiskeyService();
        Whiskey testWhiskey = WhiskeyService.create(expectedName, expectedBrand,expectedQty);

        // (3)
        int actualId = testWhiskey.getId();
        String actualName = testWhiskey.getName();
        String actualBrand = testWhiskey.getBrand();
        int actualQty = testWhiskey.getQty();


        // (4)
        Assert.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedBrand, actualBrand);
        Assert.assertEquals(expectedQty, actualQty);


    }
    @Test
    public void findWhiskeyTest(){


        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        int expectedSize = 10;
        int expectedQty = 10;
        float expectedPrice = 80.00f;


        WhiskeyService WhiskeyService = new WhiskeyService();
        Whiskey testWhiskey = WhiskeyService.create(expectedName, expectedBrand,expectedQty);


        Whiskey expectedWhiskey=WhiskeyService.findWhiskey(0);
        Assert.assertEquals(expectedWhiskey, testWhiskey);

    }

    @Test
    public void findAllTest(){


        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        int expectedSize = 10;
        int expectedQty = 10;
        float expectedPrice = 80.00f;
        WhiskeyService WhiskeyService = new WhiskeyService();
        Whiskey testWhiskey = WhiskeyService.create(expectedName, expectedBrand, expectedQty);
        Whiskey expectedWhiskey=WhiskeyService.findWhiskey(0);
        Assert.assertEquals(expectedWhiskey, testWhiskey);


        //second value
        String expectedName1 = "Daksh Pandya";
        String expectedBrand1 = "Nike";
        String expectedSport1 = "Baseball";
        int expectedSize1 = 8;
        int expectedQty1 = 5;
        float expectedPrice1 = 55f;
        Whiskey testWhiskey1 = WhiskeyService.create(expectedName1, expectedBrand1, expectedQty1);

        Whiskey expectedWhiskey1=WhiskeyService.findWhiskey(1);

        Whiskey[] WhiskeyArrayActual = new Whiskey[2];
        WhiskeyArrayActual[0]= testWhiskey;
        WhiskeyArrayActual[1]= testWhiskey1;

        Whiskey [] WhiskeyExpected = WhiskeyService.findAll();

        Assert.assertEquals(WhiskeyArrayActual[0], WhiskeyExpected[0]);
        Assert.assertEquals(WhiskeyArrayActual[1], WhiskeyExpected[1]);

    }
    @Test
    public void deleteTest(){
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        int expectedSize = 10;
        int expectedQty = 10;
        float expectedPrice = 80.00f;
        WhiskeyService WhiskeyService = new WhiskeyService();

        Whiskey testWhiskey = WhiskeyService.create(expectedName, expectedBrand,expectedQty);
        // Whiskey expectedWhiskey=WhiskeyService.findWhiskey(0);
        // Assert.assertEquals(expectedWhiskey, testWhiskey);

        //second value
        String expectedName1 = "Daksh Pandya";
        String expectedBrand1 = "Nike";
        String expectedSport1 = "Baseball";
        int expectedSize1 = 8;
        int expectedQty1 = 5;
        float expectedPrice1 = 55f;
        Whiskey testWhiskey1 = WhiskeyService.create(expectedName1, expectedBrand1, expectedQty1);

        boolean WhiskeyExpected = WhiskeyService.delete(3);

        Assert.assertEquals(WhiskeyExpected, true);
        Assert.assertEquals(WhiskeyService.findWhiskey(3), null);


    }


    }



