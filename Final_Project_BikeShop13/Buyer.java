package Final_Project_BikeShop13;

import java.util.LinkedList;

public class Buyer {
    private String firstName;
    private String lastName;
    private LinkedList<Order> orders;  // Bikes the buyer has purchased

   
    public Buyer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = new LinkedList<>();
    }

    // Method to add an order
    public void addOrder(Order order) {
        orders.add(order);
    }

   
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LinkedList<Order> getOrders() {
        return orders;
    }


    // Method to display all orders of the buyer
    public void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println(firstName + " " + lastName + " has not placed any orders.");
        } else {
            System.out.println(firstName + " " + lastName + "'s Orders:");
            for (Order order : orders) {
                order.displayOrderDetails();  
            }
        }
    }

  
}
