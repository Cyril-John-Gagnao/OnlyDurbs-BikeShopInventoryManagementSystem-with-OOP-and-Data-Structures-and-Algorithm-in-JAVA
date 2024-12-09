package Final_Project_BikeShop13;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Inventory inventory = new Inventory("Only Durbs Bike Shop Inventory");
        BikeShop bikeShop = new BikeShop("Only Durbs Bike Shop", "Iloilo", inventory, null); 
        BikeShopOwner owner = new BikeShopOwner("Cyril", "Gagnao", "Iloilo", "12345678910", bikeShop);
        bikeShop.setOwner(owner);

        Bike defaultMountainBike = new MountainBikes("Trek", "Version 1", " red", "alloy", "medium", 10000, 10, "Full Suspension");
        Bike defaultRoadBike = new RoadBikes("MountainPeak", "Version 1", "blue", "carbon", "large", 15000, 20, "Disc Brake");
        Bike defaultFixedGear = new FixedGearBikes("Celt", "Version", "black", "steel", "small", 7000, 15, "Fixed", false);
       
        owner.getBikeShop().getInventory().addBikeToInventory(defaultFixedGear);
        owner.getBikeShop().getInventory().addBikeToInventory(defaultMountainBike);
        owner.getBikeShop().getInventory().addBikeToInventory(defaultRoadBike);

        inventory.sortBikesById();
        
        // Main menu loop
        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to Only Durbs Bike Shop Inventory Management");
            System.out.println("1. Add Bike to Inventory");
            System.out.println("2. Remove Bike from Inventory");
            System.out.println("3. Display Bikes in Inventory");
            System.out.println("4. == Sell a Bike == ");
            System.out.println("5. Update Bike Details");
            System.out.println("6. Exit");
            System.out.print("Please select an option: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine()); 
           
                switch (choice) {
                    case 1:
                        boolean addingBikesMenuActive = true; 
                        while (addingBikesMenuActive) {
                            try {
                                System.out.println("------------------");
                                System.out.println("Select Bike Type to add:");
                                System.out.println("1. Fixed Gear");
                                System.out.println("2. Mountain Bike");
                                System.out.println("3. Road Bike");
                                System.out.println("4. Exit to Main Menu");
                                System.out.print("Enter choice: ");
                                int bikeTypeChoice = Integer.parseInt(scanner.nextLine());

                                if (bikeTypeChoice < 1 || bikeTypeChoice > 4) {
                                    System.out.println("Invalid choice. Please select a number between 1 and 4.");
                                    continue; 
                                }

                                if (bikeTypeChoice == 4) {
                                    addingBikesMenuActive = false;
                                    System.out.println("----------------------");
                                    System.out.println("Returning to Main Menu");
                                    break;
                                }

                                boolean addingMoreBikes = true; 
                                while (addingMoreBikes) {

                                    String brand = "";
                                    String model = "";
                                    String color = "";
                                    String frameMaterial = "";
                                    String size = "";
                                    double price = 0.0;
                                    int quantity = 0;

                                    boolean validBrandInput = false ;
                                    do {
                                        try {
                                            System.out.print("Enter Bike Brand: ");
                                            brand = scanner.nextLine().trim();
                                            if (brand.isEmpty()) {
                                                throw new IllegalArgumentException("Brand cannot be empty.");
                                            }
                                            validBrandInput = true; 
                                        } catch (IllegalArgumentException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    } while (!validBrandInput);

                                    boolean validModelInput = false ;
                                    do {
                                        try {
                                            System.out.print("Enter Bike Model: ");
                                            model = scanner.nextLine().trim();
                                            if (model.isEmpty()) {
                                                throw new IllegalArgumentException("Model cannot be empty.");
                                            }
                                            validModelInput = true; 
                                        } catch (IllegalArgumentException e) {
                                            System.out.println(e.getMessage()); 
                                        }
                                    } while (!validModelInput);
                                    
                                    boolean validColorInput = false;
                                    do {
                                        try {
                                            System.out.print("Enter Bike Color: ");
                                            color = scanner.nextLine().trim();
                                            if (color.isEmpty()) {
                                                throw new IllegalArgumentException("Color cannot be empty.");
                                            }
                                            validColorInput = true;
                                        } catch (IllegalArgumentException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    } while (!validColorInput);

                                    boolean validFrameMaterialInput = false ;
                                    do {
                                        try {
                                            System.out.print("Enter Bike Frame Material (Steel / Alloy / Carbon): ");
                                            frameMaterial = scanner.nextLine().trim().toLowerCase();
                                            if (frameMaterial.isEmpty()) {
                                                throw new IllegalArgumentException("Frame Material cannot be empty.");
                                            } else if (!frameMaterial.equals("steel") && !frameMaterial.equals("alloy") && !frameMaterial.equals("carbon")) {
                                                throw new IllegalArgumentException("Invalid Frame Material . Please enter 'steel', 'alloy', or 'carbon'.");
                                            }
                                            validFrameMaterialInput = true; 
                                        } catch (IllegalArgumentException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    } while (!validFrameMaterialInput);

                                    boolean validSizeInput = false;
                                    do {
                                        try {
                                            System.out.print("Enter Bike Size (small / medium / large): ");
                                            size = scanner.nextLine().trim().toLowerCase(); 
                                            if (size.isEmpty()) {
                                                throw new IllegalArgumentException("Size cannot be empty.");
                                            } else if (!size.equals("small") && !size.equals("medium") && !size.equals("large")) {
                                                throw new IllegalArgumentException("Invalid size. Please enter 'small', 'medium', or 'large'.");
                                            }
                                            validSizeInput = true;
                                        } catch (IllegalArgumentException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    } while (!validSizeInput);

                                    boolean validPriceInput = false;
                                    do {
                                        try {
                                            System.out.print("Enter Bike Price: ");
                                            price = Double.parseDouble(scanner.nextLine()); 
                                    
                                            if (price <= 0) {
                                                System.out.println("Price must be positive. Please try again.");
                                            } else {
                                                validPriceInput = true; 
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Invalid input. Please enter a valid number for the bike price.");
                                        }
                                    } while (!validPriceInput);

                                    boolean validQuantityInput = false;
                                    do {
                                        try {
                                            System.out.print("Enter Bike Quantity: ");
                                            quantity = Integer.parseInt(scanner.nextLine()); 
                                    
                                            if (quantity <= 0) {
                                                System.out.println("Quantity must be positive. Please try again.");
                                            } else {
                                                validQuantityInput = true; 
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Invalid input. Please enter a valid integer for the quantity.");
                                        }
                                    } while (!validQuantityInput);


                                    Bike newBike = null;


                                    switch (bikeTypeChoice) {
                                        case 1:
                                            String gearType = "";
                                            boolean validGearType = false;

                                            while (!validGearType) {
                                                System.out.print("Enter Gear Type (Fixed or Free wheel): ");
                                                gearType = scanner.nextLine().trim().toLowerCase(); 

                                                if (gearType.equals("fixed") || gearType.equals("free wheel")) {
                                                    validGearType = true;
                                                } else {
                                                    System.out.println("Invalid input. Please enter either 'Fixed' or 'Free wheel'.");
                                                }
                                            }

                                            boolean hasBrakes = false;
                                            boolean validBrakeInput = false;

                                            while (!validBrakeInput) {
                                                System.out.print("Does the bike have brakes? (true or false): ");
                                                String brakesInput = scanner.nextLine().trim().toLowerCase();

                                                if (brakesInput.equals("true")) {
                                                    hasBrakes = true;
                                                    validBrakeInput = true;
                                                } else if (brakesInput.equals("false")) {
                                                    hasBrakes = false;
                                                    validBrakeInput = true;
                                                } else {
                                                    System.out.println("Invalid input. Please enter 'true' or 'false'.");
                                                }
                                            }
                                    
                                            newBike = new FixedGearBikes(brand, model, color, frameMaterial, size, price, quantity, gearType, hasBrakes);
                                            System.out.println("-----------------------------------------------------------");
                                            System.out.println("Fixed Gear Id: " + newBike.getId() + " , Brand: " + brand + " , Model: " + model
                                                    + " , Color: " + color + " , Frame Material: " + frameMaterial + " , Size: " + size
                                                    + " , Price: " + price + " , Quantity: " + quantity + " , Gear Type: " + gearType
                                                    + " , Brakes: " + hasBrakes + " added in the inventory");
                                            break;
                                    
                                        case 2:
                                            String suspension = "";
                                            boolean validSuspensionType = false; 
                                            
                                            while (!validSuspensionType) {
                                                System.out.print("Enter Suspension Type (Front Suspension or Full Suspension): ");
                                                suspension = scanner.nextLine().trim(); 
                                            
                                                if (suspension.equalsIgnoreCase("front suspension") || suspension.equalsIgnoreCase("full suspension")) {
                                                    validSuspensionType = true;
                                                } else {
                                                    System.out.println("Invalid input. Please enter either 'Front Suspension' or 'Full Suspension'.");
                                                }
                                            }
                                    
                                            newBike = new MountainBikes(brand, model, color, frameMaterial, size, price, quantity, suspension);
                                            System.out.println("-----------------------------------------------------------");
                                            System.out.println("Mountain Bike Id: " +  newBike.getId() + " , Brand: " + brand + " , Model: " + model
                                                    + " , Color: " + color + " , Frame Material: " + frameMaterial + " , Size: " + size
                                                    + " , Price: " + price + " , Quantity: " + quantity + " , Suspension: " + suspension
                                                    + " added in the inventory");
                                            break;
                                    
                                        case 3:
                                            String brakeType = "";
                                            boolean validBrakeType = false; 
                                            
                                            while (!validBrakeType) {
                                                System.out.print("Enter your Brake Type (Disc Brake or Caliper Brake): ");
                                                brakeType = scanner.nextLine().trim();
                                            
                                                if (brakeType.equalsIgnoreCase("disc brake") || brakeType.equalsIgnoreCase("caliper brake")) {
                                                    validBrakeType = true; 
                                                } else {
                                                    System.out.println("Invalid input. Please enter either 'Disc Brake' or 'Caliper Brake'.");
                                                }
                                            }
                                    
                                            newBike = new RoadBikes(brand, model, color, frameMaterial, size, price, quantity, brakeType);
                                            System.out.println("-----------------------------------------------------------");
                                            System.out.println("RoadBike Id: " + newBike.getId()+ " , Brand: " + brand + " , Model: " + model + " , Color: " + color 
                                                    + " , Frame Material: " + frameMaterial + " , Size: " + size + " , Price: " + price 
                                                    + " , Quantity: " + quantity + " , Brake Type : " + brakeType + " added in the inventory");
                                            break;
                                    
                                        default:
                                            System.out.println("Invalid bike type choice.");
                                        
                                    }
                                    
                                    if (newBike != null) {
                                        owner.getBikeShop().getInventory().addBikeToInventory(newBike);
                                        System.out.println("Bike added successfully!");

                                        String continueChoice;
                                        boolean validInput;

                                        do {
                                            System.out.print("Do you want to add another bike to this category? (yes or no): ");
                                            continueChoice = scanner.nextLine().trim().toLowerCase();
                                        
                                            if (continueChoice.equals("yes") || continueChoice.equals("no")) {
                                                validInput = true; 
                                            } else {
                                                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                                                validInput = false; 
                                            }
                                        } while (!validInput);
                                        
                                        if (continueChoice.equals("no")) {
                                            addingMoreBikes = false;
                                        }
                                    }
                                }

                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter numeric values where required.");
                            }
                                                  
                        }
                        break;

                    case 2:
                        boolean deletingBikesMenuActive = true;
                        while (deletingBikesMenuActive) {
                            try {
                                System.out.println("---------------------------");
                                System.out.println("Select Bike Type to Remove:");
                                System.out.println("1. Fixed Gear");
                                System.out.println("2. Mountain Bike");
                                System.out.println("3. Road Bike");
                                System.out.println("4. Exit to Main Menu");
                                System.out.print("Enter choice: ");
                                int deleteTypeChoice = Integer.parseInt(scanner.nextLine());
                               
                                if (deleteTypeChoice < 1 || deleteTypeChoice > 4) {
                                    System.out.println("Invalid choice. Please select a number between 1 and 4.");
                                    continue; 
                                }

                                if (deleteTypeChoice == 4) {
                                    deletingBikesMenuActive = false;
                                    System.out.println("Returning to the main menu");
                                    break;
                                }

                                //Display of all Bikes available
                                System.out.println("---------------------------");
                                System.out.println("Available Bikes for Selected Category:");
                                boolean typeExists = false;

                                for (Bike bike :owner.getBikeShop().getInventory().getBikes()) {
                                    boolean matchesType = (deleteTypeChoice == 1 && bike instanceof FixedGearBikes) ||
                                            (deleteTypeChoice == 2 && bike instanceof MountainBikes) ||
                                            (deleteTypeChoice == 3 && bike instanceof RoadBikes);

                                    if (matchesType) {
                                        typeExists = true;

                                        String specificAttributes = ""; 
                                        String category;

                                        if (bike instanceof FixedGearBikes) {
                                            FixedGearBikes fixedGearBike = (FixedGearBikes) bike;
                                            specificAttributes = String.format("Gear Type: %s, Brakes: %s",fixedGearBike.getGearType(),fixedGearBike.hasBrakes());
                                            category = "Fixed Gear";
                                        } else if (bike instanceof MountainBikes) {
                                            MountainBikes mountainBike = (MountainBikes) bike;
                                            specificAttributes = String.format("Suspension: %s",mountainBike.getSuspension());
                                            category = "Mountain Bike";
                                        } else if (bike instanceof RoadBikes) {
                                            RoadBikes roadBike = (RoadBikes) bike;
                                            specificAttributes = String.format("Brake Type: %s",roadBike.getBrakeType());
                                            category = "Road Bike";
                                        }else {
                                            category = "Unknown"; 
                                        }

                                        System.out.printf("ID: %-5s | Brand: %-10s | Model: %-10s | Color: %-5s | Frame Material: %-5s | Size: %-4s | Price: %-8.2f | Quantity: %-5d | Category: %-10s| %s\n",
                                                bike.getId(),
                                                bike.getBrand(),
                                                bike.getModel(),
                                                bike.getColor(),
                                                bike.getFrameMaterial(),
                                                bike.getSize(),
                                                bike.getPrice(),
                                                bike.getQuantity(),
                                                category,
                                                specificAttributes 
                                        );
                                    }
                                }

                                if (!typeExists) {
                                    System.out.println("No bikes of the selected type are available.");
                                    continue;
                                }

                                while (true) {
                                    System.out.print("Enter Bike ID to Remove (or type 'exit' to finish): ");
                                    String idToDelete = scanner.nextLine().trim().toLowerCase();

                                    if (idToDelete.equals("exit")) {
                                        System.out.println("Exiting bike removal process.");
                                        break; 
                                    }

                                    boolean bikeFound = false;
                                    Bike bikeToRemove = null;

                                    for (Bike bike : owner.getBikeShop().getInventory().getBikes()) {
                                        boolean matchesType =(deleteTypeChoice == 1 && bike instanceof FixedGearBikes) ||
                                                             (deleteTypeChoice == 2 && bike instanceof MountainBikes) ||
                                                             (deleteTypeChoice == 3 && bike instanceof RoadBikes);

                                        if (matchesType && bike.getId().toLowerCase().equals(idToDelete)) {
                                            bikeToRemove = bike;
                                            bikeFound = true;
                                            break;
                                        }
                                    }

                                    if (bikeFound && bikeToRemove != null) {
                                        if (bikeToRemove.getQuantity() == 0) {
                                            System.out.println("----------------------------------------");
                                            System.out.println("No quantity available for the selected bike with ID " + idToDelete + ".");
                                            System.out.println("Please choose another bike or restock the inventory.");
                                            break;
                                        }

                                        int quantityToDelete = 0;
                                        boolean validQuantityInput = false;
                                        do {
                                            try {
                                                System.out.print("How many quantity of bikes do you want to remove? Available quantity: " + bikeToRemove.getQuantity() + ": ");
                                                quantityToDelete = Integer.parseInt(scanner.nextLine().trim());
                                        
                                                if (quantityToDelete <= 0 || quantityToDelete > bikeToRemove.getQuantity()) {
                                                    System.out.println("Invalid quantity. Please enter a positive number that does not exceed the available quantity.");
                                                } else {
                                                    validQuantityInput = true;
                                                }
                                            } catch (NumberFormatException e) {
                                                System.out.println("Invalid input. Please enter a valid number.");
                                            }
                                        } while (!validQuantityInput);

                                        if (quantityToDelete <= bikeToRemove.getQuantity() && quantityToDelete > 0) {
                                            // Update the quantity and check if the bike should be removed
                                            int updatedQuantity = bikeToRemove.getQuantity() - quantityToDelete;
                                            bikeToRemove.setQuantity(updatedQuantity); // Update the quantity in the bike object

                                            if (updatedQuantity == 0) {
                                                Bike.returnId(bikeToRemove.getId());

                                                owner.getBikeShop().getInventory().removeBikeFromInventory(bikeToRemove);
                                                System.out.println("----------------------------------------");
                                                System.out.println("All bikes with ID " + idToDelete + " removed successfully.");
                                            } else {
                                                System.out.println("----------------------------------------");
                                                System.out.println(quantityToDelete + " bike(s) with ID " + idToDelete + " removed successfully. Remaining quantity: " + updatedQuantity);
                                            }
                                        } else {
                                            System.out.println("Invalid quantity entered. Please enter a quantity between 1 and " + bikeToRemove.getQuantity() + ".");
                                        }
                                    } else {
                                        System.out.println("Bike with ID " + idToDelete + " not found in the inventory.");
                                        boolean validResponse = false;

                                        do {
                                            System.out.print("Do you want to try again? (yes or no): ");
                                            String tryAgain = scanner.nextLine().trim().toLowerCase();

                                            if (tryAgain.equals("yes")) {
                                                validResponse = true; 
                                            } else if (tryAgain.equals("no")) {
                                                validResponse = true;
                                                bikeFound = true; 
                                            } else {
                                                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                                            }
                                        } while (!validResponse);
                                    }
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter numeric values where required.");
                            }
                        }
                        break;

                    case 3:
                        boolean displayingBikesMenu = true;
                        while (displayingBikesMenu) {
                            try {
                                int totalBikes = 0;
                                int totalFixedGearBikes = 0;
                                int totalMountainBikes = 0;
                                int totalRoadBikes = 0;

                                for (Bike bike : owner.getBikeShop().getInventory().getBikes()) {
                                    totalBikes += bike.getQuantity();
                                    if (bike instanceof FixedGearBikes) {
                                        totalFixedGearBikes += bike.getQuantity();
                                    } else if (bike instanceof MountainBikes) {
                                        totalMountainBikes += bike.getQuantity();
                                    } else if (bike instanceof RoadBikes) {
                                        totalRoadBikes += bike.getQuantity();
                                    }
                                }

                                System.out.println("------------------------------------");
                                System.out.println("Inventory Name: " + inventory.getInventoryName());
                                System.out.println("Total number of bikes in inventory: " + totalBikes);

                                owner.getBikeShop().getInventory().sortBikesById();

                                System.out.println("------------------------------------");
                                System.out.println("Select the type of bikes to display:");
                                System.out.println("1. Display All Bikes ( Sorted by Id )");
                                System.out.println("2. Fixed Gear Bikes: " + totalFixedGearBikes + " bikes");
                                System.out.println("3. Mountain Bikes: " + totalMountainBikes + " bikes");
                                System.out.println("4. Road Bikes: " + totalRoadBikes + " bikes");
                                System.out.println("5. Display Bikes Sorted by Price (Lowest to Highest)");
                                System.out.println("6. Return to Main Menu");
                                System.out.print("Enter choice: ");
                                int displayTypeChoice = Integer.parseInt(scanner.nextLine());
                                
                                if (displayTypeChoice < 1 || displayTypeChoice > 6) {
                                    System.out.println("Invalid choice. Please select a number between 1 and 5.");
                                    continue;
                                }

                                int bikeTotalQuantity = 0;

                                switch (displayTypeChoice) {
                                    case 1:
                                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
                                        System.out.println("Displaying All Bikes in Inventory ( Sorted by Id ):");
                                        System.out.printf("%-5s | %-15s | %-15s | %-10s | %-15s | %-10s | %-10s | %-10s | %-15s | %-30s\n",
                                                       "ID", "Brand", "Model", "Color", "Frame Material", "Size", "Price", "Quantity", "Category", "Specific Attributes");
                                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");

                                        for (Bike bike : owner.getBikeShop().getInventory().getBikes()) {
                                            String category;
                                            String specificAttributes = ""; 

                                            if (bike instanceof FixedGearBikes) {
                                                category = "Fixed Gear";
                                                FixedGearBikes fixedGearBike = (FixedGearBikes) bike;
                                                specificAttributes = String.format("Gear Type: %s, Brakes: %s",
                                                        fixedGearBike.getGearType(),
                                                        fixedGearBike.hasBrakes());

                                            } else if (bike instanceof MountainBikes) {
                                                category = "Mountain Bike";
                                                MountainBikes mountainBike = (MountainBikes) bike;
                                                specificAttributes = String.format("Suspension: %s",
                                                        mountainBike.getSuspension());

                                            } else if (bike instanceof RoadBikes) {
                                                category = "Road Bike";
                                                RoadBikes roadBike = (RoadBikes) bike;
                                                specificAttributes = String.format("Brake Type: %s",roadBike.getBrakeType());

                                            } else {
                                                category = "Unknown";
                                            }

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
                                        }

                                        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
                                        System.out.println("Total Bikes Displayed: " + bikeTotalQuantity);
                                        break;

                                    case 2:
                                        System.out.println("----------------------------");
                                        System.out.println("Displaying Fixed Gear Bikes:");
                                        for (Bike bike : owner.getBikeShop().getInventory().getBikes()) {
                                            if (bike instanceof FixedGearBikes) {
                                                FixedGearBikes fixedGearBike = (FixedGearBikes) bike;
                                                fixedGearBike.bikeDisplay();
                                                bikeTotalQuantity += fixedGearBike.getQuantity();
                                            }
                                        }
                                        System.out.println("Total Fixed Gear Bikes: " + bikeTotalQuantity);
                                        break;

                                    case 3:
                                        System.out.println("----------------------------");
                                        System.out.println("Displaying Mountain Bikes:");
                                        for (Bike bike : owner.getBikeShop().getInventory().getBikes()) {
                                            if (bike instanceof MountainBikes) {
                                                MountainBikes mountainBike = (MountainBikes) bike;
                                                mountainBike.bikeDisplay();
                                                bikeTotalQuantity += mountainBike.getQuantity();

                                            }
                                        }
                                        System.out.println("Total Mountain Bikes: " + bikeTotalQuantity);
                                        break;

                                    case 4:
                                        System.out.println("----------------------------");
                                        System.out.println("Displaying Road Bikes:");
                                        for (Bike bike : owner.getBikeShop().getInventory().getBikes()) {
                                            if (bike instanceof RoadBikes) {
                                                RoadBikes roadBike = (RoadBikes) bike;
                                                roadBike.bikeDisplay();
                                                bikeTotalQuantity += bike.getQuantity();
                                            }
                                        }
                                        System.out.println("Total Road Bikes: " + bikeTotalQuantity);
                                        break;

                                    case 5:
                                        owner.getBikeShop().getInventory().sortBikesByPrice();

                                        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                                        System.out.println("Displaying All Bikes in Inventory ( Sorted by Price ):");
                                        System.out.printf("%-5s | %-15s | %-15s | %-10s | %-15s | %-10s | %-10s | %-10s | %-15s | %-30s\n",
                                                "ID", "Brand", "Model", "Color", "Frame Material", "Size", "Price", "Quantity", "Category", "Specific Attributes");
                                        System.out.println("---------------------------------------------------------------------------------------------------------------------------");

                                        for (Bike bike : owner.getBikeShop().getInventory().getBikes()) {
                                            String category;
                                            String specificAttributes = ""; // Initialize specific attributes string

                                            if (bike instanceof FixedGearBikes) {
                                                category = "Fixed Gear";
                                                FixedGearBikes fixedGearBike = (FixedGearBikes) bike;
                                                specificAttributes = String.format("Gear Type: %s, Brakes: %s",
                                                        fixedGearBike.getGearType(),
                                                        fixedGearBike.hasBrakes());

                                            } else if (bike instanceof MountainBikes) {
                                                category = "Mountain Bike";
                                                MountainBikes mountainBike = (MountainBikes) bike;
                                                specificAttributes = String.format("Suspension: %s",
                                                        mountainBike.getSuspension());

                                            } else if (bike instanceof RoadBikes) {
                                                category = "Road Bike";
                                                RoadBikes roadBike = (RoadBikes) bike;
                                                specificAttributes = String.format("Brake Type: %s",roadBike.getBrakeType());

                                            } else {
                                                category = "Unknown";
                                            }

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
                                        }

                                        System.out.println(
                                                "------------------------------------------------------------------------------------------------");
                                        System.out.println("Total Bikes Displayed: " + bikeTotalQuantity);
                                        break;                                      

                                    case 6:
                                        displayingBikesMenu = false;
                                        System.out.println("Returning to Main Menu");
                                        break;
                                    default:
                                        System.out.println("Invalid choice.");
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter numeric values where required.");
                            }
                        }
                        break;

                    case 4:
                        boolean sellingBikesMenuActive = true; 

                        while (sellingBikesMenuActive) {
                            System.out.println("=== Sell a Bike ===");
                    
                            System.out.print("Enter Buyer's First Name: ");
                            String firstName = scanner.nextLine().trim();
                            System.out.print("Enter Buyer's Last Name: ");
                            String lastName = scanner.nextLine().trim();
                    
                            Buyer buyer = new Buyer(firstName, lastName);
                    
                            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Displaying All Bikes in Inventory:");
                            System.out.printf("%-5s | %-15s | %-15s | %-10s | %-15s | %-10s | %-10s | %-10s | %-15s | %-30s\n",
                                    "ID", "Brand", "Model", "Color", "Frame Material", "Size", "Price", "Quantity", "Category", "Specific Attributes");
                            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                    
                            boolean anyBikesAvailable = false; 
                    
                            for (Bike bike : owner.getBikeShop().getInventory().getBikes()) {
                                String category;
                                String specificAttributes = ""; 
                    
                                if (bike instanceof FixedGearBikes) {
                                    category = "Fixed Gear";
                                    FixedGearBikes fixedGearBike = (FixedGearBikes) bike;
                                    specificAttributes = String.format("Gear Type: %s, Brakes: %s",fixedGearBike.getGearType(),fixedGearBike.hasBrakes());
                                } else if (bike instanceof MountainBikes) {
                                    category = "Mountain Bike";
                                    MountainBikes mountainBike = (MountainBikes) bike;
                                    specificAttributes = String.format("Suspension: %s", mountainBike.getSuspension());
                                } else if (bike instanceof RoadBikes) {
                                    category = "Road Bike";
                                    RoadBikes roadBike = (RoadBikes) bike;
                                    specificAttributes = String.format("Brake Type: %s", roadBike.getBrakeType());
                                } else {
                                    category = "Unknown";
                                }
                    
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
                    
                                anyBikesAvailable = true; 
                            }
                    
                            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                    
                            if (!anyBikesAvailable) {
                                System.out.println("No bikes available for sale. Returning to Main Menu.");
                                break; 
                            }
                    
                            LinkedList<Bike> bikesToSell = new LinkedList<>();
                            LinkedList<Integer> quantitiesToSell = new LinkedList<>();
                            boolean sellingMore = true;
                    
                            while (sellingMore) {
                                System.out.print("\nEnter Bike ID to Sell: ");
                                String bikeId = scanner.nextLine().trim().toLowerCase();
                    
                                Bike bikeToSell = owner.getBikeShop().getInventory().findBikeById(bikeId);
                                if (bikeToSell == null) {
                                    System.out.println("Bike with ID " + bikeId + " not found. Try again.");
                                } else {
                                    int quantityToSell = 0;
                                    boolean validInput = false;
                    
                                    do {
                                        try {
                                            System.out.print("Enter Quantity to Sell (Available: " + bikeToSell.getQuantity() + "): ");
                                            quantityToSell = Integer.parseInt(scanner.nextLine());
                    
                                            if (quantityToSell <= 0 || quantityToSell > bikeToSell.getQuantity()) {
                                                System.out.println("Quantity must be a positive number and not exceed the available stock. Please try again.");
                                            } else {
                                                validInput = true; 
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Invalid input. Please enter a valid integer for the quantity to sell.");
                                        }
                                    } while (!validInput);
                    
                                    bikesToSell.add(bikeToSell); 
                                    quantitiesToSell.add(quantityToSell);
                                    System.out.println("Bike added to the sale.");
                    
                                    String sellAnother;
                                    do {
                                        System.out.print("Sell another bike? (yes or no): ");
                                        sellAnother = scanner.nextLine().trim().toLowerCase();
                                        if (!sellAnother.equals("yes") && !sellAnother.equals("no")) {
                                            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                                        }
                                    } while (!sellAnother.equals("yes") && !sellAnother.equals("no"));
                            
                                    sellingMore = sellAnother.equals("yes");
                                
                                }
                            }
                    
                            if (bikesToSell.isEmpty()) {
                                System.out.println("No bikes were sold. Returning to Main Menu.");
                                break; 
                            }
                            
                            //Bikes chosen by buyer 
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
                                    specificAttributes = String.format("Gear Type: %s, Brakes: %s",fixedGearBike.getGearType(),fixedGearBike.hasBrakes());
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
                    
                            double totalPrice = Payment.calculateTotalPrice(bikesToSell, quantitiesToSell);
                            System.out.println("Total Price: $" + totalPrice);
                    
                            String confirmation = "";
                            do {
                                System.out.print("Proceed with the purchase? (yes or no): ");
                                confirmation = scanner.nextLine().trim().toLowerCase();
                                if (!confirmation.equals("yes") && !confirmation.equals("no")) {
                                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                                }
                            } while (!confirmation.equals("yes") && !confirmation.equals("no"));

                            if (!confirmation.equals("yes")) {
                                String sellAnother = "";
                                do {
                                    System.out.print("Would you like to sell a bike again? (yes or no): ");
                                    sellAnother = scanner.nextLine().trim().toLowerCase();
                                    if (!sellAnother.equals("yes") && !sellAnother.equals("no")) {
                                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                                    }
                                } while (!sellAnother.equals("yes") && !sellAnother.equals("no"));
                            
                                if (sellAnother.equals("yes")) {
                                    continue;
                                } else {
                                    System.out.println("No bikes sold...Returning to Main Menu...");
                                    break; 
                                }
                            }

                            // Update the quantities in the inventory only if the user confirms the purchase
                            for (int i = 0; i < bikesToSell.size(); i++) {
                                Bike bike = bikesToSell.get(i);
                                int quantity = quantitiesToSell.get(i);
                                bike.setQuantity(bike.getQuantity() - quantity); // Update the bike quantity in inventory
                            }
                    
                            System.out.print("Enter Payment Method (Cash or Card): ");
                            String paymentMethod = scanner.nextLine();
                    
                            double paymentAmount = 0;
                            boolean validInput = false;
                            do {
                                try {
                                    System.out.print("Enter Payment Amount: ");
                                    paymentAmount = Double.parseDouble(scanner.nextLine());
                    
                                    if (paymentAmount < totalPrice) {
                                        System.out.println("Insufficient amount. Please try again.");
                                    } else {
                                        validInput = true; 
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid input. Please enter a valid number for the payment amount.");
                                }
                            } while (!validInput);
                    
                            Payment payment = new Payment(paymentAmount, paymentMethod);
                    
                            if (payment.processPayment()) {
                                Order order = new Order(buyer, bikesToSell, payment, bikeShop);
                                System.out.println("Order ID: " + order.getOrderId());
                                System.out.println("Transaction successful!");
                                order.generateReceipt(quantitiesToSell);
                            } else {
                                System.out.println("Payment failed. Transaction could not be completed.");
                            }
                    
                            String anotherSale;
                            do {
                                System.out.print("Do you want to do another sale? (yes or no): ");
                                anotherSale = scanner.nextLine().trim().toLowerCase();
                            
                                if (!anotherSale.equals("yes") && !anotherSale.equals("no")) {
                                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                                }
                            } while (!anotherSale.equals("yes") && !anotherSale.equals("no"));
                            
                            sellingBikesMenuActive = anotherSale.equals("yes");
                        }
                        break;

                    case 5:
                        boolean updateABike = true;
                    
                        while (updateABike) {
                            // Display all bikes in inventory
                            System.out.println("\nBikes in Inventory:");
                            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                            System.out.printf("%-5s | %-15s | %-15s | %-10s | %-15s | %-10s | %-10s | %-10s | %-15s | %-30s\n",
                                             "ID", "Brand", "Model", "Color", "Frame Material", "Size", "Price", "Quantity", "Category", "Specific Attributes");
                            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                    
                            for (Bike bike : owner.getBikeShop().getInventory().getBikes()) {
                                String category;
                                String specificAttributes = ""; 

                                if (bike instanceof FixedGearBikes) {
                                    category = "Fixed Gear";
                                    FixedGearBikes fixedGearBike = (FixedGearBikes) bike;
                                    specificAttributes = String.format("Gear Type: %s, Brakes: %s",fixedGearBike.getGearType(),fixedGearBike.hasBrakes());
                                } else if (bike instanceof MountainBikes) {
                                    category = "Mountain Bike";
                                    MountainBikes mountainBike = (MountainBikes) bike;
                                    specificAttributes = String.format("Suspension: %s",mountainBike.getSuspension());
                                } else if (bike instanceof RoadBikes) {
                                    category = "Road Bike";
                                    RoadBikes roadBike = (RoadBikes) bike;
                                    specificAttributes = String.format("Brake Type: %s", roadBike.getBrakeType());
                                } else {
                                    category = "Unknown";
                                }
                    
                                System.out.printf("%-5s | %-15s | %-15s | %-10s | %-15s | %-10s | $%-9.2f | %-10d | %-15s | %-30s\n",
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

                            }
                            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                    
                            // Update bike logic
                            System.out.print("\nEnter the Bike ID to update: ");
                            String bikeIdToUpdate = scanner.nextLine().trim().toLowerCase();
                    
                            Bike bikeToUpdate = owner.getBikeShop().getInventory().findBikeById(bikeIdToUpdate);
                    
                            if (bikeToUpdate == null) {
                                System.out.println("Bike with ID " + bikeIdToUpdate + " not found in the inventory.");
                            } else {
                                boolean updating = true;
                                while (updating) {
                                    try {
                                        System.out.println("\nUpdating Bike Details:");
                                        System.out.println("1. Update Price");
                                        System.out.println("2. Update Quantity");
                                        System.out.println("3. Exit");
                                        System.out.print("Choose an option: ");
                                        int updateChoice = Integer.parseInt(scanner.nextLine());
         
                                        if (updateChoice < 1 || updateChoice > 3) {
                                            System.out.println("Invalid choice. Please select a number between 1 and 3.");
                                            continue; 
                                        }

                                        switch (updateChoice) {
                                            case 1:
                                                System.out.print("Enter the new price: ");
                                                double newPrice = scanner.nextDouble();
                                                scanner.nextLine();
                        
                                                if (newPrice <= 0) {
                                                    System.out.println("Invalid price. Price must be greater than 0.");
                                                } else {
                                                    bikeToUpdate.setPrice(newPrice); 
                                                    System.out.println("Price updated successfully.");
                                                }
                                                break;
                        
                                            case 2:
                                                System.out.print("Enter the quantity to add : ");
                                                int quantityToAdd = scanner.nextInt();
                                                scanner.nextLine();
                        
                                                if (quantityToAdd <= 0) {
                                                    System.out.println("Invalid quantity. Quantity must be 0 or greater.");
                                                } else {
                                                    bikeToUpdate.setQuantity(bikeToUpdate.getQuantity() + quantityToAdd); 
                                                    System.out.println("Quantity updated successfully. Current Quantity: " + bikeToUpdate.getQuantity());
                                                }
                                                break;
                        
                                            case 3:
                                                updating = false; 
                                                break;
                        
                                            default:
                                                System.out.println("Invalid option. Please choose again.");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid input. Please enter numeric values where required.");
                                    }
                                }
                            }
                    
                            String updateAnotherBike;
                            do {
                                System.out.print("\nDo you want to update another bike? (yes or no): ");
                                updateAnotherBike = scanner.nextLine().trim().toLowerCase();

                                if (!updateAnotherBike.equals("yes") && !updateAnotherBike.equals("no")) {
                                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                                }
                            } while (!updateAnotherBike.equals("yes") && !updateAnotherBike.equals("no"));

                            updateABike = updateAnotherBike.equals("yes");
                        }
                        break;
                                
                    case 6:
                        // Exit
                        running = false;
                        System.out.println("Exiting Only Durbs BikeShop inventory management system.");
                        break;

                    default:
                        System.out.println("Invalid option. Please select a number between 1 and 6. ");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric option.");
            }
        }

        scanner.close();
    }
}


