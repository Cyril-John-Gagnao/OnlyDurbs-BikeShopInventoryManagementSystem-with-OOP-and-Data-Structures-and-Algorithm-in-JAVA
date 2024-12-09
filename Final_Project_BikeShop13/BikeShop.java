package Final_Project_BikeShop13;

public class BikeShop {
    private String name;
    private String address;
    private Inventory inventory;
    private BikeShopOwner owner;

    public BikeShop(String name, String address,Inventory inventory, BikeShopOwner owner) {
        this.name = name;
        this.address = address;
        this.inventory = inventory; // Initialize inventory
        this.owner = owner; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    

    public void setOwner(BikeShopOwner owner) {
        this.owner = owner;
    }

    public BikeShopOwner getOwner() {
        return owner;
    }

    public Inventory getInventory() {
        return inventory;
    }
   
    public void display() {
        System.out.println("-----------------------");
        System.out.println("DETAILS OF THE BIKESHOP");
		System.out.println("Name: " + this.name);
		System.out.println("Address: " + this.address);
        System.out.println("Owner: " + owner.getFullName());
        System.out.println("-----------------------");
        
	}
   
}
