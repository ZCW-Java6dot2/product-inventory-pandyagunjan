
package services;

        import models.Whiskey;
        import java.util.ArrayList;

public class WhiskeyService {
    //

    private static int nextId = 1;  // (1)
    private ArrayList<Whiskey> inventory = new ArrayList<>();  // (2)
    //  private <Whiskey> inventory = new ArrayList<Whiskey>();  // (2)

    public WhiskeyService() {

    }

    public Whiskey create(String name, String brand, int quantity) {

        // (2)
        Whiskey createdWhiskey = new Whiskey(nextId++, name, brand,  quantity);
        //Whiskey createWhiskey = new Whiskey()
        // (3)
        inventory.add(createdWhiskey);

        // (4)
        return createdWhiskey;
    }

    //read
    public Whiskey findWhiskey(int id) {
        // should take an int and return an object with that id, if exists
        return inventory.get(id);
    }

    //read all
    public Whiskey[] findAll() {
        // should return a basic array copy of the ArrayList
        Whiskey[] WhiskeyArray=new Whiskey[inventory.size()];
        int i=0;
        while(i< WhiskeyArray.length)
        {
            WhiskeyArray[i]= inventory.get(i);
            i++;
        }
        return WhiskeyArray;
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false

        for(Whiskey s : inventory)
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