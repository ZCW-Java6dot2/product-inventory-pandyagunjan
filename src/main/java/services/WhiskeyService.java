
package services;

        import com.fasterxml.jackson.core.type.TypeReference;
        import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
        import com.fasterxml.jackson.databind.ObjectMapper;
        import com.fasterxml.jackson.databind.ObjectWriter;
        import models.Sneaker;
        import models.Whiskey;
        import utils.CSVUtils;

        import java.io.*;
        import java.util.ArrayList;
        import java.util.Arrays;

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

    public void printOnFile() throws IOException {
        String csvFile = "/Users/gunjan/Desktop/Whiskey.csv";
        FileWriter writer = new FileWriter(csvFile); //(1)
        CSVUtils.writeLine(writer,new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));  // (2)


        for(
                Whiskey s :inventory)
        {
            ArrayList<String> list = new ArrayList<>(); // (3)
            list.add(String.valueOf(s.getId()));
            list.add(s.getName());
            list.add(s.getBrand());
            list.add(String.valueOf(s.getQty()));
            CSVUtils.writeLine(writer, list);  // (4)
        }

// (5)
        writer.flush();
        writer.close();
    }
    public void loadData(){
        // (1)
        String csvFile = "/Users/gunjan/Dev/product-inventory-pandyagunjan/Whiskey.csv";
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
                int qty = Integer.parseInt(beer[3]);


                // (5)
                inventory.add(new Whiskey(id, name, brand, qty));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDataUsingJSON() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        this.inventory = objectMapper.readValue(new File("/Users/gunjan/Dev/product-inventory-pandyagunjan/Whiskey.json"), new TypeReference<ArrayList<Whiskey>>(){});
    }

    public  void saveInventorySneaker() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File("/Users/gunjan/Dev/product-inventory-pandyagunjan/Whiskey.json"), inventory);

    }


}