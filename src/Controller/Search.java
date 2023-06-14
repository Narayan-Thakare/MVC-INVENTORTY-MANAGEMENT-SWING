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

public class Search{
public static void sear() {
	
	SwingUtilities.invokeLater(() -> {

		JFrame frame6 = new JFrame("SEARCH DATA");
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	frame6.setSize(500, 800);
		frame6.setBounds(500, 200, 500, 600);
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image image = new ImageIcon("D:\\HTML\\for eclipsie.jpeg").getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

			}
		};

		panel.setLayout(null);
		
		
		//JFrame frame2 = new JFrame("ADD PRODUCT");

	//	JFrame frame6 = new JFrame("DELETE PRODUCT");

		JLabel l1 = new JLabel("Product Name");
		l1.setFont(new Font("Algerian", Font.BOLD, 17));
		l1.setBounds(60, 50, 200, 40);

		JTextField t1 = new JTextField();
		t1.setFont(new Font("Algerian", Font.BOLD, 17));
		t1.setBounds(50, 90, 300, 40);

		JButton search = new JButton("SEARCH");
		search.setFont(new Font("Algerian", Font.BOLD, 17));
		search.setBounds(60, 150, 200, 40);

		JLabel lb1 = new JLabel();
		lb1.setBounds(10, 200, 300, 200);
		lb1.setFont(new Font("Algerian", Font.BOLD, 20));

		JLabel lb2 = new JLabel();
		lb2.setBounds(10, 250, 300, 200);
		lb2.setFont(new Font("Algerian", Font.BOLD, 20));

		JLabel lb3 = new JLabel();
		lb3.setBounds(10, 300, 300, 200);
		lb3.setFont(new Font("Algerian", Font.BOLD, 20));

		JLabel lb4 = new JLabel();
		lb4.setBounds(10, 350, 300, 200);
		lb4.setFont(new Font("Algerian", Font.BOLD, 20));

		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					boolean found = false;
					String name = t1.getText();
					Connection con = null;
					try {
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventoryy", "root",
								"abc123");
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

					ResultSet rs = st.executeQuery("SELECT * FROM inv WHERE productname = '" + name + "'");
					while (rs.next()) {
						System.out.println((rs.getString(1) + " " + rs.getInt(2) + " " + rs.getInt(3) + " "
								+ rs.getInt(4)));
						lb1.setText("PRODUCT NAME        : " + (rs.getString(1)));
						lb2.setText("PRODUCT QUANTITY : " + (rs.getInt(2)));
						lb3.setText("PER PRODUCT RATE : " + (rs.getInt(3)));
						lb4.setText("TOTAL PRICE            : " + (rs.getInt(4)));

						JOptionPane.showMessageDialog(search, "DATA FOUND");

						found = true;

					}
					if (!found) {
						JOptionPane.showMessageDialog(search, "DATA NOT FOUND");
					}

				} catch (Exception p) {
					System.out.println("Enter the no. :" + p);

				}
				t1.setText("");
				// TODO Auto-generated method stub

			}
		});

		panel.add(search);
		panel.add(l1);
		panel.add(t1);
		panel.add(lb1);
		panel.add(lb2);
		panel.add(lb3);
		panel.add(lb4);

		frame6.setSize(500, 700);
	//	frame6.setLayout(null);
//		frame6.setVisible(true);

	
    


		/*panel.add(a);
		panel.add(ser);
		panel.add(u);
		panel.add(d);
		panel.add(p);
		panel.add(h);
		panel.add(sho);*/

		frame6.add(panel);

		frame6.setVisible(true);
	});



}
}