package PlaceHolder;

public class Manager extends Employee {
	//Adding private ints for managerID and their safe code
	private int managerID;
	private int managerSafeCode;
	
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
	public Manager(String name, double wage, String uniform, String position) {
		this.name = name;
		this.wage = wage;
		this.uniform = uniform;
		this.position = position;
		this.managerID = managerID;
		this.managerSafeCode = managerSafeCode;
	}
}
