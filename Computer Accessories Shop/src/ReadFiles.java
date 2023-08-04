import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFiles {
	public static ArrayList<User> users_list = new ArrayList<User>();
	public static ArrayList<Stock> stock_list = new ArrayList<Stock>();
	public static ArrayList<Stock> found_list = new ArrayList<Stock>();
	
	ReadFiles() {
		
		users_list.clear();
		stock_list.clear();
		readUsers();
		readStock();
	}
	
	public void readUsers() { 
		
		try {
		        BufferedReader br = new BufferedReader(new FileReader("UserAccounts.txt"));
		        String line;
		        while ((line = br.readLine())!= null) {
		        	String [] parts = line.split(", ");
		        	users_list.add(new User(Integer.parseInt(parts[0]), parts[1], parts[2], Integer.parseInt(parts[3]), parts[4], parts[5], parts[6]));
		        	
		        }
		        br.close();
		    } catch (IOException e) {
		        System.out.println("User accounts file Read Error");
		    }
		
	}
	public void readStock() { 
		
		try {
		        BufferedReader br = new BufferedReader(new FileReader("Stock.txt"));
		        String line;
		        while ((line = br.readLine())!= null) {
		        	String [] parts = line.split(", ");
		        	
		        	stock_list.add(new Stock(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], parts[5], Integer.parseInt(parts[6]), Double.parseDouble(parts[7]), Double.parseDouble(parts[8]), parts[9]));
		        	
		        }
		        br.close();
		    } catch (IOException e) {
		        System.out.println("Stocks file Read Error");
		    }
		
	}
	
	
}
