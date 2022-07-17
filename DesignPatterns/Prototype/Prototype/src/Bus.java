
public class Bus extends Vehicle{

	private int noOfSheets;

	public int getNoOfSheets() {
		return noOfSheets;
	}

	public void setNoOfSheets(int noOfSheets) {
		this.noOfSheets = noOfSheets;
	}

	@Override
	public String toString() {
		return "Bus [noOfSheets=" + noOfSheets + "]";
	}
	
	
}
