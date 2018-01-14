package PlaceHolder;
/**
 * Creates Employee
 * @author Stefano,Max,Tomas,Justin
 *
 */
public class Employee {
//The basic requirements to be a employee
	//ID,NAME,WAGE,UNIFORM
	protected int ID;
	protected String name;
	protected double wage;
	protected String uniform;
	protected String position;
	
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
