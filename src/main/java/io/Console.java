package io;
import models.*;
import services.SneakerService;
import services.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Console {

      public static void printWelcome(){
            System.out.println("" +
                    "**************************************************\n" +
                    "***           Welcome and Bienvenue            ***\n" +
                    "***                    to                      ***\n" +
                    "***          Gunjan's Inventory Manager        ***\n" +
                    "**************************************************\n");
        }

    public  String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }
    // This method checks if the entered value is 'Int' , If not requests user to key in another value.
    public  Integer getIntegerInput(String prompt) {
        Console useConsole=new Console();
        Scanner scanner = new Scanner(System.in);
        Integer userInput = 0;
        System.out.println(prompt);


        if (scanner.hasNextInt()) {
            userInput = scanner.nextInt();
        } else
        {
            userInput = useConsole.getIntegerInput ("Not a Number value, Please re-enter:");

        }

        return userInput;


    }
// This method checks if the entered value is 'Double' , If not requests user to key in another value.

    public Double getDoubleInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        Console getDoubleConsole=new Console();
        Double userInputDouble = 0D;
        System.out.println(prompt);
        //println(userInputDouble);

        if (scanner.hasNextDouble()) {
            userInputDouble = scanner.nextDouble();
        } else
        {
            userInputDouble = Double.valueOf(getDoubleConsole.getDoubleInput ("Not a Number value, Please re-enter:"));

        }

        return userInputDouble;
    }

    public void  displayConsoleSneaker() throws IOException {
        int choiceInput=0;
        int idToBeDeleted;
        int idToBeUpdated;
        int idForReports;
        int whichFieldSneaker;
        Boolean flagToContinue = true;
        int id;
        String sneakerName;
        String sneakerBrand;
        String sneakerSport;
        int sneakerSize;
        int sneakerQty;
        Double sneakerPrice;
        boolean flagForDeletion=true;
        SneakerService sneakerService= new SneakerService();
        sneakerService.loadData();
        Console mainConsoleDisplay=new Console();

        while (flagToContinue) {
            int displayZero = 0;
            System.out.println(" \u001B[36m >> Calculator options available << \u001B[36m\u001B[0m");
            //System.out.println("\u001B[0m");
            System.out.println("        1.  Create ");
            System.out.println("        2.  Read ");
            System.out.println("        3.  Delete ");
            System.out.println("        4.  Update ");
            System.out.println("        5.  Reports ");
            System.out.println("        6.  Whiskey Inventory Menu ");
            System.out.println("        7.  Exit ");
            choiceInput = mainConsoleDisplay.getIntegerInput("\u001B[34m Please enter the choice of action you want to perform: \u001B[34m");

            switch(choiceInput)
            {
                case 1 :
                    sneakerName = mainConsoleDisplay.getStringInput("Enter a Name  :");
                    sneakerBrand = mainConsoleDisplay.getStringInput("Enter a Brand :");
                    sneakerSport = mainConsoleDisplay.getStringInput("Enter a Sport :");
                    sneakerSize = mainConsoleDisplay.getIntegerInput("Enter a Size :");
                    sneakerQty = mainConsoleDisplay.getIntegerInput("Enter a Quantity :");
                    sneakerPrice = mainConsoleDisplay.getDoubleInput("Enter a Price :");
                    sneakerService.create(sneakerName,sneakerBrand,sneakerSport,sneakerSize,sneakerQty,sneakerPrice.floatValue());
                  // sneakerService.printOnFile();
                    sneakerService.saveInventorySneaker();

                    break;
                case 2 :

                    Sneaker[] allSneaker = sneakerService.findAll();
                    for (int i = 0; i < allSneaker.length; i++) {
                        Sneaker s = allSneaker[i];
                        System.out.println("ID : " + s.getId());
                        System.out.println("Name Is: " + s.getName());
                        System.out.println("Brand Is: " + s.getBrand());
                        System.out.println("Sport Is: " + s.getSport());
                        System.out.println("Qty Is: " + s.getQty());
                        System.out.println("Size Is: " + s.getQty());
                        System.out.println("Price Is: " + s.getPrice()+"\n");


                    }


                    break;
                case 3 :
                    idToBeDeleted = mainConsoleDisplay.getIntegerInput("Enter a Id of Sneaker to be deleted :");
                    flagForDeletion = sneakerService.delete(idToBeDeleted);
                   if(flagForDeletion==true)
                       System.out.print("Item has been deleted");
                   else
                       System.out.print("Item has NOT been deleted");
                    break;
                case 4 :
                    idToBeUpdated = mainConsoleDisplay.getIntegerInput("Enter a Id of Sneaker to be updated :");
                    Sneaker foundSneaker = sneakerService.findSneaker(idToBeUpdated);
                     whichFieldSneaker=mainConsoleDisplay.getIntegerInput("Press -   1.Update Brand \n         2.Update Price:");
                    if(whichFieldSneaker==1)
                    {
                        sneakerBrand = mainConsoleDisplay.getStringInput("Enter a Brand :");
                        foundSneaker.setBrand(sneakerBrand);

                    }
                    else
                    if(whichFieldSneaker==2)
                    {
                        sneakerPrice = mainConsoleDisplay.getDoubleInput("Enter a Price :");
                        foundSneaker.setPrice(sneakerPrice);

                    }
                    System.out.println("ID : " + foundSneaker.getId());
                    System.out.println("Name Is: " + foundSneaker.getName());
                    System.out.println("Brand Is: " + foundSneaker.getBrand());
                    System.out.println("Sport Is: " + foundSneaker.getSport());
                    System.out.println("Qty Is: " + foundSneaker.getQty());
                    System.out.println("Size Is: " + foundSneaker.getQty());
                    System.out.println("Price Is: " + foundSneaker.getPrice()+"\n");
                    break;
                case 5:
                    idForReports = mainConsoleDisplay.getIntegerInput("Enter a Id of Sneaker to see the inventory :");
                    //Sneaker foundSneaker = sneakerService.findSneaker(idToBeUpdated);
                     whichFieldSneaker=mainConsoleDisplay.getIntegerInput("Press -   1.Brand \n        2.Price:");
                    if(whichFieldSneaker==1)
                    {
                      System.out.println("Brand is :"+sneakerService.findSneaker(idForReports).getBrand());
                    }
                    else
                    if(whichFieldSneaker==2)
                    {
                        System.out.println("Price is :"+ sneakerService.findSneaker(idForReports).getPrice());
                    }

                    break;
                case 6 :
                    displayConsoleWhiskey();
                    break;
                case 7 :
                    flagToContinue=false;
                    System.out.print("Quiting the inventory system, Program Ending");
                    System.exit(0);
                    break;


                default :
                    flagToContinue=false;
                    System.out.print("Quiting the inventory system, Program Ending");
                    System.exit(0);
                    break;
            }
        }



    }

    public void  displayConsoleWhiskey() throws IOException {
        int choiceInput=0;
        int idToBeDeleted;
        int idToBeUpdated;
        int idForReports;
        int whichFieldWhiskey;
        Boolean flagToContinue = true;
        int id;
        String whiskeyName;
        String whiskeyBrand;
        String whiskeySport;
        int whiskeySize;
        int whiskeyQty;
        int whiskeyPrice;
        boolean flagForDeletion=true;
        WhiskeyService whiskeyService= new WhiskeyService();
        whiskeyService.loadData();
        Console mainConsoleDisplay=new Console();
        while (flagToContinue) {
            int displayZero = 0;
            System.out.println(" \u001B[36m >> Inventory options available << \u001B[36m\u001B[0m");
            //System.out.println("\u001B[0m");
            System.out.println("        1.  Create ");
            System.out.println("        2.  Read ");
            System.out.println("        3.  Delete ");
            System.out.println("        4.  Update ");
            System.out.println("        6.  Sneaker Inventory Menu ");
            System.out.println("        7.  Exit ");
            choiceInput = mainConsoleDisplay.getIntegerInput("\u001B[34m Please enter the choice of action you want to perform: \u001B[34m");

            switch(choiceInput)
            {
                case 1 :
                    whiskeyName = mainConsoleDisplay.getStringInput("Enter a Name  :");
                    whiskeyBrand = mainConsoleDisplay.getStringInput("Enter a Brand :");
                    whiskeyQty = mainConsoleDisplay.getIntegerInput("Enter a Quantity :");
                    whiskeyService.create(whiskeyName,whiskeyBrand,whiskeyQty);
                    //whiskeyService.printOnFile();
                    whiskeyService.saveInventoryWhiskey();
                    break;
                case 2 :
                    Whiskey[] allWhiskey = whiskeyService.findAll();
                    for (int i = 0; i < allWhiskey.length; i++) {
                        Whiskey s = allWhiskey[i];
                        System.out.println("ID : " + s.getId());
                        System.out.println("Name Is: " + s.getName());
                        System.out.println("Brand Is: " + s.getBrand());
                        System.out.println("Qty Is: " + s.getQty()+"\n");
                    }
                    break;
                case 3 :
                    idToBeDeleted = mainConsoleDisplay.getIntegerInput("Enter a Id of Whiskey to be deleted :");
                    flagForDeletion = whiskeyService.delete(idToBeDeleted);
                    if(flagForDeletion==true)
                        System.out.print("Item has been deleted");
                    else
                        System.out.print("Item has NOT been deleted");
                    break;
                case 4 :
                    idToBeUpdated = mainConsoleDisplay.getIntegerInput("Enter a Id of Whiskey to be updated :");
                    Whiskey foundWhiskey = whiskeyService.findWhiskey(idToBeUpdated);
                    whichFieldWhiskey=mainConsoleDisplay.getIntegerInput("Press -   1.Update Brand \n         2.Update Quantity:");
                    if(whichFieldWhiskey==1)
                    {
                        whiskeyBrand = mainConsoleDisplay.getStringInput("Enter a Brand :");
                        foundWhiskey.setBrand(whiskeyBrand);

                    }
                    else
                    if(whichFieldWhiskey==2)
                    {
                        whiskeyPrice = mainConsoleDisplay.getIntegerInput("Enter a Quanity :");
                        foundWhiskey.setQty(whiskeyPrice);

                    }
                    System.out.println("ID : " + foundWhiskey.getId());
                    System.out.println("Name Is: " + foundWhiskey.getName());
                    System.out.println("Updated Brand Is: " + foundWhiskey.getBrand());
                    System.out.println("Updated Qty Is: " + foundWhiskey.getQty()+"\n");
                    break;
                case 5:

                    idForReports = mainConsoleDisplay.getIntegerInput("Enter a Id of Whiskey to see the inventory :");
                    //Whiskey foundWhiskey = WhiskeyService.findWhiskey(idToBeUpdated);
                    whichFieldWhiskey=mainConsoleDisplay.getIntegerInput("Press -   1.Brand \n        2.Quantity:");
                    if(whichFieldWhiskey==1)
                    {
                        System.out.println("Brand is :"+whiskeyService.findWhiskey(idForReports).getBrand());
                    }
                    else
                    if(whichFieldWhiskey==2)
                    {
                        System.out.println("Qty is :"+ whiskeyService.findWhiskey(idForReports).getQty());
                    }

//                    whiskeyService.loadData();
                    break;
                case 6 :
                    displayConsoleSneaker();
                    break;
                case 7 :
                    flagToContinue=false;
                    System.out.print("Quiting the inventory system, Program Ending");
                    System.exit(0);
                    break;

                default :
                    flagToContinue=false;
                    System.out.print("Quiting the inventory system, Program Ending");
                    System.exit(0);
                    break;
            }
        }



    }


    }


