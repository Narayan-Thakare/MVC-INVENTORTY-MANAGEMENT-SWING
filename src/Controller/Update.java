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

public class Update{
public static void updat() {
	
	SwingUtilities.invokeLater(() -> {

		JFrame frame3 = new JFrame("UPDATE DATA");
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	frame6.setSize(500, 800);
		frame3.setBounds(500, 200, 500, 600);
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
		//JFrame frame3 = new JFrame("UPDATE PRODUCT");

		JLabel l1 = new JLabel("Product Name");
		l1.setFont(new Font("Algerian", Font.BOLD, 17));
		l1.setBounds(60, 50, 200, 40);
		JTextField t1 = new JTextField();
		t1.setFont(new Font("Algerian", Font.BOLD, 17));
		t1.setBounds(50, 90, 300, 40);

		JLabel l2 = new JLabel("Product Quantity");
		l2.setFont(new Font("Algerian", Font.BOLD, 17));
		l2.setBounds(60, 140, 200, 40);
		JTextField t2 = new JTextField();
		t2.setFont(new Font("Algerian", Font.BOLD, 17));
		t2.setBounds(50, 180, 300, 40);

		JLabel l3 = new JLabel("Per Product Rate");
		l3.setFont(new Font("Algerian", Font.BOLD, 17));
		l3.setBounds(60, 230, 200, 40);
		JTextField t3 = new JTextField();
		t3.setFont(new Font("Algerian", Font.BOLD, 17));
		t3.setBounds(50, 270, 300, 40);

		/*
		 * JTextField t4 = new JTextField(); t4.setFont(new
		 * Font("Algerian", Font.BOLD, 17)); t4.setBounds(50, 360,
		 * 300, 40);
		 */

		JButton totalb = new JButton("Total Price");
		totalb.setFont(new Font("Algerian", Font.BOLD, 17));
		totalb.setBounds(60, 320, 200, 40);

		JLabel lb1 = new JLabel();
		lb1.setBounds(285, 380, 200, 40);
		lb1.setFont(new Font("Algerian", Font.BOLD, 20));

		totalb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int productq = Integer.parseInt(t2.getText());
				int rate = Integer.parseInt(t3.getText());
				lb1.setText("TOTAL AMT:" + (productq * rate));

			}
		});

		JButton update = new JButton("UPDATE");
		update.setFont(new Font("Algerian", Font.BOLD, 17));
		update.setBounds(50, 450, 160, 30);

		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String name = t1.getText();
				int productq = Integer.parseInt(t2.getText());
				int rate = Integer.parseInt(t3.getText());
				// int Price = Integer.parseInt(t4.getText());
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

				try {
					int b = st.executeUpdate("UPDATE inv SET productQunatity = " + productq
							+ "  WHERE productname = '" + name + "'");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					int d = st.executeUpdate("UPDATE inv SET Perproductrate = " + rate
							+ "  WHERE productname = '" + name + "'");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					int c = st.executeUpdate("UPDATE inv SET Totalprice = " + productq * rate
							+ "  WHERE productname = '" + name + "'");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(update, "DATA -INSETED");

			}
		});

		JButton clear = new JButton("clear");
		clear.setFont(new Font("Algerian", Font.BOLD, 17));
		clear.setBounds(230, 450, 100, 30);
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				t1.setText("");
				t2.setText("");
				t3.setText("");
				// t4.setText("");
			}
		});

		panel.add(t1);
		panel.add(t2);
		panel.add(lb1);
		panel.add(t3);
		// frame2.add(t4);

		panel.add(l1);
		panel.add(l2);
		panel.add(l3);
		panel.add(totalb);

		panel.add(update);
		panel.add(clear);
		frame3.setSize(500, 800);
	
		
		
		
		
		
		
		
		frame3.setSize(500, 700);
	

		frame3.add(panel);

		frame3.setVisible(true);
	});



}
}