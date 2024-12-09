package Final_Project_BikeShop13;

import java.util.LinkedList;

public class Inventory {
    private LinkedList<Bike> bikes;
    private String inventoryName;
   
    
    public Inventory(String inventoryName) {
        this.inventoryName = inventoryName;
        this.bikes = new LinkedList<>();
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    // Add a bike to the inventory
    public void addBikeToInventory(Bike bike) {
        bikes.add(bike);
    }
    // Remove a bike from the inventory
    public void removeBikeFromInventory(Bike bike) {
        bikes.remove(bike);
    }
    // Get the list of bikes in inventory
    public LinkedList<Bike> getBikes() {
        return bikes;
    }

   // Find a bike by its ID //sell bike
   public Bike findBikeById(String bikeId) {
    for (Bike bike : bikes) {
        if (bike.getId().equalsIgnoreCase(bikeId)) { 
            return bike;
        }
    }
    return null; 
    }

    //bubble sort by bike id
    public void sortBikesById() {
        int n = bikes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (bikes.get(j).getId().compareTo(bikes.get(j + 1).getId()) > 0) {
                    // Swap bikes[j] and bikes[j + 1]
                    Bike temp = bikes.get(j);
                    bikes.set(j, bikes.get(j + 1));
                    bikes.set(j + 1, temp);
                }
            }
        }
    }

    // Bubble sort by bike price
    public void sortBikesByPrice() {
        int n = bikes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (bikes.get(j).getPrice() > bikes.get(j + 1).getPrice()) {
                    // Swap bikes[j] and bikes[j + 1]
                    Bike temp = bikes.get(j);
                    bikes.set(j, bikes.get(j + 1));
                    bikes.set(j + 1, temp);
                }
            }
        }
    }  
    
}

