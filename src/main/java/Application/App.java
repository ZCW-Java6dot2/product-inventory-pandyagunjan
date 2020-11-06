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
            sneakerService.create("Gunjan","Nike","Cricket",11,2,2.5f);
            Sneaker findSneakerResult = sneakerService.findSneaker(0);
            Console.printWelcome();
        }
    }

