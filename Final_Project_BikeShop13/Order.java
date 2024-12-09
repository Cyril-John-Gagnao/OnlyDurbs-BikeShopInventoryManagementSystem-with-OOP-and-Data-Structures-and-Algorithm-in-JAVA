package Final_Project_BikeShop13;

import java.util.LinkedList;

public class Order {
    private String orderId;
    private static int orderCounter = 0; 
    private Buyer buyer;   
    private LinkedList<Bike> bikes;  
    private Payment payment;  
    private BikeShop bikeShop; 
    
    public Order( Buyer buyer, LinkedList<Bike> bikes, Payment payment, BikeShop bikeShop) {
        this.orderId = generateOrderId();
        this.buyer = buyer;
        this.bikes = bikes;
        this.payment = payment; 
        this.bikeShop = bikeShop;  
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public LinkedList<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(LinkedList<Bike> bikes) {
        this.bikes = bikes;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public BikeShop getBikeShop() {
        return bikeShop;
    }

    public void setBikeShop(BikeShop bikeShop) {
        this.bikeShop = bikeShop;
    }

    // Method to generate a unique order ID
    private static String generateOrderId() {
        orderCounter++; 
        return "ORD" + orderCounter; 
    }

    // Method to display the order details
    public void displayOrderDetails() {
        System.out.println("Order ID: " + this.orderId);
        System.out.println("Buyer: " + this.buyer.getFirstName() + " " + this.buyer.getLastName());
    }

    public void generateReceipt(LinkedList<Integer> quantitiesToSell) {
        System.out.println("-----------------------");
        System.out.println("=== Receipt ===");
        bikeShop.display();
        displayOrderDetails();
    
        System.out.println("Bike(s) Sold Details:");
        
        for (int i = 0; i < bikes.size(); i++) {
            Bike bike = bikes.get(i);
            int quantity = quantitiesToSell.get(i);
    
            // Determine the category and specific attributes of the bike
            String category;
            String specificAttributes = "";
    
            if (bike instanceof FixedGearBikes) {
                category = "Fixed Gear";
                FixedGearBikes fixedGearBike = (FixedGearBikes) bike;
                specificAttributes = String.format("Gear Ratio: %s, Brakes: %s",
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

            System.out.println("-----------------------");
            System.out.println("Bike ID: " + bike.getId());
            System.out.println("Bike Brand: " + bike.getBrand());
            System.out.println("Bike Model: " + bike.getModel());
            System.out.println("Bike Color: " + bike.getColor());
            System.out.println("Frame Material: " + bike.getFrameMaterial());
            System.out.println("Bike Size: " + bike.getSize());
            System.out.println("Bike Price: $" + String.format("%.2f", bike.getPrice()));
            System.out.println("Quantity Sold: " + quantity);
            System.out.println("Total Price: $" + String.format("%.2f", bike.getPrice() * quantity));
            System.out.println("Category: " + category);
            System.out.println("Specific Attributes: " + specificAttributes);
        }
            
        double totalPrice = Payment.calculateTotalPrice(bikes, quantitiesToSell);
        System.out.println("--------------------------------------------");
        System.out.println("Total Price for bike(s) sold: $" + totalPrice);
        payment.displayPaymentInformation();
        double change = payment.calculateChange(totalPrice);
        System.out.println("Change: $" + change);
        System.out.println("---------------------------------------------");
    }

}

