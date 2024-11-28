package Final_Project_BikeShop13;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Inventory inventory = new Inventory("Cyril's Bike Shop Inventory");
        BikeShop bikeShop = new BikeShop("Cyril's Bike Shop", "Iloilo", inventory  , null);  // Create a BikeShop instance
        BikeShopOwner owner = new BikeShopOwner("Cyril", "Gagnao", "Iloilo", "12345678910", bikeShop);
        


        // Main menu loop
        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to Cyril's Bike Shop Inventory Management");
            System.out.println("1. Add Bike to Inventory");
            System.out.println("2. Delete Bike from Inventory");
            System.out.println("3. Display All Bikes in Inventory");
            System.out.println("4. == Sell a Bike == ");
            System.out.println("5. Exit");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Add Bike
                    System.out.println("------------------");
                    System.out.println("Select Bike Type:");
                    System.out.println("1. Fixed Gear");
                    System.out.println("2. Mountain Bike");
                    System.out.println("3. Road Bike");
                    System.out.print("Enter choice: ");
                    int bikeTypeChoice = scanner.nextInt();
                    scanner.nextLine(); 

                    // Get common bike details
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
                    System.out.print("Enter Bike Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); 

                    Bike newBike = null;

                    // Create specific bike type based on user's choice
                    if (bikeTypeChoice == 1) {
                        newBike = new FixedGearBikes(id,brand, model, color, frameMaterial, price);
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("Fixed Gear Bike "+ id+" , " + brand +" , "+ model +" , "+ color +" , "+ frameMaterial + " , " + price +" added in the inventory");
                    } else if (bikeTypeChoice == 2) {
                        System.out.println("-----------------------------------------------------------");
                        newBike = new MountainBikes(id,brand, model, color, frameMaterial, price);
                        System.out.println("Mountain Bike "+ id+" , " + brand +" , "+ model +" , "+ color +" , "+ frameMaterial + " , " + price +" added in the inventory");
                    } else if (bikeTypeChoice == 3) {
                        System.out.println("-----------------------------------------------------------");
                        newBike = new RoadBikes(id,brand, model, color, frameMaterial, price);
                        System.out.println("RoadBike "+ id+" , " + brand +" , "+ model +" , "+ color +" , "+ frameMaterial + " , " + price +" added in the inventory");
                    } else {
                        System.out.println("Invalid bike type choice.");
                    } 

                    // Add the bike to inventory if a valid bike was created
                    if (newBike != null) {
                        owner.getBikeShop().getInventory().addBikeToInventory(newBike);
                        System.out.println("Bike added successfully to inventory.");
                    }
                    break;

                    case 2:
                    // Delete Bike
                    System.out.println("---------------------------");
                    System.out.println("Select Bike Type to Delete:");
                    System.out.println("1. Fixed Gear");
                    System.out.println("2. Mountain Bike");
                    System.out.println("3. Road Bike");
                    System.out.print("Enter choice: ");
                    int deleteTypeChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Prompt for the ID of the bike to delete
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

                        // Assuming the Bike class has a method getId() that returns a unique identifier
                        if (matchesType && bike.getId().equals(idToDelete)) {
                            bikeToRemove = bike;
                            bikeFound = true;
                            break; // Exit the loop once the bike to delete is found
                        }
                    }

                    if (bikeFound && bikeToRemove != null) {
                        owner.getBikeShop().getInventory().removeBikeFromInventory(bikeToRemove);
                        System.out.println("----------------------------------------");
                        System.out.println("Bike with ID " + idToDelete + " removed successfully.");
                    } else {
                        System.out.println("Bike with ID " + idToDelete + " not found in the inventory.");
                    }
                    break;

                    case 3:
                     // Calculate the total number of bikes in the inventory
                     int totalBikes = owner.getBikeShop().getInventory().getBikes().size();
                     System.out.println("------------------------------------");
                     System.out.println("Inventory Name: " + inventory.getInventoryName());
                     System.out.println("Total number of bikes in inventory: " + totalBikes);


                    owner.getBikeShop().getInventory().sortBikesById();
                    System.out.println("Bikes sorted by ID!");
                    
                    // Ask user which bike type they want to display
                    System.out.println("------------------------------------");
                    System.out.println("Select the type of bikes to display:");
                    System.out.println("1. Fixed Gear Bikes");
                    System.out.println("2. Mountain Bikes");
                    System.out.println("3. Road Bikes");
                    System.out.print("Enter choice: ");
                    int displayTypeChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character after input

                    int count = 0; // Counter for the selected bike type
                
                    // Display bikes based on the selected type
                    switch (displayTypeChoice) {
                        case 1:
                           
                            System.out.println("----------------------------");
                            System.out.println("Displaying Fixed Gear Bikes:");
                            for (Bike bike : owner.getBikeShop().getInventory().getBikes()) {
                                if (bike instanceof FixedGearBikes) {
                                    // Call the overloaded method with default values
                                    ((FixedGearBikes) bike).bikeDisplay("1 gear", false);//Downcasting: ((FixedGearBikes) bike).bikeDisplay("1 gear", false); casts the bike object to FixedGearBikes to access the overloaded bikeDisplay method with parameters.
                                    count++;
                                }
                            }
                            System.out.println("Total Fixed Gear Bikes: " + count);
                            break;
                        case 2:
                            
                            System.out.println("----------------------------");
                            System.out.println("Displaying Mountain Bikes:");
                            for (Bike bike :owner.getBikeShop().getInventory().getBikes()) {
                                if (bike instanceof MountainBikes) {
                                    bike.bikeDisplay(); // Display details for Mountain bikes
                                    ((MountainBikes) bike).bikeDisplay("Full Suspension","Knobby Tyres");
                                    count++;
                                }
                            }
                            System.out.println("Total MountainBikes: " + count);
                            break;
                        case 3:
                           
                            System.out.println("----------------------------");
                            System.out.println("Displaying Road Bikes:");
                            for (Bike bike :owner.getBikeShop().getInventory().getBikes()) {
                                if (bike instanceof RoadBikes) {
                                    bike.bikeDisplay(); // Display details for Road bikes
                                    ((RoadBikes) bike).bikeDisplay("Drop Bar","Aerodynamics");
                                    count++;
                                }
                            }
                            System.out.println("Total Road Bikes: " + count);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;
                
                    case 4:
                    System.out.println("=== Sell a Bike ===");
                
                    // Ask for buyer's details
                    System.out.print("Enter Buyer's First Name: ");
                    String firstName = scanner.nextLine().trim();
                    System.out.print("Enter Buyer's Last Name: ");
                    String lastName = scanner.nextLine().trim();
                
                    Buyer buyer = new Buyer(firstName, lastName);
                
                    LinkedList<Bike> bikesToSell = new LinkedList<>();
                    boolean sellingMore = true;
                
                    // Loop for selecting bikes to sell
                    while (sellingMore) {
                        System.out.print("Enter Bike ID to Sell: ");
                        String bikeId = scanner.nextLine().trim();
                    
                        // Find bike in inventory
                        Bike bikeToSell = owner.getBikeShop().getInventory().findBikeById(bikeId);
                        if (bikeToSell == null) {
                            System.out.println("Bike with ID " + bikeId + " not found.");
                        } else {
                            bikesToSell.add(bikeToSell);
                            owner.getBikeShop().getInventory().removeBikeFromInventory(bikeToSell);
                            System.out.println("Bike added to the sale.");
                    
                            System.out.print("Sell another bike? (yes/no): ");
                            sellingMore = scanner.nextLine().equalsIgnoreCase("yes");
                        }
                    }
                
                    if (bikesToSell.isEmpty()) {
                        System.out.println("No bikes were sold. Exiting the menu.");
                        break;
                    }
                
                    double totalPrice = Payment.calculateTotalPrice(bikesToSell);
                    System.out.println("Total Price: $" + totalPrice);
                
                    // Ask for payment
                    System.out.print("Enter Payment Amount: ");
                    double paymentAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume leftover newline
                
                    if (paymentAmount < totalPrice) {
                        System.out.println("Insufficient amount. Payment failed.");
                        break;
                    }
                
                    System.out.print("Enter Order ID: ");
                    String orderId = scanner.nextLine().trim();  // Allow the user to enter their custom Order ID

                    // Prompt for other details
                    System.out.print("Enter Payment Method: ");
                    String paymentMethod = scanner.nextLine();

                    // Create the payment object
                    Payment payment = new Payment(paymentAmount, paymentMethod);

                    // Process the payment
                    if (payment.processPayment()) {
                        // Create the order with the user's custom Order ID
                        Order order = new Order(orderId, buyer, bikesToSell, payment);
                        System.out.println("Transaction successful!");
                        order.generateReceipt(); // Generate and display the receipt
                    } else {
                        System.out.println("Payment failed. Transaction could not be completed.");
                    }


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
