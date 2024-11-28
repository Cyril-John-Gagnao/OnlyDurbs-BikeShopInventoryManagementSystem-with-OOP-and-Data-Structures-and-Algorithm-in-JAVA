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
        System.out.println("Bikes in the Order:");
        for (Bike bike : bikes) {
            bike.bikeDisplay();  // Display details of each bike
        }
        payment.displayPaymentInfo(); 
    }

        // Method to generate and display the receipt
    public void generateReceipt() {
        System.out.println("----------------");
        System.out.println("=== Receipt ===");
        System.out.println("Order ID: " + orderId);
        System.out.println("Buyer: " + buyer.getFirstName() + " " + buyer.getLastName());
        System.out.println("Bike(s) Sold:");
        for (Bike bike : bikes) {
            bike.bikeDisplay(); 
        }
        System.out.println("Payment Amount: $" + payment.getpaymentAmount());
        // Calculate total price using a for-each loop
        double totalPrice = 0;
        for (Bike bike : bikes) {
            totalPrice += bike.getPrice(); // Sum up the prices of all bikes in the order
        }
        double change = payment.calculateChange(totalPrice);
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Change: $" + change);
        System.out.println("Payment Method: " + payment.getPaymentMethod());
        System.out.println("Payment Date: " + payment.getPaymentDate());
        System.out.println("-------------------------------------------------------------");
    }
}
