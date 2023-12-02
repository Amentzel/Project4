package proj4;

public class ManagementCompany {
	static final int MAX_PROPERTY = 5;
	static final int MGMT_DEPTH = 10;
	static final int MGMT_WIDTH = 10;
	
	private String name, taxID;
	private double mgmFee;
	private Plot plot;
	private Property[] properties;
	private int numberOfProperties = 0;
	
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.mgmFee = 0;
		this.plot = new Plot(MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(x,y,width,depth);
		properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.getName();
		this.taxID = otherCompany.getTaxID();
		this.mgmFee = otherCompany.getMgmFee();
		this.plot = otherCompany.getPlot();
		this.properties = otherCompany.getProperties();
	}
	
	public String getName() {
		return name;
	}
	public String getTaxID() {
		return taxID;
	}
	public double getMgmFee() {
		return mgmFee;
	}
	public Plot getPlot() {
		return plot;
	}
	public Property[] getProperties() {
		return properties;
	}
	public int getPropertiesCount() {
		return numberOfProperties;
	}
	public double getTotalRent() {
		double total = 0;
		for (int i = 0; i<numberOfProperties; i++) {
			total+= properties[i].getRentAmount();
		}
		return total;
	}
	public int addProperty(String name, String city, double rent, String owner) {
		Property newProp = new Property(name, city, rent, owner);
		Plot P = getPlot();
		if (numberOfProperties == MAX_PROPERTY) {
			return -1;
		}
		if (!P.encompasses(newProp.getPlot())) {
			return -3;
		}
		for (int i = 0; i<numberOfProperties; i++) {
			if (newProp.getPlot().overlap(properties[i].getPlot())){
				return -4;
			}
		}
		properties[numberOfProperties] = newProp;
		
		return numberOfProperties++;
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int height) {
		Property newProp = new Property(name, city, rent, owner, x, y, width, height);
		Plot managerPlot = getPlot();
		if (numberOfProperties == MAX_PROPERTY) {
			return -1;
		}
		if (!managerPlot.encompasses(newProp.getPlot())) {
			return -3;
		}
		for (int i = 0; i<numberOfProperties; i++) {
			if (newProp.getPlot().overlap(properties[i].getPlot())){
				return -4;
			}
		}
		properties[numberOfProperties] = newProp;
		
		return numberOfProperties++;
	}
	
	public int addProperty(Property P) {
		Property newProp = new Property(P);
		Plot managerPlot = getPlot();
		if (numberOfProperties == MAX_PROPERTY) {
			return -1;
		}
		if (P == null) {
			return -2;
		}
		if (!managerPlot.encompasses(newProp.getPlot())) {
			return -3;
		}
		for (int i = 0; i<numberOfProperties; i++) {
			if (newProp.getPlot().overlap(properties[i].getPlot())){
				return -4;
			}
		}
		properties[numberOfProperties] = newProp;
		
		return numberOfProperties++;
	}
	public void removeLastProperty() {
		properties[numberOfProperties-1] = null; 
	}
	
	public boolean isPropertiesFull() {
		return (numberOfProperties == MAX_PROPERTY);
	}
	public Property getHighestRentProperty() {
		int index = 0;
		double dummyRent= properties[0].getRentAmount();
		for (int i = 0; i<numberOfProperties; i++) {
			if (properties[i].getRentAmount() > dummyRent) {
				dummyRent = properties[i].getRentAmount();
				index = i;
			}
		}
		return properties[index];
	}
	
	public boolean isManagementFeeValid() {
		return ((mgmFee < 0) && (mgmFee > 100));
	}
	
	public String toString() {
		String message= "List of properties for: " + name + ", TaxID : " + taxID
						+ "\n ______________________________________________________\n";
		for (int i = 0; i < numberOfProperties; i++) {
			message += properties[i].toString();
			message += "\n";
		}
		double totalRent = getTotalRent()*mgmFee/100; 
		message += "Total Management Fee" + totalRent; 
		return message;
	}
	
}
