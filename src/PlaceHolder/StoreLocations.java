package PlaceHolder;

public class StoreLocations {
	//Location, Sanatation score, RegionalManager, customerReview
	private int ID;
	private String location;
	private int santScore;
	private String regionalMan;
	private int custReview;
	
	//Empty construct for store locations
		public StoreLocations() {
			
		}
		
		//Store locations constructor constructor with ID
		public StoreLocations(int ID, String location, String regionalMan, int custReview, int santScore) {
			this.ID = ID;
			this.location = location;
			this.santScore = santScore;
			this.regionalMan = regionalMan;
			this.custReview = custReview;
		}
		
		//Store locations constructor without ID
		public StoreLocations( String location, String regionalMan, int custReview, int santScore) {
			this.location = location;
			this.santScore = santScore;
			this.regionalMan = regionalMan;
			this.custReview = custReview;
		}
		
		
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getSantScore() {
		return santScore;
	}
	public void setSantScore(int santScore) {
		this.santScore = santScore;
	}
	public String getRegionalMan() {
		return regionalMan;
	}
	public void setRegionalMan(String regionalMan) {
		this.regionalMan = regionalMan;
	}
	public int getCustReview() {
		return custReview;
	}
	public void setCustReview(int custReview) {
		this.custReview = custReview;
	}
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
