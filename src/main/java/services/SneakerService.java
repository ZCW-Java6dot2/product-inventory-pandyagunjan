package services;

import models.Sneaker;
import java.util.ArrayList;

public class SneakerService {
    //

    private static int nextId = 1;  // (1)
    private ArrayList<Sneaker> inventory = new ArrayList<>();  // (2)
  //  private <Sneaker> inventory = new ArrayList<Sneaker>();  // (2)

    public SneakerService() {

    }

    public Sneaker create(String name, String brand, String sport, int size ,int quantity, float price) {

        // (2)
        Sneaker createdSneaker = new Sneaker(nextId++, name, brand, sport,size, quantity, price);
        //Sneaker createSneaker = new Sneaker()
        // (3)
        inventory.add(createdSneaker);

        // (4)
        return createdSneaker;
    }

    //read
    public Sneaker findSneaker(int id) {
        // should take an int and return an object with that id, if exists
            return inventory.get(id);
    }

    //read all
    public Sneaker[] findAll() {
        // should return a basic array copy of the ArrayList
      Sneaker[] sneakerArray=new Sneaker[inventory.size()];
      int i=0;
      while(i< sneakerArray.length)
      {
          sneakerArray[i]= inventory.get(i);
          i++;
      }
 return sneakerArray;
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false

        for(Sneaker s : inventory)
        {
            if(s.getId()==id)
            {
                inventory.remove(s);
                return true;
            }
        }
        return false;
    }


}