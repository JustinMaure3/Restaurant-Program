package PlaceHolder;
/**
 * Creates Manager
 * @author Stefano,Max,Tomas,Justin
 *
 */
public class Manager extends Employee {
	//Adding private ints for managerID and their safe code
	protected int managerID;
	protected int managerSafeCode;
	
	//Empty construct for manager
	public Manager() {
		
	}
	
	//Manager constructor with ID
	public Manager(int ID, String name, double wage, String uniform, String position, int managerID, int managerSafeCode) {
		this.ID = ID;
		this.name = name;
		this.wage = wage;
		this.uniform = uniform;
		this.position = position;
		this.managerID = managerID;
		this.managerSafeCode = managerSafeCode;
	}
	//Manager constructor without ID
	public Manager(String name, double wage, String uniform, String position, int managerID, int managerSafeCode) {
		this.name = name;
		this.wage = wage;
		this.uniform = uniform;
		this.position = position;
		this.managerID = managerID;
		this.managerSafeCode = managerSafeCode;
	}
	
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	public int getManagerSafeCode() {
		return managerSafeCode;
	}
	public void setManagerSafeCode(int managerSafeCode) {
		this.managerSafeCode = managerSafeCode;
	}
	
	
}
