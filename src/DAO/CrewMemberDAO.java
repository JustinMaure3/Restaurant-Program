package DAO;
import java.util.ArrayList;
import PlaceHolder.CrewMember;

public interface CrewMemberDAO {
		//Everything we want to do with the table
	/**
	 * This grabs all the CrewMember items
	 */
		public ArrayList<CrewMember> getAllCrewMembers();
		/**
		 * This gets one CrewMember item
		 */
		public CrewMember getCrewMember(String crewMemberName);
		/**
		 * This updates CrewMember item
		 */
		public void updateCrewMember(CrewMember crewMember);
		/**
		 * This deletes CrewMember item
		 */
		public void deleteCrewMember(CrewMember crewMember);;
		/**
		 * This creates CrewMember 
		 */
		public void createCrewMember(CrewMember crewMember);
		/**
		 * This grabs the top CrewMember
		 */
		CrewMember getEmployeeOfMonthk(int goodStars);
}

