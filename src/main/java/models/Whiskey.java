package models;

public class Whiskey {

    private int id;
    private String name;
    private String brand;
    private int qty;



    public Whiskey(int id, String name, String brand, int qty) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.qty = qty;


    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getQty() {
        return qty;
    }
    public void setBrand(String sneakerBrand) {
        this.brand=sneakerBrand;
    }

    public void setQty(Integer qty) {
        this.qty=qty.intValue();
    }



}