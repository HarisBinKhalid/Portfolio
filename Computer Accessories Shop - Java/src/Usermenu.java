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

public class Usermenu extends JFrame {
	
	private JTextField searchbar;	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Usermenu frame = new Usermenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Usermenu(int id, ReadFiles rf, int[] count_list) {
		
		JFrame f;
		JTable tbl = new JTable();
		f = new JFrame();
		tbl.setBounds(30, 40, 0, 300);
		List<Stock> temp1;
		
		if (rf.found_list.isEmpty()) {
			temp1 = new ArrayList<Stock>(rf.stock_list);	
		}
		else {
			temp1 = new ArrayList<Stock>(rf.found_list);
		}
		
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
		sp.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "User Menu - " + rf.users_list.get(id).getname(), TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		f.getContentPane().add(sp);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rf.found_list.clear();
				f.dispose();
		        Mainmenu mm = new Mainmenu();
		        mm.main(header);
			}
		});
		back.setBounds(10, 204, 89, 23);
		f.getContentPane().add(back);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tbl.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "Select an item", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					String value = tbl.getModel().getValueAt(row, 0).toString();
					int val = Integer.parseInt(value);
					int count = 0;
					double total = 0;
					double payment = 0;
					
					for (int i = 0; i < rf.stock_list.size(); i++) {
						if (val == rf.stock_list.get(i).getBarcode()) {
							count = count_list[i];
							
							if (count < rf.stock_list.get(i).getQuantity()) {
								rf.users_list.get(id).basket_list.add(rf.stock_list.get(i));
								rf.users_list.get(id).barcode.add(rf.stock_list.get(i).getBarcode());
								count_list[i] = count + 1;
								total = rf.stock_list.get(i).getPrice();
								payment = rf.users_list.get(id).getPayment();
								
								rf.users_list.get(id).setPayment(payment + total);
								
								JOptionPane.showMessageDialog(null, "Added", "Success", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(null, "Not enough quantity", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}
			}
		});
		btnNewButton.setBounds(636, 204, 89, 23);
		f.getContentPane().add(btnNewButton);
		
		JButton basket = new JButton("Basket");
		basket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
		        Basket bk = new Basket(id, rf, count_list);
			}
		});
		basket.setBounds(537, 204, 89, 23);
		f.getContentPane().add(basket);
		
		JButton search = new JButton("search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String find = searchbar.getText();
				rf.found_list.clear();
				
				for (int i = 0; i < rf.stock_list.size(); i++) {
					if (find.equals(rf.stock_list.get(i).getBrand()) || find.equals(rf.stock_list.get(i).getInformation())) {
						rf.found_list.add(rf.stock_list.get(i));
					}
				}  
				
				f.dispose();
		        Usermenu am = new Usermenu(id, rf, count_list);
				
			}
		});
		search.setBounds(109, 204, 89, 23);
		f.getContentPane().add(search);
		
		searchbar = new JTextField();
		searchbar.setBounds(208, 205, 319, 20);
		f.getContentPane().add(searchbar);
		searchbar.setColumns(10);
		f.setSize(751, 277);
		f.setVisible(true);
	}

}
