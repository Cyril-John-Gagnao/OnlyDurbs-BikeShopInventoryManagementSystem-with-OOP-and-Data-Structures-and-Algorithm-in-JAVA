package Final_Project_BikeShop13;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Inventory inventory = new Inventory("Only Durbs Bike Shop Inventory");
        BikeShop bikeShop = new BikeShop("Only Durbs Bike Shop", "Iloilo", inventory  , null);  // Create a BikeShop instance
        BikeShopOwner owner = new BikeShopOwner("Cyril", "Gagnao", "Iloilo", "12345678910", bikeShop);
        


        // Main menu loop
        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to Only Durbs Bike Shop Inventory Management");
            System.out.println("1. Add Bike to Inventory");
            System.out.println("2. Delete Bike from Inventory");
            System.out.println("3. Display Bikes in Inventory");
            System.out.println("4. == Sell a Bike == ");
            System.out.println("5. Exit");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    boolean addingBikesMenuActive = true; // Flag to keep the loop running
                    while (addingBikesMenuActive) {
                        System.out.println("------------------");
                        System.out.println("Select Bike Type to add:");
                        System.out.println("1. Fixed Gear");
                        System.out.println("2. Mountain Bike");
                        System.out.println("3. Road Bike");
                        System.out.println("4. Exit to Main Menu");
                        System.out.print("Enter choice: ");
                        int bikeTypeChoice = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (bikeTypeChoice == 4) {
                            addingBikesMenuActive = false;
                            System.out.println("----------------------");
                            System.out.println("Returning to Main Menu");
                            break;
                        }
                
                        System.out.println("------------------");
                        System.out.print("Enter Bike Id: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Bike Brand: ");
                        String brand = scanner.nextLine();
                        System.out.print("Enter Bike model: ");
                        String model = scanner.nextLine();
                        System.out.print("Enter Bike Color: ");
                        String color = scanner.nextLine();
                        System.out.print("Enter Frame Material: ");
                        String frameMaterial = scanner.nextLine();
                        System.out.print("Enter the size of the bike: ");
                        String size = scanner.nextLine();
                        System.out.print("Enter Bike Price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter Bike Quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine(); 

                        Bike newBike = null;


                        if (bikeTypeChoice == 1) {
                            newBike = new FixedGearBikes(id, brand, model, color, frameMaterial, size, price, quantity);
                            System.out.println("-----------------------------------------------------------");
                            System.out.println("Fixed Gear Id: "+ id+" , Brand: " + brand +" , Model: "+ model +" , Color: "+ color +" , Frame Material: "+ frameMaterial + " , Size: "+size+" , Price: " + price +" , Quantity: "+quantity+" added in the inventory");
                        } else if (bikeTypeChoice == 2) {
                            System.out.println("-----------------------------------------------------------");
                            newBike = new MountainBikes(id, brand, model, color, frameMaterial, size, price, quantity);
                            System.out.println("Mountain Bike Id: "+ id+" , Brand: " + brand +" , Model: "+ model +" , Color: "+ color +" , Frame Material: "+ frameMaterial + " , Size: "+size+" , Price: " + price +" , Quantity: "+quantity+" added in the inventory");
                        } else if (bikeTypeChoice == 3) {
                            System.out.println("-----------------------------------------------------------");
                            newBike = new RoadBikes(id, brand, model, color, frameMaterial, size, price, quantity);
                            System.out.println("RoadBike Id: "+ id+" , Brand: " + brand +" , Model: "+ model +" , Color: "+ color +" , Frame Material: "+ frameMaterial + " , Size: "+size+" , Price: " + price +" , Quantity: "+quantity+" added in the inventory");
                        } else {
                            System.out.println("Invalid bike type choice.");
                        } 

                        if (newBike != null) {
                            owner.getBikeShop().getInventory().addBikeToInventory(newBike);
                            System.out.println("Bike added successfully to inventory.");
                        }
                    }
                    break;


                case 2:
                    boolean deletingBikesMenuActive = true;
                    while (deletingBikesMenuActive) {
                       
                        System.out.println("---------------------------");
                        System.out.println("Select Bike Type to Delete:");
                        System.out.println("1. Fixed Gear");
                        System.out.println("2. Mountain Bike");
                        System.out.println("3. Road Bike");
                        System.out.println("4. Exit to Main Menu");
                        System.out.print("Enter choice: ");
                        int deleteTypeChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (deleteTypeChoice == 4) {
                            deletingBikesMenuActive = false;
                            System.out.println("Returning to the main menu");
                            break; 
                        }

                       
                        System.out.println("---------------------------");
                        System.out.println("Available Bikes for Selected Type:");
                        LinkedList<Bike> bikesAvailable = owner.getBikeShop().getInventory().getBikes();
                        boolean typeExists = false;

                        for (Bike bike : bikesAvailable) {
                            boolean matchesType =
                                (deleteTypeChoice == 1 && bike instanceof FixedGearBikes) ||
                                (deleteTypeChoice == 2 && bike instanceof MountainBikes) ||
                                (deleteTypeChoice == 3 && bike instanceof RoadBikes);

                                if (matchesType) {
                                    typeExists = true;
                                    System.out.printf("ID: %-5s | Brand: %-10s | Model: %-10s | Color: %-10s | Frame Material: %-15s | Size: %-5s | Price: %-8.2f | Quantity: %-5d\n", 
                                                      bike.getId(), 
                                                      bike.getBrand(), 
                                                      bike.getModel(), 
                                                      bike.getColor(), 
                                                      bike.getFrameMaterial(), 
                                                      bike.getSize(), 
                                                      bike.getPrice(), 
                                                      bike.getQuantity());
                                }
                        }

                        if (!typeExists) {
                            System.out.println("No bikes found for the selected type. Try again.");
                            continue;
                        }


                      
                        System.out.println("---------------------");
                        System.out.print("Enter Bike ID to Delete: ");
                        String idToDelete = scanner.nextLine().trim();

                        // Flag to track if the bike was found and deleted
                        boolean bikeFound = false;

                        // Iterate over the inventory to find the bike to delete
                        LinkedList<Bike> bikes = owner.getBikeShop().getInventory().getBikes();
                        Bike bikeToRemove = null;

                        for (Bike bike : bikes) {
                            boolean matchesType =
                                (deleteTypeChoice == 1 && bike instanceof FixedGearBikes) ||
                                (deleteTypeChoice == 2 && bike instanceof MountainBikes) ||
                                (deleteTypeChoice == 3 && bike instanceof RoadBikes);

                          
                            if (matchesType && bike.getId().equals(idToDelete)) {
                                bikeToRemove = bike;
                                bikeFound = true;
                                break; 
                            }
                        }

                        if (bikeFound && bikeToRemove != null) {
                            System.out.print("How many bikes do you want to delete? Available quantity: " + bikeToRemove.getQuantity() + ": ");
                            int quantityToDelete = scanner.nextInt();
                    
                            if (quantityToDelete <= bikeToRemove.getQuantity() && quantityToDelete > 0) {
                                // Update the quantity and check if the bike should be removed
                                int updatedQuantity = bikeToRemove.getQuantity() - quantityToDelete;
                                bikeToRemove.setQuantity(updatedQuantity); // Update the quantity in the bike object
                    
                                if (updatedQuantity == 0) {
                                    // Remove the bike from the inventory if quantity reaches 0
                                    owner.getBikeShop().getInventory().removeBikeFromInventory(bikeToRemove);
                                    System.out.println("----------------------------------------");
                                    System.out.println("All bikes with ID " + idToDelete + " removed successfully.");
                                } else {
                                    System.out.println("----------------------------------------");
                                    System.out.println(quantityToDelete + " bike(s) with ID " + idToDelete + " removed successfully. " +
                                            "Remaining quantity: " + updatedQuantity);
                                }
                            } else {
                                System.out.println("Invalid quantity entered. Please enter a quantity between 1 and " + bikeToRemove.getQuantity() + ".");
                            }
                        } else {
                            System.out.println("Bike with ID " + idToDelete + " not found in the inventory.");
                        }
                    }
                    break;

                case 3:
                    boolean displayingBikesMenu = true; 
                    while (displayingBikesMenu) {

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
                        //System.out.println("Bikes sorted by ID!");
                        
                       
                        System.out.println("------------------------------------");
                        System.out.println("Select the type of bikes to display:");
                        System.out.println("1. Display All Bikes"); 
                        System.out.println("2. Fixed Gear Bikes: "+ totalFixedGearBikes+ " bikes");
                        System.out.println("3. Mountain Bikes: "+ totalMountainBikes+ " bikes");
                        System.out.println("4. Road Bikes: "+totalRoadBikes+ " bikes" );
                        System.out.println("5. Return to Main Menu");
                        System.out.print("Enter choice: ");
                        int displayTypeChoice = scanner.nextInt();
                        scanner.nextLine(); 

                        int bikeTotalQuantity = 0;
                    
                       
                        switch (displayTypeChoice) {
                            case 1: 
                            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                            System.out.println("Displaying All Bikesin Invetory:");
                            System.out.printf("%-5s | %-15s | %-15s | %-10s | %-15s | %-10s | %-10s | %-10s | %-15s\n",
                                             "ID", "Brand", "Model", "Color", "Frame Material", "Size", "Price", "Quantity", "Category");
                            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                        
                            for (Bike bike : owner.getBikeShop().getInventory().getBikes()) {
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
                        
                              
                                System.out.printf("%-5s | %-15s | %-15s | %-10s | %-15s | %-10s | %-10f | %-10d | %-15s\n",
                                                bike.getId(),
                                                bike.getBrand(),
                                                bike.getModel(),
                                                bike.getColor(),
                                                bike.getFrameMaterial(),
                                                bike.getSize(),
                                                bike.getPrice(),      
                                                bike.getQuantity(),
                                                category
                                );
                        
                                bikeTotalQuantity += bike.getQuantity(); // Accumulate total quantity
                            }
                        
                            System.out.println("------------------------------------------------------------------------------------------------");
                            System.out.println("Total Bikes Displayed: " + bikeTotalQuantity);
                            break;

                            case 2: 
                                System.out.println("----------------------------");
                                System.out.println("Displaying Fixed Gear Bikes:");
                                for (Bike bike : owner.getBikeShop().getInventory().getBikes()) {
                                    if (bike instanceof FixedGearBikes) {
                                        ((FixedGearBikes) bike).bikeDisplay("1 gear", false);
                                        bikeTotalQuantity += bike.getQuantity();
                                    }
                                }
                                System.out.println("Total Fixed Gear Bikes: " + bikeTotalQuantity);
                                break;
                                
                            case 3:
                                System.out.println("----------------------------");
                                System.out.println("Displaying Mountain Bikes:");
                                for (Bike bike : owner.getBikeShop().getInventory().getBikes()) {
                                    if (bike instanceof MountainBikes) {
                                        ((MountainBikes) bike).bikeDisplay("Full Suspension", "Knobby Tyres");
                                        bikeTotalQuantity += bike.getQuantity();
                                    }
                                }
                                System.out.println("Total Mountain Bikes: " + bikeTotalQuantity);
                                break;

                            case 4: 
                                System.out.println("----------------------------");
                                System.out.println("Displaying Road Bikes:");
                                for (Bike bike : owner.getBikeShop().getInventory().getBikes()) {
                                    if (bike instanceof RoadBikes) {
                                        ((RoadBikes) bike).bikeDisplay("Drop Bar", "Aerodynamics");
                                        bikeTotalQuantity += bike.getQuantity();
                                    }
                                }
                                System.out.println("Total Road Bikes: " + bikeTotalQuantity);
                                break;

                            case 5: 
                                displayingBikesMenu = false; 
                                    System.out.println("Returning to Main Menu");
                                    break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                            }
                    }
                    break;

                    
                case 4:
                boolean sellingBikesMenuActive = true; // Flag for the sell menu loop
                while (sellingBikesMenuActive) {
                    System.out.println("=== Sell a Bike ===");
            
                    System.out.print("Enter Buyer's First Name: ");
                    String firstName = scanner.nextLine().trim();
                    System.out.print("Enter Buyer's Last Name: ");
                    String lastName = scanner.nextLine().trim();
            
                    Buyer buyer = new Buyer(firstName, lastName);
            
                  
                    System.out.println("\nAvailable Bikes for Sale:");
                    LinkedList<Bike> bikesAvailable = owner.getBikeShop().getInventory().getBikes();
                    boolean anyBikesAvailable = false;
            
                    // Display all bikes with categories
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    System.out.printf("%-5s | %-10s | %-10s | %-10s | %-15s | %-5s | %-8s | %-5s | %-15s\n",
                                    "ID", "Brand", "Model", "Color", "Frame Material", "Size", "Price", "Quantity", "Category");
                    System.out.println("--------------------------------------------------------------------------------------------------------");

                    for (Bike bike : bikesAvailable) {
                        anyBikesAvailable = true;

                        // Determine the category of the bike
                        String category;
                        if (bike instanceof FixedGearBikes) {
                            category = "Fixed Gear";
                        } else if (bike instanceof MountainBikes) {
                            category = "Mountain Bike";
                        } else if (bike instanceof RoadBikes) {
                            category = "Road Bike";
                        } else {
                            category = "Unknown";// This will trigger if the object isn't any of the specified subclasses
                        }

                        // Display bike details including the category
                        System.out.printf("%-5s | %-10s | %-10s | %-10s | %-15s | %-5s | $%-8.2f | %-4d    | %-20s\n",
                                bike.getId(),
                                bike.getBrand(),
                                bike.getModel(),
                                bike.getColor(),
                                bike.getFrameMaterial(),
                                bike.getSize(),
                                bike.getPrice(),
                                bike.getQuantity(),
                                category);
                    }

                    if (!anyBikesAvailable) {
                        System.out.println("No bikes available for sale. Returning to Main Menu.");
                        break; // Exit to main menu if no bikes are available
                    }
            
                    LinkedList<Bike> bikesToSell = new LinkedList<>();
                    LinkedList<Integer> quantitiesToSell = new LinkedList<>();
                    boolean sellingMore = true;
            
                  
                    while (sellingMore) {
                        System.out.print("\nEnter Bike ID to Sell: ");
                        String bikeId = scanner.nextLine().trim();
            
                       
                        Bike bikeToSell = owner.getBikeShop().getInventory().findBikeById(bikeId);
                        if (bikeToSell == null) {
                            System.out.println("Bike with ID " + bikeId + " not found. Try again.");
                        } else {
                            System.out.print("Enter Quantity to Sell (Available: " + bikeToSell.getQuantity() + "): ");
                            int quantityToSell = scanner.nextInt();
                            scanner.nextLine(); 
            
                            if (quantityToSell <= 0 || quantityToSell > bikeToSell.getQuantity()) {
                                System.out.println("Invalid quantity. Try again.");
                            } else {
                                // Update inventory and add to sale
                                bikeToSell.setQuantity(bikeToSell.getQuantity() - quantityToSell);
                                bikesToSell.add(bikeToSell); // Add the bike to the bikesToSell list
                                quantitiesToSell.add(quantityToSell);
                                System.out.println("Bike added to the sale.");
                            }
                        }
            
                        System.out.print("Sell another bike? yes or no: ");
                        sellingMore = scanner.nextLine().equalsIgnoreCase("yes");
                    }
            
                    if (bikesToSell.isEmpty()) {
                        System.out.println("No bikes were sold. Returning to Main Menu.");
                        break; 
                    }
            
                    double totalPrice = Payment.calculateTotalPrice(bikesToSell, quantitiesToSell);
                    System.out.println("Total Price: $" + totalPrice);
            
                    // Ask for payment in a loop until the payment is sufficient
                    double paymentAmount = 0;
                    do {
                        System.out.print("Enter Payment Amount: ");
                        paymentAmount = scanner.nextDouble();
                        scanner.nextLine(); 
            
                        if (paymentAmount < totalPrice) {
                            System.out.println("Insufficient amount. Please try again");
                        }
                    } while (paymentAmount < totalPrice);
            
                    System.out.print("Enter Order ID: ");
                    String orderId = scanner.nextLine().trim(); 
            
                  
                    System.out.print("Enter Payment Method: ");
                    String paymentMethod = scanner.nextLine();
            
                  
                    Payment payment = new Payment(paymentAmount, paymentMethod);
            
                    if (payment.processPayment()) {
                        Order order = new Order(orderId, buyer, bikesToSell, payment);
                        System.out.println("Transaction successful!");
                        order.generateReceipt(quantitiesToSell);
                    } else {
                        System.out.println("Payment failed. Transaction could not be completed.");
                    }
            
                    System.out.print("Do you want to do another sale? yes or no: ");
                    sellingBikesMenuActive = scanner.nextLine().equalsIgnoreCase("yes");
                }
                break;


                case 5:
                    // Exit
                    running = false;
                    System.out.println("Exiting the inventory management system.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}

