package Application;
import services.*;
import io.*;
import models.*;

public class App {

        private SneakerService sneakerService = new SneakerService(); // (1)

        public static void main(String... args){
            App application = new App(); // (2)
            application.init();  // (3)
        }

        public void init(){
            // (4)
            Console consoleObj=new Console();
            consoleObj.printWelcome();
            consoleObj.displayConsole();

        }
    }

