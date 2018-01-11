package PlaceHolder;

public class CrewMember extends Employee {
	//Adding private ints for managerID and their safe code
		protected int crewMemberPunchIn;
		protected int crewMemberGoldStar;
		
		
		public CrewMember(){
			
		}
		

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
		
		//Constructor for crewmember with only name and gold stars
		public CrewMember(String name, int crewMemberGoldStar) {
			this.name = name;
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
		
		

		
		public int getCrewMemberPunchIn() {
			return crewMemberPunchIn;
		}


		public void setCrewMemberPunchIn(int crewMemberPunchIn) {
			this.crewMemberPunchIn = crewMemberPunchIn;
		}


		public int getCrewMemberGoldStar() {
			return crewMemberGoldStar;
		}


		public void setCrewMemberGoldStar(int crewMemberGoldStar) {
			this.crewMemberGoldStar = crewMemberGoldStar;
		}

}
