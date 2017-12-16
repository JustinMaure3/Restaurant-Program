package PlaceHolder;

public class FoodDrink {
	//The basic requirements to be a "Food/Drink"
	private int ID;
	private String name;
	private int rating;
	private String description;
	private String picture;
	private double price;
	
	//Empty constructor 
	public FoodDrink() {
		
	}
	//Food and drink constructor with ID
	public FoodDrink(int ID, String name, int rating, String description, String picture) {
		this.ID = ID;
		this.name = name;
		this.rating = rating;
		this.description = description;
		this.picture = picture;
	}
	//Food and drink constructor without id
	public FoodDrink(String name, int rating, String description, String picture) {
		this.name = name;
		this.rating = rating;
		this.description = description;
		this.picture = picture;
	}
	
	//Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
}
