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
                    "**************************************************" +
                    "***           Welcome and Bienvenue            ***" +
                    "***                    to                      ***" +
                    "***          Gunjan's Inventory Manager        ***" +
                    "**************************************************");
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

    public void  displayConsoleSneaker() {
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
            System.out.println("        6.  Exit ");
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
               //     sneakerService.printOnFile();
                    break;
                case 2 :
                    Sneaker[] allSneaker = sneakerService.findAll();
                    for (int i = 0; i < allSneaker.length; i++) {
                        Sneaker s = allSneaker[i];
                        System.out.println(s);

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
                    System.out.println(foundSneaker);
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

    public void  displayConsoleWhiskey() {
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
        Console mainConsoleDisplay=new Console();
        while (flagToContinue) {
            int displayZero = 0;
            System.out.println(" \u001B[36m >> Inventory options available << \u001B[36m\u001B[0m");
            //System.out.println("\u001B[0m");
            System.out.println("        1.  Create ");
            System.out.println("        2.  Read ");
            System.out.println("        3.  Delete ");
            System.out.println("        4.  Update ");
            System.out.println("        5.  Reports ");
            System.out.println("        6.  Exit ");
            choiceInput = mainConsoleDisplay.getIntegerInput("\u001B[34m Please enter the choice of action you want to perform: \u001B[34m");

            switch(choiceInput)
            {
                case 1 :
                    whiskeyName = mainConsoleDisplay.getStringInput("Enter a Name  :");
                    whiskeyBrand = mainConsoleDisplay.getStringInput("Enter a Brand :");
                    whiskeyQty = mainConsoleDisplay.getIntegerInput("Enter a Quantity :");
                    whiskeyService.create(whiskeyName,whiskeyBrand,whiskeyQty);
                    break;
                case 2 :
                    Whiskey[] allWhiskey = whiskeyService.findAll();
                    for (int i = 0; i < allWhiskey.length; i++) {
                        Whiskey s = allWhiskey[i];
                        System.out.println(s);

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
                    System.out.println(foundWhiskey);
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

                    break;

                case 6 :
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


