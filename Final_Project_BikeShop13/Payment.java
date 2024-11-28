package Final_Project_BikeShop13;

import java.util.Date;
import java.util.LinkedList;


public class Payment {
    private double paymentAmount;
    private String paymentMethod; 
    private Date paymentDate;

   
    public Payment(double paymentAmount, String paymentMethod) {
        this.paymentAmount = paymentAmount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = new Date(); // Use the current date/time as the payment date
    }

    
    public double getpaymentAmount() {
        return paymentAmount;
    }

    public void setpaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    
    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    // Method to display payment details
    public void displayPaymentInfo() {
        System.out.println("Payment Details:");
        System.out.println("Amount: $" + paymentAmount);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Payment Date: " + paymentDate);
    }

    // Method to process the payment 
    public boolean processPayment() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Processing payment of $" + paymentAmount + " through " + paymentMethod);
        return true;  
    }

    // Method to calculate the change
    public double calculateChange(double bikePrice) {
        if (paymentAmount >= bikePrice) {
            double change = paymentAmount - bikePrice;
            return change;
        } else {
            System.out.println("Insufficient payment. No change can be given.");
            return 0;  // No change if the payment is insufficient
        }
    }

    // Method to calculate total price for a list of bikes
    public static double calculateTotalPrice(LinkedList<Bike> bikesToSell) {
        double totalPrice = 0;
        for (Bike bike : bikesToSell) {
            totalPrice += bike.getPrice();
        }
        return totalPrice;
    }

      
}

