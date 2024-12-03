package Final_Project_BikeShop13;

public abstract class Bike {
    private String id;
    private String brand;
    private String model;
    private String color;
    private String frameMaterial;
    private String size;
    private double price;
    private int quantity;
   
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
        System.out.println("--------------------------------");
        System.out.println("----Bike Details----");
        System.out.println("Bike Id: " + this.id);
		System.out.println("Bike Brand: " + this.brand);
        System.out.println("Bike Model: " + this.model);
		System.out.println("Bike color: " + this.color);
        System.out.println("Bike Material: " + this.frameMaterial);
        System.out.println("Bike size: " + this.size);
        System.out.println("Bike price: " + this.price);
        System.out.println("Bike quantity: " + this.quantity);
        	
	}

   
}