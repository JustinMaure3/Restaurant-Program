package PlaceHolder;

public class Employee {
//The basic requirements to be a employee
	//ID,NAME,WAGE,UNIFORM
	protected int ID;
	protected String name;
	protected double wage;
	protected String uniform;
	protected String position;
	protected int punchInID;
	protected Boolean hasGoldStar;
	
	//Create a constructor
	public Employee(String name, Double wage, String uniform, String position, int punchInID, Boolean hasGoldStar) {
		this.name = name;
		this.wage = wage;
		this.uniform = uniform;
		this.position = position;
		this.punchInID = punchInID;
		this.hasGoldStar = hasGoldStar;
	}
	//Temporary constructor with out goldstar
	public Employee(String name, Double wage, String uniform, String position, int punchInID) {
		this.name = name;
		this.wage = wage;
		this.uniform = uniform;
		this.position = position;
		this.punchInID = punchInID;
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
