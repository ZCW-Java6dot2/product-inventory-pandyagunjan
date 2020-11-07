package services;

import models.Sneaker;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import utils.CSVUtils;
import com.fasterxml.jackson.core.type.TypeReference;
public class SneakerService {
    //

    private static int nextId = 1;  // (1)
    private ArrayList<Sneaker> inventory = new ArrayList<>();  // (2)
    //  private <Sneaker> inventory = new ArrayList<Sneaker>();  // (2)

    public SneakerService() {


    }

    public Sneaker create(String name, String brand, String sport, int size, int quantity, float price) {

        // (2)
        Sneaker createdSneaker = new Sneaker(nextId++, name, brand, sport, size, quantity, price);
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
        Sneaker[] sneakerArray = new Sneaker[inventory.size()];
        int i = 0;
        while (i < sneakerArray.length) {
            sneakerArray[i] = inventory.get(i);
            i++;
        }
        return sneakerArray;
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false

        for (Sneaker s : inventory) {
            if (s.getId() == id) {
                inventory.remove(s);
                return true;
            }
        }
        return false;
    }

    public void printOnFile() throws IOException {
    String csvFile = "/Users/gunjan/Desktop/Sneakers.csv";
    FileWriter writer = new FileWriter(csvFile); //(1)
        CSVUtils.writeLine(writer,new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));  // (2)


for(
    Sneaker s :inventory)
    {
        ArrayList<String> list = new ArrayList<>(); // (3)
        list.add(String.valueOf(s.getId()));
        list.add(s.getName());
        list.add(s.getBrand());
        list.add(s.getSport());
        list.add(String.valueOf(s.getQty()));
        list.add(String.valueOf(s.getPrice()));

        CSVUtils.writeLine(writer, list);  // (4)
    }

// (5)
writer.flush();
writer.close();
}
    public void loadData(){
        // (1)
        String csvFile = "/Users/gunjan/Dev/product-inventory-pandyagunjan/Sneakers.csv";
        String line = "";
        String csvSplitBy = ",";


        // (2)
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextId = (int)Integer.parseInt(br.readLine());

            while ((line = br.readLine()) != null) {
                // split line with comma
                String[] beer = line.split(csvSplitBy);

                // (4)
                int id = Integer.parseInt(beer[0]);
                String name = beer[1];
                String brand = beer[2];
                String sport = beer[3];
                int qty = Integer.parseInt(beer[4]);
                float price = Float.parseFloat(beer[5]);

                // (5)
                inventory.add(new Sneaker(id, name, brand, sport, qty, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


public void loadDataUsingJSON() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        this.inventory = objectMapper.readValue(new File("/Users/gunjan/Dev/product-inventory-pandyagunjan/sneaker.json"), new TypeReference<ArrayList<Sneaker>>(){});
    }

    public  void saveInventorySneaker() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("/Users/gunjan/Dev/product-inventory-pandyagunjan/sneaker.json"), inventory);

    }

}