package Final_Project_BikeShop13;


public class BikeShopOwner {
    private String firstName;
    private String lastName;
    private String address;
    private String contactNo;
    private BikeShop bikeShop;

    public BikeShopOwner(String firstName, String lastName, String address, String contactNo, BikeShop bikeShop) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactNo = contactNo;
        this.bikeShop = bikeShop; 
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getFullName() {
		return this.lastName + ", " + this.firstName;
	}

    public String ownerName() {
        return getFullName();
    }

    public BikeShop getBikeShop() {
        return bikeShop;
    }

    public void display() {
        System.out.println("DETAILS OF THE BIKESHOP OWNER");
		System.out.println("Owner Name: " + this.getFullName());
		System.out.println("Owner Address: " + this.address);
		System.out.println("Owner Contact No: " + this.contactNo);   
	}
   
}
