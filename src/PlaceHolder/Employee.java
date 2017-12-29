package PlaceHolder;

public class Employee {
//The basic requirements to be a employee
	//ID,NAME,WAGE,UNIFORM
	private int ID;
	private String name;
	private double wage;
	private String uniform;
	private String position;
	
	//Empty constructor for emplyee
	public Employee() {
		
	}
	
	//Employee constructor with ID
	public Employee(int ID, String name, double wage, String uniform, String position) {
		this.ID = ID;
		this.name = name;
		this.wage = wage;
		this.uniform = uniform;
		this.position = position;
	}
	
	//Employee constructor without ID
	public Employee(String name, double wage, String uniform, String position) {
		this.name = name;
		this.wage = wage;
		this.uniform = uniform;
		this.position = position;
	}
	
	//Getters and setters for employee
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	public String getUniform() {
		return uniform;
	}
	public void setUniform(String uniform) {
		this.uniform = uniform;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
