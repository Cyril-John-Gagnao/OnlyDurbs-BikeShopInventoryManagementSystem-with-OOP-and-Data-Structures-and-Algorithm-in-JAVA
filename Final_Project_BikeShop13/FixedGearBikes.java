package Final_Project_BikeShop13;

public class FixedGearBikes extends Bike {
    private String gearType; 
    private boolean hasBrakes; 

    public FixedGearBikes( String brand, String model, String color, String frameMaterial, String size,double price, int quantity, String gearType, boolean hasBrakes) {
        super(generateId(), brand, model, color, frameMaterial, size, price, quantity);
        this.gearType = gearType;
        this.hasBrakes = hasBrakes;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public boolean hasBrakes() {
        return hasBrakes;
    }
    
    public void setHasBrakes(boolean hasBrakes) {
        this.hasBrakes = hasBrakes;
    }

    @Override
    public void bikeDisplay() {
        super.bikeDisplay(); 
        System.out.println(" | Gear type: " + gearType + "  | has Brakes?: " + hasBrakes );
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}

