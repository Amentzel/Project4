package proj4;

public class Property {
	private String propertyName, city, owner;
	private double rentAmount;
	private Plot propertyPlot;
	
	public Property() {
		this.propertyName = "";
		this.city = "";
		this.owner = "";
		this.rentAmount = 0;
		this.propertyPlot = new Plot();	
	}
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		this.propertyPlot = new Plot();
	}
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.owner = owner;
		this.rentAmount = rentAmount;
		this.propertyPlot = new Plot(x,y,width, depth);
	}
	public Property(Property other) {
		this.propertyName = other.getPropertyName();
		this.city = other.getCity();
		this.owner = other.getOwner();
		this.rentAmount = other.getRentAmount();
		this.propertyPlot = new Plot (other.getPlot());
	}
	
	
	
	public String getPropertyName() {
		return propertyName;
	}
	public String getCity() {
		return city;
	}
	public String getOwner() {
		return owner;
	}
	public double getRentAmount() {
		return rentAmount;
	}
	public Plot getPlot() {
		return propertyPlot;
	}
	
	public String toString() {
		return ("Property Name: " + propertyName + ". City: " + city + ". Owner: " + owner + "Rent Amount: " + rentAmount);
	}
	
}
