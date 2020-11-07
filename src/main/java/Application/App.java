package Application;
import services.*;
import io.*;
import models.*;

import java.io.IOException;

public class App {

        private SneakerService sneakerService = new SneakerService(); // (1)

        public static void main(String... args) throws IOException {
            App application = new App(); // (2)
            application.init();  // (3)
        }

        public void init() throws IOException {
            // (4)
            Console consoleObj=new Console();
            consoleObj.printWelcome();
            int inventoryChoise;

            while(true) {
                System.out.println(" \u001B[36m >> Inventory options available << \u001B[36m\u001B[0m");
                //System.out.println("\u001B[0m");
                System.out.println("        1.      Sneaker ");
                System.out.println("        2.      Whiskey ");
                System.out.println("        Other.  Exit ");
                inventoryChoise = consoleObj.getIntegerInput("\u001B[34m Please select \u001B[34m").intValue();

                  if (inventoryChoise == 1) {
                    consoleObj.displayConsoleSneaker();
                } else if (inventoryChoise == 2) {
                    consoleObj.displayConsoleWhiskey();
                }
                  else
                  {
                      System.out.print("Quiting the inventory system, Program Ending");
                      System.exit(0);
                  }

            }
        }
    }

