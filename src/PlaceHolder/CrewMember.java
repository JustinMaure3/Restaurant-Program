package PlaceHolder;
/**
 * Creates crewmember
 * @author Stefano,Max,Tomas,Justin
 *
 */
public class CrewMember extends Employee {
	//Adding private ints for managerID and their safe code
		protected int crewMemberPunchIn;
		protected int crewMemberGoldStar;
		
		
		/**
		 * Empty construct for crew member used for calling
		 */
		public CrewMember(){
			
		}
		

		/**
		 * Construct with ID used for calling
		 */
		public CrewMember(int ID, String name, double wage, String uniform, String position, int crewMemberPunchIn, int crewMemberGoldStar) {
			this.ID = ID;
			this.name = name;
			this.wage = wage;
			this.uniform = uniform;
			this.position = position;
			this.crewMemberPunchIn = crewMemberPunchIn;
			this.crewMemberGoldStar = crewMemberGoldStar;
		}
		
		/**
		 * Construct with only name an goldstar
		 */
		public CrewMember(String name, int crewMemberGoldStar) {
			this.name = name;
			this.crewMemberGoldStar = crewMemberGoldStar;
		}
		
		
		/**
		 * Construct with everything but ID
		 */
		public CrewMember(String name, double wage, String uniform, String position, int crewMemberPunchIn, int crewMemberGoldStar) {
			this.name = name;
			this.wage = wage;
			this.uniform = uniform;
			this.position = position;
			this.crewMemberPunchIn = crewMemberPunchIn;
			this.crewMemberGoldStar = crewMemberGoldStar;
		}
		
		

		//Getters and setters
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
