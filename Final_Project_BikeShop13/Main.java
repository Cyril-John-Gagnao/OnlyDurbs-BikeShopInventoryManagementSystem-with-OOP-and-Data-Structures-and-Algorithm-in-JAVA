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
        Bike defaultFixedGear = new FixedGearBikes("Celt", "Version 1", "black", "steel", "small", 7000, 15, "Fixed", false);
       
        owner.getBikeShop().getInventory().addBikeToInventory(defaultFixedGear);
        owner.getBikeShop().getInventory().addBikeToInventory(defaultMountainBike);
        owner.getBikeShop().getInventory().addBikeToInventory(defaultRoadBike);
        
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
                                            newBike.bikeDisplay();
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
                                            newBike.bikeDisplay();
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
                                            newBike.bikeDisplay();
                                            break;
                                    
                                        default:
                                            System.out.println("Invalid bike type choice.");
                                        
                                    }
                                    
                                    if (newBike != null) {
                                        owner.getBikeShop().getInventory().addBikeToInventory(newBike);
                                        System.out.println("Bike added successfully!");
                                        System.out.println("---------------------------");
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
                        boolean removingBikesMenuActive = true;
                        while (removingBikesMenuActive) {
                            try {
                                System.out.println("---------------------------");
                                System.out.println("Select Bike Type to Remove from Inventory:");
                                System.out.println("1. Fixed Gear");
                                System.out.println("2. Mountain Bike");
                                System.out.println("3. Road Bike");
                                System.out.println("4. Exit to Main Menu");
                                System.out.print("Enter choice: ");
                                int removeTypeChoice = Integer.parseInt(scanner.nextLine());
                               
                                if (removeTypeChoice < 1 || removeTypeChoice > 4) {
                                    System.out.println("Invalid choice. Please select a number between 1 and 4.");
                                    continue; 
                                }

                                if (removeTypeChoice == 4) {
                                    removingBikesMenuActive = false;
                                    System.out.println("Returning to the main menu");
                                    break;
                                }

                                String selectedCategory;
                                if (removeTypeChoice == 1) {
                                    selectedCategory = "Fixed Gear";
                                } else if (removeTypeChoice == 2) {
                                    selectedCategory = "Mountain Bike";
                                } else if (removeTypeChoice == 3) {
                                    selectedCategory = "Road Bike";
                                } else {
                                    selectedCategory = null;
                                }

                                owner.getBikeShop().getInventory().displayAllBikes(selectedCategory);

                               
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
                                        boolean matchesType =(removeTypeChoice == 1 && bike instanceof FixedGearBikes) ||
                                                             (removeTypeChoice == 2 && bike instanceof MountainBikes) ||
                                                             (removeTypeChoice == 3 && bike instanceof RoadBikes);

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
                                        System.out.println("Bike with ID " + idToDelete + " not found in the inventory. Try again");    
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

                                owner.getBikeShop().getInventory().displayBikesTotalSummary("all");

                                owner.getBikeShop().getInventory().sortBikesById();

                                System.out.println("------------------------------------");
                                System.out.println("Select the type of bikes to display:");
                                System.out.println("1. Display All Bikes ( Sorted by Id )");
                                System.out.println("2. Fixed Gear Bikes: " + owner.getBikeShop().getInventory().displayBikesTotalSummary("fixed gear") + " bikes");
                                System.out.println("3. Mountain Bikes: " +  owner.getBikeShop().getInventory().displayBikesTotalSummary("mountain")  + " bikes");
                                System.out.println("4. Road Bikes: " +  owner.getBikeShop().getInventory().displayBikesTotalSummary("road")  + " bikes");
                                System.out.println("5. Display All Bikes Sorted by Price (Lowest to Highest)");
                                System.out.println("6. Return to Main Menu");
                                System.out.print("Enter choice: ");
                                int displayTypeChoice = Integer.parseInt(scanner.nextLine());
                                
                                if (displayTypeChoice < 1 || displayTypeChoice > 6) {
                                    System.out.println("Invalid choice. Please select a number between 1 and 6.");
                                    continue;
                                }

                                switch (displayTypeChoice) {
                                    case 1:
                                    owner.getBikeShop().getInventory().displayAllBikes(null);
                                    break;
                                    case 2:
                                        owner.getBikeShop().getInventory().displayAllBikes("Fixed Gear");
                                        break;
                                    case 3:
                                        owner.getBikeShop().getInventory().displayAllBikes("Mountain Bike");
                                        break;
                                    case 4:
                                        owner.getBikeShop().getInventory().displayAllBikes("Road Bike");
                                        break;
                                    case 5:
                                        owner.getBikeShop().getInventory().sortBikesByPrice();

                                        owner.getBikeShop().getInventory().displayAllBikes(null);
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
                        
                            owner.getBikeShop().getInventory().sortBikesById();
                            owner.getBikeShop().getInventory().displayAllBikes(null);
                        
                            String firstName = "";
                            boolean validFirstName = false;
                            do {
                                try {
                                    System.out.print("Enter Buyer's First Name: ");
                                    firstName = scanner.nextLine().trim();
                                    if (firstName.isEmpty()) {
                                        throw new IllegalArgumentException("First name cannot be empty.");
                                    }
                                    validFirstName = true;
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            } while (!validFirstName);

                            String lastName = "";
                            boolean validLastName = false;
                            do {
                                try {
                                    System.out.print("Enter Buyer's Last Name: ");
                                    lastName = scanner.nextLine().trim(); // Use the existing 'lastName' variable
                                    if (lastName.isEmpty()) {
                                        throw new IllegalArgumentException("Last name cannot be empty.");
                                    }
                                    validLastName = true;
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            } while (!validLastName);
                        
                            Buyer buyer = new Buyer(firstName, lastName);
                        
                            LinkedList<Bike> bikesToSell = new LinkedList<>();
                            LinkedList<Integer> quantitiesToSell = new LinkedList<>();
                            boolean sellingMore = true;
                        
                            while (sellingMore) {
                                System.out.print("\nEnter Bike ID to Sell (or type 'exit' to finish): ");
                                String bikeId = scanner.nextLine().trim().toLowerCase();

                                
                                if (bikeId.equalsIgnoreCase("exit")) {
                                    sellingMore = false; 
                                    break; 
                                }

                                Bike bikeIdToSell = owner.getBikeShop().getInventory().findBikeById(bikeId);
                                if (bikeIdToSell == null) {
                                    System.out.println("Bike with ID " + bikeId + " not found. Try again.");
                                    continue;
                                }
                        
                                if (bikeIdToSell.getQuantity() <= 0) {
                                    System.out.println("Bike with ID " + bikeId + " is out of stock. Please try another bike.");
                                    continue;
                                }
                        
                                String confirmSale;
                                do {
                                    System.out.print("Bike found. Do you want to add it to the sale? (yes or no): ");
                                    confirmSale = scanner.nextLine().trim().toLowerCase();
                                    if (!confirmSale.equals("yes") && !confirmSale.equals("no")) {
                                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                                    }
                                } while (!confirmSale.equals("yes") && !confirmSale.equals("no"));
                        
                                if (confirmSale.equals("no")) {
                                    System.out.println("Sale for Bike ID: " + bikeId + " has been canceled.");
                                    continue;
                                }
                        
                                int quantityOfBikeToSell = 0;
                                boolean validInput = false;
                        
                                do {
                                    try {
                                        System.out.print("Enter Quantity to Sell (Available: " + bikeIdToSell.getQuantity() + "): ");
                                        quantityOfBikeToSell = Integer.parseInt(scanner.nextLine());
                        
                                        if (quantityOfBikeToSell <= 0 || quantityOfBikeToSell > bikeIdToSell.getQuantity()) {
                                            System.out.println("Quantity must be a positive number and not exceed the available stock. Please try again.");
                                        } else {
                                            validInput = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid input. Please enter a valid integer for the quantity to sell.");
                                    }
                                } while (!validInput);

                                bikeIdToSell.setQuantity(bikeIdToSell.getQuantity() - quantityOfBikeToSell);
                                
                                bikesToSell.add(bikeIdToSell);
                                quantitiesToSell.add(quantityOfBikeToSell);
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
                        
                            if (bikesToSell.isEmpty()) {
                                System.out.println("No bikes were sold. Returning to Main Menu.");
                                break;
                            } else {
                                System.out.println("Sale completed.");
                            }
                    
                            owner.getBikeShop().getInventory().displayBikesChosenByBuyer(bikesToSell, quantitiesToSell);
                            
                            double totalPrice = Payment.calculateTotalPrice(bikesToSell, quantitiesToSell);
                            System.out.println("Total Price: $" + totalPrice);
                    
                            String confirmation;
                            do {
                                System.out.print("Proceed with the purchase? (yes or no): ");
                                confirmation = scanner.nextLine().trim().toLowerCase();
                                if (!confirmation.equals("yes") && !confirmation.equals("no")) {
                                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                                }
                            } while (!confirmation.equals("yes") && !confirmation.equals("no"));

                            if (confirmation.equals("yes")) {
                                System.out.println("Inventory updated successfully.");
                            } else {
                                owner.getBikeShop().getInventory().updateQuantities(bikesToSell, quantitiesToSell);
                                
                                System.out.println("Sale canceled. No bikes were removed from inventory.");
                            }

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
                    
                            String paymentMethod = "";
                            boolean validPaymentMethodInput = false;

                            do {
                                try {
                                    System.out.print("Enter Payment Method (Cash / Card): ");
                                    paymentMethod = scanner.nextLine().trim().toLowerCase();

                                    if (paymentMethod.isEmpty()) {
                                        throw new IllegalArgumentException("Payment Method cannot be empty.");
                                    } else if (!paymentMethod.equals("cash") && !paymentMethod.equals("card")) {
                                        throw new IllegalArgumentException("Invalid Payment Method. Please enter 'cash' or 'card'.");
                                    }

                                    validPaymentMethodInput = true; 
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            } while (!validPaymentMethodInput);
                    
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

                            Order order = new Order(buyer, bikesToSell, payment, bikeShop);
                            System.out.println("-----------------------");
                            System.out.println("Transaction successful!");
                            System.out.println( "Order Id: "+ order.getOrderId());
                            order.generateReceipt(quantitiesToSell);

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

                            owner.getBikeShop().getInventory().sortBikesById();
                            owner.getBikeShop().getInventory().displayAllBikes(null);
                            
                            System.out.print("\nEnter the Bike ID to update (or type exit to finish): ");
                            String bikeIdToUpdate = scanner.nextLine().trim().toLowerCase();

                             if (bikeIdToUpdate.equalsIgnoreCase("exit")) {
                                updateABike = false; 
                                break;
                            }
                    
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
                                                double newPrice = 0.0;

                                                boolean validPriceInput = false; 
                                                do {
                                                    System.out.print("Enter the new price: ");
                                                    if (scanner.hasNextDouble()) { 
                                                        newPrice = scanner.nextDouble();
                                                        scanner.nextLine(); 
                                            
                                                        if (newPrice <= 0) {
                                                            System.out.println("Invalid price. Price must be greater than 0.");
                                                        } else {
                                                            validPriceInput = true; 
                                                        }
                                                    } else {
                                                        System.out.println("Invalid input. Please enter a valid number for the price.");
                                                        scanner.nextLine(); 
                                                    }
                                                } while (!validPriceInput); 
                                            
                                                bikeToUpdate.setPrice(newPrice);
                                                System.out.println("Price updated successfully. Current Price: " + bikeToUpdate.getPrice());
                                                break;

                                            case 2:
                                                boolean validQuantityInput = false;
                                                int quantityToAdd = 0;
                                                
                                                do {
                                                    System.out.print("Enter the quantity to add: ");
                                                    String input = scanner.nextLine().trim(); 
                                                
                                                    try {
                                                        quantityToAdd = Integer.parseInt(input); 
                                                
                                                        if (quantityToAdd <= 0) {
                                                            System.out.println("Invalid quantity. Quantity must be greater than 0.");
                                                        } else {
                                                            validQuantityInput = true; 
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        System.out.println("Invalid input. Please enter a valid integer for the quantity.");
                                                    }
                                                } while (!validQuantityInput);
                                                
                                                // Now you can safely update the bike's quantity
                                                bikeToUpdate.setQuantity(bikeToUpdate.getQuantity() + quantityToAdd);
                                                System.out.println("Quantity updated successfully. Current Quantity: " + bikeToUpdate.getQuantity());
                                                continue;
                                                
                                            case 3:
                                                updating = false; 
                                                System.out.println("You will exit updating bike details");
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


