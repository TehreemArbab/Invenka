package businesslogic;

public class OrderTracking {
	private int id;
	private String departure;
	private String Arrival;
	private String Status;
	private int TotalDays;
	

	public OrderTracking(int id, String departure, String arrival, int tot) {
		this.id=id;
		this.departure= departure;
		this.Arrival= arrival;
		this.TotalDays= tot;
		
	}

	
	
	
	public int getTotalDays() {
		return TotalDays;
	}




	public void setTotalDays(int totalDays) {
		TotalDays = totalDays;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return Arrival;
	}

	public void setArrival(String arrival) {
		Arrival = arrival;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	

	

}
