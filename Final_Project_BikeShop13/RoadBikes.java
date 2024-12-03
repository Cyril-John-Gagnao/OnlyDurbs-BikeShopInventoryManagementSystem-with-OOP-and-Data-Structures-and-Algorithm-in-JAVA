package Final_Project_BikeShop13;

public class RoadBikes extends Bike {
    
    public RoadBikes(String id,String brand,String model, String color, String frameMaterial,String size, double price, int quantity){
        super(id, brand, model, color, frameMaterial,size, price,quantity);
    }

    public void bikeDisplay(String handleBar, String frameGeometry ){
        System.out.println("--------------------");
        System.out.println("Category: Road Bike");
        super.bikeDisplay();
        System.out.println("Fork: " + handleBar);
        System.out.println("Frame Geometry: " +  frameGeometry);
        System.out.println("--------------------");
    }
 
}
