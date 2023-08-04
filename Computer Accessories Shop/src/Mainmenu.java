import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Mainmenu extends JFrame {
	public static ReadFiles rf;
	public static ReadFiles rf1;
	public static ReadFiles rf2;
	public static ReadFiles rf3;
	public int[] count_list = new int[100];
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainmenu frame = new Mainmenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mainmenu() {
		
		if(rf == null) {
			rf = new ReadFiles();
			rf1 = new ReadFiles();
			rf2 = new ReadFiles();
			rf3 = new ReadFiles();
			for (int i = 0; i < 100; i++) {
			    count_list[i] = 0;
			}
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 352, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Main Menu", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 316, 204);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JButton userbutton1 = new JButton(rf.users_list.get(0).getusername());
		userbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		        Adminmenu am = new Adminmenu();
			}
		});
		userbutton1.setBounds(110, 46, 89, 23);
		panel.add(userbutton1);
		
		JButton userbutton2 = new JButton(rf.users_list.get(1).getusername());
		userbutton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		        Usermenu am = new Usermenu(1, rf1, count_list);
			}
		});
		userbutton2.setBounds(110, 105, 89, 23);
		panel.add(userbutton2);
		
		JButton userbutton3 = new JButton(rf.users_list.get(2).getusername());
		userbutton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		        Usermenu am = new Usermenu(2, rf2, count_list);
			}
		});
		userbutton3.setBounds(110, 139, 89, 23);
		panel.add(userbutton3);
		
		JButton userbutton4 = new JButton(rf.users_list.get(3).getusername());
		userbutton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		        Usermenu am = new Usermenu(3, rf3, count_list);
			}
		});
		userbutton4.setBounds(110, 173, 89, 23);
		panel.add(userbutton4);
		
		JLabel lblNewLabel = new JLabel("Customer");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(110, 80, 89, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(110, 23, 89, 14);
		panel.add(lblNewLabel_1);
	}
}
