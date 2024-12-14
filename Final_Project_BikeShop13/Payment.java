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
        this.paymentDate = new Date(); 
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

    public void displayPaymentInformation() {
        System.out.println("Payment Amount: $" + paymentAmount);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Payment Date: " + paymentDate);
    }
  
    public double calculateChange(double bikePrice) {
        if (paymentAmount >= bikePrice) {
            double change = paymentAmount - bikePrice;
            return change;
        } else {
            System.out.println("Insufficient payment. No change can be given.");
            return 0;  
        }
    }

    public static double calculateTotalPrice(LinkedList<Bike> bikesToSell, LinkedList<Integer> quantitiesToSell) {
        double totalPrice = 0;
        for (int i = 0; i < bikesToSell.size(); i++) {
            Bike bike = bikesToSell.get(i);
            int quantity = quantitiesToSell.get(i);
            totalPrice += bike.getPrice() * quantity; // Multiply price by quantity
        }
        return totalPrice;
    }
      
}