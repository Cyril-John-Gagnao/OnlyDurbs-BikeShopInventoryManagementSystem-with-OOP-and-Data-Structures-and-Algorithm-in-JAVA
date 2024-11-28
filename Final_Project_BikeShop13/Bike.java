package Final_Project_BikeShop13;

public abstract class Bike {
    private String id;
    private String brand;
    private String model;
    private String color;
    private String frameMaterial;
    private double price;
   

    public Bike(String id,String brand,String model, String color, String frameMaterial, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.frameMaterial = frameMaterial;
        this.price = price;
       
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
   
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public void bikeDisplay() {
        System.out.println("--------------------------------");
        System.out.println("Bike Id: " + this.id);
		System.out.println("Bike Brand: " + this.brand);
        System.out.println("Bike Model: " + this.model);
		System.out.println("Bike color: " + this.color);
        System.out.println("Bike Materials: " + this.frameMaterial);
        System.out.println("Bike price: " + this.price);
        System.out.println("--------------------------------");
        	
	}

   
}
