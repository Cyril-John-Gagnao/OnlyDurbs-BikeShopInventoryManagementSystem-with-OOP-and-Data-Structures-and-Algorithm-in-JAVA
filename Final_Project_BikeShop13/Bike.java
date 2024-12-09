package Final_Project_BikeShop13;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Bike {
    private String id;
    private String brand;
    private String model;
    private String color;
    private String frameMaterial;
    private String size;
    private double price;
    private int quantity;
    private static int counter = 1; 
    private static Queue<Integer> recycledIds = new LinkedList<>(); 
   
    public Bike(String id,String brand,String model, String color, String frameMaterial,String size, double price, int quantity) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.frameMaterial = frameMaterial;
        this.size = size;
        this.price = price;
        this.quantity = quantity;   
       
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getFrameMaterial() {
        return frameMaterial;
    }
    public void setFrameMaterial(String frameMaterial) {
        this.frameMaterial = frameMaterial;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
   
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void bikeDisplay() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Bike Id: " + this.id + " | Bike Brand: " + this.brand + " | Bike Model: " + this.model + " | Bike color: " + this.color + " | Bike Material: " + this.frameMaterial + " | Bike size: " + this.size + " | Bike price: " + this.price + " | Bike quantity: " + this.quantity);
	}

    // Centralized ID generation method
    protected static String generateId() {
        if (!recycledIds.isEmpty()) {
            return "BK" + recycledIds.poll();
        }
        return "BK" + counter++;
    }

    // Centralized method to recycle IDs
    public static void returnId(String id) {
        int idNumber = Integer.parseInt(id.substring(2)); 
        recycledIds.add(idNumber);
    }
  
}