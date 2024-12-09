package Final_Project_BikeShop13;

public class RoadBikes extends Bike {
    private String brakeType;

    public RoadBikes(String brand,String model, String color, String frameMaterial,String size, double price, int quantity, String brakeType ){
        super(generateId(), brand, model, color, frameMaterial,size, price,quantity);
        this.brakeType = brakeType;
    }

    public String getBrakeType() {
        return brakeType;
    }

    public void setBrakeType(String brakeType) {
        this.brakeType = brakeType;
    }

    @Override
    public void bikeDisplay(){
        super.bikeDisplay();
        System.out.println("Brake Type: " +  brakeType);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
 
}
