package models;
public class Sneaker {
    private int id;
    private String name;
    private String brand;
    private String sport;
    private int size;
    private int qty;
    private float price;


    public Sneaker(int id, String name, String brand, String sport,int size,int qty, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.sport = sport;
        this.qty = qty;
        this.price = price;
        this.size=size;

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

    public String getSport() {
        return sport;
    }

    public int getSize() {
        return size;
    }

    public float getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }
}