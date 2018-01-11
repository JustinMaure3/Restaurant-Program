package DAO;
import java.util.ArrayList;
import PlaceHolder.CrewMember;

public interface CrewMemberDAO {
		//Everything we want to do with the table
		public ArrayList<CrewMember> getAllCrewMembers();
		//Get 1
		public CrewMember getCrewMember(String crewMemberName);
		//Update
		public void updateCrewMember(CrewMember crewMember);
		//Delete
		public void deleteCrewMember(CrewMember crewMember);;
		//Create
		public void createCrewMember(CrewMember crewMember);
		//Gets the employee with the most stars
		CrewMember getEmployeeOfMonthk(int goodStars);
}

