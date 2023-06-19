package Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Delete{
public static void del() {
	
	SwingUtilities.invokeLater(() -> {

		JFrame frame5 = new JFrame("DELETE PRODUCT");
	//	frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	frame6.setSize(500, 800);
		frame5.setBounds(450, 400, 950, 600);
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image image = new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\code234566.jpg").getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

			}
		};

		panel.setLayout(null);
		
		
		//JFrame frame2 = new JFrame("ADD PRODUCT");

	//	JFrame frame6 = new JFrame("DELETE PRODUCT");

	//	JFrame frame5 = new JFrame("DELETE PRODUCT");

		JLabel l1 = new JLabel("PRODUCT NAME");
		l1.setFont(new Font("Algerian", Font.BOLD, 25));
		l1.setForeground(Color.black);
		l1.setBounds(350, 50, 200, 40);
		JTextField t1 = new JTextField();

		
		t1.setFont(new Font("Algerian", Font.BOLD, 17));
		t1.setBounds(350, 90, 300, 40);
		JButton delete = new JButton("DELETE...");
		
		delete.setFont(new Font("Algerian", Font.BOLD, 22));
		delete.setForeground(Color.black);
		delete.setBounds(350, 150, 300, 40);

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					boolean delet = false;
					String name = t1.getText();
					if (name == name) {

						Connection con = null;
						try {
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventoryy",
									"root", "abc123");
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						Statement st = null;
						try {
							st = con.createStatement();
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						int d = st.executeUpdate("DELETE FROM inv WHERE productname='" + name + "'");
						System.out.println("data deleted");
						JOptionPane.showMessageDialog(delete, "DATA DELETED");

						delet = true;

					}
					if (!delet) {
						System.out.println("Student not found");
						JOptionPane.showMessageDialog(delete, "DATA NOT DELETED");

					}

				} catch (Exception p) {
					System.out.println("Enter the no. :" + p);

				}
				t1.setText("");

				// TODO Auto-generated method stub

			}
		});

		panel.add(delete);
		panel.add(l1);
		panel.add(t1);

		

		
		
		
	//	frame5.setSize(500, 600);
	

		frame5.add(panel);

		frame5.setVisible(true);
	});



}
}