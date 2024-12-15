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

    // Bubble sort by bike ID
    public void sortBikesById() {
        int n = bikes.size();
        for (int firstIdIndex = 0; firstIdIndex < n - 1; firstIdIndex++) {
            for (int nextIdIndex = 0; nextIdIndex < n - firstIdIndex - 1; nextIdIndex++) {
                int id1 = Integer.parseInt(bikes.get(nextIdIndex).getId().substring(2));
                int id2 = Integer.parseInt(bikes.get(nextIdIndex + 1).getId().substring(2)); 
                
                if (id1 > id2) {
                    // Swap bikes[nextIdIndex] and bikes[nextIdInedx + 1]
                    Bike bikeIdSwap = bikes.get(nextIdIndex); 
                    bikes.set(nextIdIndex, bikes.get(nextIdIndex + 1));
                    bikes.set(nextIdIndex + 1, bikeIdSwap);
                }
            }
        }
    }

    // Bubble sort by bike price
    public void sortBikesByPrice() {
        int n = bikes.size();
        for (int firstPriceIndex = 0;  firstPriceIndex < n - 1;  firstPriceIndex++) {
            for (int nextPriceIndex = 0; nextPriceIndex < n -  firstPriceIndex - 1; nextPriceIndex++) {
                if (bikes.get(nextPriceIndex).getPrice() > bikes.get(nextPriceIndex + 1).getPrice()) {
                    // Swap bikes[nextPriceIndex] and bikes[nextPriceIndex + 1]
                    Bike bikePriceSwap = bikes.get(nextPriceIndex);
                    bikes.set(nextPriceIndex, bikes.get(nextPriceIndex + 1));
                    bikes.set(nextPriceIndex + 1, bikePriceSwap);
                }
            }
        }
    }
    
    // Method to display all bikes in inventory with optional category filtering
    public void displayAllBikes(String filterCategory) {
        int bikeTotalQuantity = 0;

        System.out.println("----------------------------");
        if (filterCategory == null) {
            System.out.println("All Bikes in Inventory:");
        } else {
            System.out.println("Bikes in Category: " + filterCategory);
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-5s | %-15s | %-15s | %-10s | %-15s | %-10s | %-10s | %-10s | %-15s | %-30s\n",
                "ID", "Brand", "Model", "Color", "Frame Material", "Size", "Price", "Quantity", "Category", "Specific Attributes");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");


        if (bikes.isEmpty()) {
            System.out.println("No bikes available in inventory.");
            return;
        }

        boolean bikesFound = false; // To check if there are bikes in the specified category
        for (Bike bike : bikes) {
            String specificAttributes = "";
            String category = "";

            if (bike instanceof FixedGearBikes) {
                FixedGearBikes fixedGearBike = (FixedGearBikes) bike;
                specificAttributes = String.format("Gear Type: %s, has Brakes?: %s",
                        fixedGearBike.getGearType(),
                        fixedGearBike.hasBrakes());
                category = "Fixed Gear";
            } else if (bike instanceof MountainBikes) {
                MountainBikes mountainBike = (MountainBikes) bike;
                specificAttributes = String.format("Suspension: %s", mountainBike.getSuspension());
                category = "Mountain Bike";
            } else if (bike instanceof RoadBikes) {
                RoadBikes roadBike = (RoadBikes) bike;
                specificAttributes = String.format("Brake Type: %s", roadBike.getBrakeType());
                category = "Road Bike";
            } else {
                category = "Unknown";
            }

            // Check if the bike matches the filterCategory (or display all if filterCategory is null)
            if (filterCategory == null || category.equalsIgnoreCase(filterCategory)) {
                System.out.printf("%-5s | %-15s | %-15s | %-10s | %-15s | %-10s | %-10.2f | %-10d | %-15s | %-30s\n",
                        bike.getId(),
                        bike.getBrand(),
                        bike.getModel(),
                        bike.getColor(),
                        bike.getFrameMaterial(),
                        bike.getSize(),
                        bike.getPrice(),
                        bike.getQuantity(),
                        category,
                        specificAttributes);

                bikeTotalQuantity += bike.getQuantity();
                bikesFound = true;
            }
        }

        if (!bikesFound) {
            System.out.println("No bikes found in the specified category.");
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Total Bikes Displayed (by quantity): " + bikeTotalQuantity);
    }
    

    public void displayBikesChosenByBuyer(LinkedList<Bike> bikesToSell, LinkedList<Integer> quantitiesToSell) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Bikes Chosen by Buyer:");
        System.out.printf("%-5s | %-15s | %-15s | %-10s | %-15s | %-10s | %-10s | %-10s | %-15s | %-30s\n",
                "ID", "Brand", "Model", "Color", "Frame Material", "Size", "Price", "Quantity Sold", "Category", "Specific Attributes");
    
        for (int i = 0; i < bikesToSell.size(); i++) {
            Bike bike = bikesToSell.get(i);
            int quantity = quantitiesToSell.get(i);
    
            String category;
            if (bike instanceof FixedGearBikes) {
                category = "Fixed Gear";
            } else if (bike instanceof MountainBikes) {
                category = "Mountain Bike";
            } else if (bike instanceof RoadBikes) {
                category = "Road Bike";
            } else {
                category = "Unknown";
            }
    
            String specificAttributes = "";
    
            if (bike instanceof FixedGearBikes) {
                FixedGearBikes fixedGearBike = (FixedGearBikes) bike;
                specificAttributes = String.format("Gear Type: %s, Brakes: %s", fixedGearBike.getGearType(), fixedGearBike.hasBrakes());
            } else if (bike instanceof MountainBikes) {
                MountainBikes mountainBike = (MountainBikes) bike;
                specificAttributes = String.format("Suspension: %s", mountainBike.getSuspension());
            } else if (bike instanceof RoadBikes) {
                RoadBikes roadBike = (RoadBikes) bike;
                specificAttributes = String.format("Brake Type: %s", roadBike.getBrakeType());
            }
    
            System.out.printf("%-5s | %-15s | %-15s | %-10s | %-15s | %-10s | $%-9.2f | %-11d   | %-15s | %-30s\n",
                    bike.getId(),
                    bike.getBrand(),
                    bike.getModel(),
                    bike.getColor(),
                    bike.getFrameMaterial(),
                    bike.getSize(),
                    bike.getPrice(),
                    quantity,
                    category,
                    specificAttributes);
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
    }

    public int displayBikesTotalSummary(String category) {
        int totalBikes = 0;
        int totalFixedGearBikes = 0;
        int totalMountainBikes = 0;
        int totalRoadBikes = 0;
    
        for (Bike bike : bikes) {
            totalBikes += bike.getQuantity();
            if (bike instanceof FixedGearBikes) {
                totalFixedGearBikes += bike.getQuantity();
            } else if (bike instanceof MountainBikes) {
                totalMountainBikes += bike.getQuantity();
            } else if (bike instanceof RoadBikes) {
                totalRoadBikes += bike.getQuantity();
            }
        }
    
        if (category.equalsIgnoreCase("all")) {
            System.out.println("------------------------------------");
            System.out.println("Inventory Name: " + inventoryName);
            System.out.println("Total number of bikes in inventory: " + totalBikes);
        }
    
        int result = 0; // Variable to hold the result
        switch (category.toLowerCase()) {
            case "fixed gear":
                result = totalFixedGearBikes; 
                break;
            case "mountain":
                result = totalMountainBikes; 
                break;
            case "road":
                result = totalRoadBikes; 
                break;
            case "all":
                break;
            default:
                System.out.println("Invalid category. Please specify 'all', 'fixed gear', 'mountain', or 'road'.");
        }
        
        return result;
    }

    public void updateQuantities(LinkedList<Bike> bikesToSell, LinkedList<Integer> quantitiesToSell) {
        for (int i = 0; i < bikesToSell.size(); i++) {
            Bike bike = bikesToSell.get(i);
            int quantity = quantitiesToSell.get(i);
            bike.setQuantity(bike.getQuantity() + quantity); 
        }
    }
}


