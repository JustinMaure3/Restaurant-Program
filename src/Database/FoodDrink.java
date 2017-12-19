package Database;

public class FoodDrink {
	//The basic requirements to be a "Food/Drink"
	private String name;
	private String description;
	private String picture;
	private int price;
	
	public FoodDrink(String name, int price, String description, String picture){
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.price = price;
	}
	
	//Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
