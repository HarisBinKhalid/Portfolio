import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

public class Basket extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Basket frame = new Basket();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void purchase(int id, ReadFiles rf, int[] count_list) throws IOException{
		List<Stock> temp = new ArrayList<Stock>(rf.stock_list);
		
		for (int i = 0; i < rf.stock_list.size(); i++) {
			
			for (int j = 0; j < rf.users_list.get(id).barcode.size(); j++) {
				if(rf.stock_list.get(i).getBarcode() == rf.users_list.get(id).barcode.get(j)) {
					int quantity = temp.get(i).getQuantity();
					quantity -= count_list[i];
					temp.get(i).setQuantity(quantity);
					count_list[i] = 0;
				}
			}
		}
		
		File file = new File("Stock.txt");
		file.delete();
		
		String filename= "Stock.txt";
	    FileWriter fw = new FileWriter(filename,true);
	    
	    for (int i = 0; i < temp.size(); i++) {
	    	fw.write(temp.get(i).getBarcode() + ", " + temp.get(i).getDevicename() + ", " + temp.get(i).getDevicetype() + ", " + temp.get(i).getBrand() + ", " + temp.get(i).getColor() + ", " + temp.get(i).getConnectivivty() + ", " + temp.get(i).getQuantity() + ", " + temp.get(i).getCost() + ", " +  temp.get(i).getPrice() + ", " + temp.get(i).getInformation());
	    	if (i < temp.size() - 1) {
	    		fw.write("\n");
	    	}
	    }
	    
	    fw.close();
	}

	/**
	 * Create the frame.
	 */
	public Basket(int id, ReadFiles rf, int[] count_list) {
		JFrame f;
		JTable tbl = new JTable();
		f = new JFrame();
		tbl.setBounds(30, 40, 0, 300);
		
		List<Stock> temp1 = new ArrayList<Stock>(rf.users_list.get(id).basket_list);
		List<Stock> sorted = new ArrayList<Stock>();
		
		double min = 0;
		int size = temp1.size();
		int index = 0;
		
		for (int i = 0; i < size; i++) {
			min = temp1.get(0).getPrice();
			index = 0;
			for (int j = 0; j < temp1.size(); j++) {
				if (min > temp1.get(j).getPrice()) {
					min = temp1.get(j).getPrice();
					index = j;
				}
			}
			sorted.add(temp1.get(index));
			temp1.remove(index);
		}
		
		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		String header[] = new String[] { "Bar code", "Device Name", "Device Type", "Brand", "Color", "Connectivity", "Quantity", "Price", "Information" };
		tbl.getTableHeader().setBackground(Color.LIGHT_GRAY);
		dtm.setColumnIdentifiers(header);
		tbl.setModel(dtm);
		
		for (int i = 0; i < sorted.size(); i++) {
	        dtm.addRow(new Object[] { sorted.get(i).getBarcode(), sorted.get(i).getDevicename(), sorted.get(i).getDevicetype(), sorted.get(i).getBrand(), sorted.get(i).getColor(), sorted.get(i).getConnectivivty(), sorted.get(i).getQuantity(), sorted.get(i).getPrice(), sorted.get(i).getInformation() });
		}
		f.getContentPane().setLayout(null);
		JScrollPane sp = new JScrollPane(tbl);
		sp.setBounds(0, 0, 735, 199);
		sp.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Shopping Basket", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		f.getContentPane().add(sp);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				Usermenu am = new Usermenu(id, rf, count_list);
			}
		});
		back.setBounds(10, 204, 89, 23);
		f.getContentPane().add(back);
		
		JButton clean = new JButton("Clear");
		clean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rf.users_list.get(id).basket_list.clear();
				
				for (int i = 0; i < count_list.length; i++) {
					count_list[i] = 0;
				}
				
				f.dispose();
		        Basket bk = new Basket(id, rf, count_list);
			}
		});
		clean.setBounds(636, 204, 89, 23);
		f.getContentPane().add(clean);
		
		JRadioButton creditcard = new JRadioButton("Credit Card");
		creditcard.setBounds(166, 204, 89, 23);
		f.getContentPane().add(creditcard);
		
		JRadioButton paypal = new JRadioButton("Paypal");
		paypal.setBounds(497, 204, 72, 23);
		f.getContentPane().add(paypal);
		
		ButtonGroup BG = new ButtonGroup();
		BG.add(creditcard);
		BG.add(paypal);
		
		JButton buy = new JButton("Buy");
		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rf.users_list.get(id).basket_list.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Basket empty", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if (creditcard.isSelected()) {
						String cardnumber = JOptionPane.showInputDialog(f,"Enter Card Number", "Credit Card", JOptionPane.INFORMATION_MESSAGE);
						try {
							int cardnum = Integer.parseInt(cardnumber);
							int length1 = String.valueOf(cardnum).length();
							if (length1 != 6) {
								JOptionPane.showMessageDialog(null, "Enter 6 digits", "Error", JOptionPane.ERROR_MESSAGE);
							}
							else {
								String securitynumber = JOptionPane.showInputDialog(f,"Enter card Security Number", "Credit Card", JOptionPane.INFORMATION_MESSAGE);
								try {
									int securitynum = Integer.parseInt(securitynumber);
									int length2 = String.valueOf(securitynumber).length();
									if (length2 != 3) {
										JOptionPane.showMessageDialog(null, "Enter 3 digits", "Error", JOptionPane.ERROR_MESSAGE);
									}
									else {
										try {
											purchase(id, rf, count_list);
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										rf.users_list.get(id).basket_list.clear();
										
										for (int i = 0; i < count_list.length; i++) {
											count_list[i] = 0;
										}
										
										JOptionPane.showMessageDialog(null, rf.users_list.get(id).getPayment() + " paid with Credit Card, to delivery address House - " + rf.users_list.get(id).gethouse() + ", Postcode - " + rf.users_list.get(id).getpostcode() + ", City - " + rf.users_list.get(id).getcity(), "Complete", JOptionPane.INFORMATION_MESSAGE);
										f.dispose();
								        Basket bk = new Basket(id, rf, count_list);
									}
								}
								catch (NumberFormatException e1) {
									JOptionPane.showMessageDialog(null, "Only numric accepted", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
						catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Only numric accepted", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						
					}
					else if (paypal.isSelected()) {
						String email = JOptionPane.showInputDialog(f,"Enter Email", "Paypal", JOptionPane.INFORMATION_MESSAGE);
						if (!email.contains("@") || !email.contains(".com")) {
							JOptionPane.showMessageDialog(null, "Enter correct email", "Error", JOptionPane.ERROR_MESSAGE);
						}
						else {
							try {
								purchase(id, rf, count_list);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							rf.users_list.get(id).basket_list.clear();
							
							for (int i = 0; i < count_list.length; i++) {
								count_list[i] = 0;
							}
							
							JOptionPane.showMessageDialog(null, rf.users_list.get(id).getPayment() + " paid with Paypal, to delivery address House - " + rf.users_list.get(id).gethouse() + ", Postcode - " + rf.users_list.get(id).getpostcode() + ", City - " + rf.users_list.get(id).getcity(), "Complete", JOptionPane.INFORMATION_MESSAGE);
							f.dispose();
					        Basket bk = new Basket(id, rf, count_list);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Select payment method", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		buy.setBounds(326, 204, 89, 23);
		f.getContentPane().add(buy);
		
		f.setSize(751, 277);
		f.setVisible(true);
		
	}
}
