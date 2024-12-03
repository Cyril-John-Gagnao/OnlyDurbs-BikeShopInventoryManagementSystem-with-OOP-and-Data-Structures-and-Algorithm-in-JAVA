package Final_Project_BikeShop13;

public class MountainBikes extends Bike {
    
    public MountainBikes(String id,String brand,String model, String color, String frameMaterial,String size, double price, int quantity){
        super(id, brand, model, color, frameMaterial,size, price,quantity);
    }
    
    public void bikeDisplay(String suspension, String tyre){
        System.out.println("--------------------");
        System.out.println("Category: Mountain Bike");
        System.out.println("Suspension: " + suspension);
        System.out.println("Tyre: " +  tyre);
        System.out.println("--------------------");
    }

    

    

    
}
