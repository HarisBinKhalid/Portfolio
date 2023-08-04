import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Adminmenu extends JFrame {
	ReadFiles rf = new ReadFiles();
	private JTable table;
	private JTextField barcode;
	private JTextField devicename;
	private JTextField devicetype;
	private JTextField brand;
	private JTextField connectivity;
	private JTextField color;
	private JTextField quantity;
	private JTextField cost;
	private JTextField price;
	private JTextField info;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Adminmenu frame = new Adminmenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Adminmenu() {
		JFrame f;
		JTable tbl = new JTable();
		f = new JFrame();
		tbl.setBounds(30, 40, 0, 300);
		//String[][] data = { { Integer.toString(rf.stock_list.get(0).getBarcode()), "b", "c", "d", "e", "f", "g", "h", "i" }, { "a", "b", "c", "d", "e", "f", "g", "h", "i" } };
		//String[] column = { "Bar code", "Device Name", "Device Type", "Brand", "Color", "Connectivity", "Quantity", "Price", "Information" };
		
		List<Stock> temp1 = new ArrayList<Stock>(rf.stock_list);
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
		sp.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Admin Menu - " + rf.users_list.get(0).getname(), TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		f.getContentPane().add(sp);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
		        Mainmenu mm = new Mainmenu();
		        mm.main(header);
			}
		});
		back.setBounds(10, 270, 89, 23);
		f.getContentPane().add(back);
		
		barcode = new JTextField();
		barcode.setColumns(10);
		barcode.setBounds(75, 207, 86, 20);
		f.getContentPane().add(barcode);
		
		JLabel lblNewLabel_2_1 = new JLabel("Bar Code:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setBounds(10, 210, 60, 14);
		f.getContentPane().add(lblNewLabel_2_1);
		
		devicename = new JTextField();
		devicename.setColumns(10);
		devicename.setBounds(264, 207, 86, 20);
		f.getContentPane().add(devicename);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Device Name:");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1.setBounds(179, 210, 80, 14);
		f.getContentPane().add(lblNewLabel_2_1_1);
		
		devicetype = new JTextField();
		devicetype.setColumns(10);
		devicetype.setBounds(454, 207, 86, 20);
		f.getContentPane().add(devicetype);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Device Type:");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_2.setBounds(378, 210, 71, 14);
		f.getContentPane().add(lblNewLabel_2_1_2);
		
		brand = new JTextField();
		brand.setColumns(10);
		brand.setBounds(639, 207, 86, 20);
		f.getContentPane().add(brand);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Brand:");
		lblNewLabel_2_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_3.setBounds(563, 210, 71, 14);
		f.getContentPane().add(lblNewLabel_2_1_3);
		
		connectivity = new JTextField();
		connectivity.setColumns(10);
		connectivity.setBounds(264, 239, 86, 20);
		f.getContentPane().add(connectivity);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Color:");
		lblNewLabel_2_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_4.setBounds(10, 242, 60, 14);
		f.getContentPane().add(lblNewLabel_2_1_4);
		
		color = new JTextField();
		color.setColumns(10);
		color.setBounds(75, 239, 86, 20);
		f.getContentPane().add(color);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Connectivity:");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_1.setBounds(179, 242, 80, 14);
		f.getContentPane().add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Quantity:");
		lblNewLabel_2_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_2_1.setBounds(378, 242, 71, 14);
		f.getContentPane().add(lblNewLabel_2_1_2_1);
		
		quantity = new JTextField();
		quantity.setColumns(10);
		quantity.setBounds(454, 239, 86, 20);
		f.getContentPane().add(quantity);
		
		JLabel lblNewLabel_2_1_3_1 = new JLabel("Orignal Cost:");
		lblNewLabel_2_1_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_3_1.setBounds(550, 242, 84, 14);
		f.getContentPane().add(lblNewLabel_2_1_3_1);
		
		cost = new JTextField();
		cost.setColumns(10);
		cost.setBounds(639, 239, 86, 20);
		f.getContentPane().add(cost);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Retail Price:");
		lblNewLabel_2_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1_1_1.setBounds(188, 276, 71, 14);
		f.getContentPane().add(lblNewLabel_2_1_1_1_1);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(264, 273, 86, 20);
		f.getContentPane().add(price);
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("Information:");
		lblNewLabel_2_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_2_1_1.setBounds(378, 276, 71, 14);
		f.getContentPane().add(lblNewLabel_2_1_2_1_1);
		
		info = new JTextField();
		info.setColumns(10);
		info.setBounds(454, 273, 86, 20);
		f.getContentPane().add(info);
		f.setSize(751, 343);
		f.setVisible(true);
		
		
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = false;
				int bar = Integer.parseInt(barcode.getText());
				
				for(int i = 0; i < sorted.size(); i++) {
					if(bar == sorted.get(i).getBarcode()) {
						check = true;
					}
				}
				
				if (barcode.getText().isEmpty() || devicename.getText().isEmpty() || devicetype.getText().isEmpty() || brand.getText().isEmpty() || color.getText().isEmpty() || connectivity.getText().isEmpty() || quantity.getText().isEmpty() || cost.getText().isEmpty() || price.getText().isEmpty() || info.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else if (check) {
					JOptionPane.showMessageDialog(null, "Bar code exists", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else{
					try {
						int bc = Integer.parseInt(barcode.getText());
						String dn = devicename.getText();
						String dt = devicetype.getText();
						String bd = brand.getText();
						String cl = color.getText();
						String cn = connectivity.getText();
						int qt = Integer.parseInt(quantity.getText());
						double ct = Double.parseDouble(cost.getText());
						double pr = Double.parseDouble(price.getText());
						String in = info.getText();
						
						rf.stock_list.add(new Stock(bc, dn, dt, bd, cl, cn, qt, ct, pr, in));
						
						try {
							FileWriter fw = new FileWriter("Stock.txt", true);
							fw.write("\n" + bc + ", " + dn + ", " + dt + ", " + bd + ", " + cl + ", " + cn + ", " + qt + ", " + ct + ", " + pr + ", " + in);
							fw.close();
						}
						catch(IOException io) {
							System.err.println("Error" + io.getMessage());
						}
						
						
						JOptionPane.showMessageDialog(null, "Item added", "Success", JOptionPane.INFORMATION_MESSAGE);
						
						f.dispose();
				        Adminmenu am = new Adminmenu();
				        
				        
					}
					catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Enter correct data", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		add.setBounds(636, 270, 89, 23);
		f.getContentPane().add(add);
	}
}
