package PlaceHolder;

public class StoreLocations {
	//Location, Sanatation score, RegionalManager, customerReview
	protected String location;
	protected int santScore;
	protected String regionalMan;
	protected int custReview;
	
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

}
