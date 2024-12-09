package Final_Project_BikeShop13;

public class MountainBikes extends Bike {
    private String suspension;
    
    public MountainBikes(String brand,String model, String color, String frameMaterial,String size, double price, int quantity, String suspension){
        super(generateId(), brand, model, color, frameMaterial,size, price,quantity);
        this.suspension = suspension;  
    }

    public String getSuspension() {
        return suspension;
    }

    public void setSuspension(String suspension) {
        this.suspension = suspension;
    }

    @Override
    public void bikeDisplay(){
        super.bikeDisplay();
        System.out.println("Suspension: " + suspension);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
  
}