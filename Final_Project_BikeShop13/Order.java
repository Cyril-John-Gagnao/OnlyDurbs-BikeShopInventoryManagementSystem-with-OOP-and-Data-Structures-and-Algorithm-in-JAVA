package Final_Project_BikeShop13;

import java.util.LinkedList;

public class Order {
    private String orderId;
    private Buyer buyer;   // Many orders to 1 buyer
    private LinkedList<Bike> bikes;  // Many bikes to many orders (using LinkedList)
    private Payment payment;   // 1 payment per order
    
    public Order(String orderId, Buyer buyer, LinkedList<Bike> bikes, Payment payment) {
        this.orderId = orderId;
        this.buyer = buyer;
        this.bikes = bikes;
        this.payment = payment;    
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

    // Method to display the order details
    public void displayOrderDetails() {
        System.out.println("Order ID: " + this.orderId);
        System.out.println("Buyer: " + this.buyer.getFirstName() + " " + this.buyer.getLastName());
    }

    public void generateReceipt(LinkedList<Integer> quantitiesToSell) {
        System.out.println("----------------");
        System.out.println("=== Receipt ===");

        displayOrderDetails();

        System.out.println("Bike(s) Sold:");
        
        for (int i = 0; i < bikes.size(); i++) {
            Bike bike = bikes.get(i);
            int quantity = quantitiesToSell.get(i);

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
            
            // Display bike details along with the quantity sold
            System.out.printf("ID: %-5s | Brand: %-10s | Model: %-8s | Color: %-7s | Frame Material: %-5s | Size: %-5s | Price: $%-8.2f | Quantity Sold: %-5d | Total: $%-8.2f | Category: %-15s\n",
                              bike.getId(),
                              bike.getBrand(),
                              bike.getModel(),
                              bike.getColor(),
                              bike.getFrameMaterial(),
                              bike.getSize(),
                              bike.getPrice(),
                              quantity,
                              bike.getPrice() * quantity,  // Display total price for sold quantity
                              category);
        }
        
        double totalPrice = Payment.calculateTotalPrice(bikes, quantitiesToSell);
        System.out.println("--------------------------------------------");
        System.out.println("Total Price: $" + totalPrice);
        payment.displayPaymentInformation();
        double change = payment.calculateChange(totalPrice);
        System.out.println("Change: $" + change);
        System.out.println("-------------------------------------------------------------");
    }
}
