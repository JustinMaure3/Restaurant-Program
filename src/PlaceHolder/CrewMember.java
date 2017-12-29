package PlaceHolder;

public class CrewMember extends Employee {
	//Adding private ints for managerID and their safe code
		private int crewMemberPunchIn;
		private int crewMemberGoldStar;
		
		//Manager constructor with ID
		public CrewMember(int ID, String name, double wage, String uniform, String position, int crewMemberPunchIn, int crewMemberGoldStar) {
			this.ID = ID;
			this.name = name;
			this.wage = wage;
			this.uniform = uniform;
			this.position = position;
			this.crewMemberPunchIn = crewMemberPunchIn;
			this.crewMemberGoldStar = crewMemberGoldStar;
		}
		//Manager constructor without ID
		public CrewMember(String name, double wage, String uniform, String position, int crewMemberPunchIn, int crewMemberGoldStar) {
			this.name = name;
			this.wage = wage;
			this.uniform = uniform;
			this.position = position;
			this.crewMemberPunchIn = crewMemberPunchIn;
			this.crewMemberGoldStar = crewMemberGoldStar;
		}
}
