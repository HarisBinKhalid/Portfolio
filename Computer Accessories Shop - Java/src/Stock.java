
public class Stock {
	int barcode;
	String devicename;
	String devicetype;
	String brand;
	String color;
	String connectivivty;
	int quantity;
	double cost;
	double price;
	String information;
	
	
	
	public Stock(int barcode, String devicename, String devicetype, String brand, String color, String connectivivty,
			int quantity, double cost, double price, String information) {
		super();
		this.barcode = barcode;
		this.devicename = devicename;
		this.devicetype = devicetype;
		this.brand = brand;
		this.color = color;
		this.connectivivty = connectivivty;
		this.quantity = quantity;
		this.cost = cost;
		this.price = price;
		this.information = information;
	}
	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	public String getDevicename() {
		return devicename;
	}
	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}
	public String getDevicetype() {
		return devicetype;
	}
	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getConnectivivty() {
		return connectivivty;
	}
	public void setConnectivivty(String connectivivty) {
		this.connectivivty = connectivivty;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
}
