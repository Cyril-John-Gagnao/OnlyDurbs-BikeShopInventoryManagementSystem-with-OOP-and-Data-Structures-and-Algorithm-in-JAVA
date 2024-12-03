package Final_Project_BikeShop13;

public class FixedGearBikes extends Bike {
    // dri butang ang ang attributes hindi sa method

    public FixedGearBikes(String id,String brand,String model, String color, String frameMaterial,String size, double price, int quantity){
        super(id, brand, model, color, frameMaterial,size, price,quantity);
    }

   
    public void bikeDisplay(String gearRatio, boolean hasBrakes ){
        System.out.println("--------------------");
        System.out.println("Category: FixedGear");
        super.bikeDisplay();
        System.out.println("Gear : " + gearRatio);
        System.out.println("Brakes: " +  hasBrakes);
        System.out.println("--------------------");
    }
}
