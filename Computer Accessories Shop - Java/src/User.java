import java.util.ArrayList;

public class User {
	public ArrayList<Stock> basket_list = new ArrayList<Stock>();
	public ArrayList<Integer> barcode = new ArrayList<Integer>();
	
	public Double payment;
	
	int userid;
	String username;
	String name;
	int house;
	String postcode;
	String city;
	String role;
	
	public User(int userid, String username, String name, int house, String postcode, String city, String role) {
		super();
		this.userid = userid;
		this.username = username;
		this.name = name;
		this.house = house;
		this.postcode = postcode;
		this.city = city;
		this.role = role;
		this.payment = 0.0;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public int getuserid() {
		return userid;
	}

	public void setuserid(int ui) {
		this.userid = ui;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String un) {
		this.username = un;
	}

	public String getname() {
		return name;
	}

	public void setname(String n) {
		this.name = n;
	}

	public int gethouse() {
		return house;
	}

	public void sethouse(int h) {
		this.house = h;
	}

	public String getpostcode() {
		return postcode;
	}

	public void setpostcode(String pc) {
		this.postcode = pc;
	}

	public String getcity() {
		return city;
	}

	public void setcity(String c) {
		this.city = c;
	}

	public String getrole() {
		return role;
	}

	public void setrole(String r) {
		this.role = r;
	}
}
