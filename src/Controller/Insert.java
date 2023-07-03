package Controller;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class Insert{
public static void add() {
	

	SwingUtilities.invokeLater(() -> {

		
		JFrame frame2 = new JFrame("ADDING NEW PRODUCT");

	//	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	frame2.setSize(500, 800);
		frame2.setBounds(450, 400, 950, 600);
		JPanel panel1 = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image image = new ImageIcon("D:\\HTML\\code6575.jpg").getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

			}
		};

		panel1.setLayout(null);
		
		////////////////////////////////////////////////////////////////////////////
		
		JLabel dateLabel = new JLabel();
        dateLabel.setFont(new Font("Algerian", Font.BOLD, 25));
    //    dateLabel.setBounds(550, 300, 300, 50);
        panel1.add(dateLabel);

        // Create a Timer to update the date label every second
        Timer timer = new Timer(1000, (e) -> {
            // Get the current date
            Date currentDate = new Date();

            // Create a date formatter to format the date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // Format the current date
            String formattedDate = dateFormat.format(currentDate);

            // Update the date label
            dateLabel.setText(formattedDate);
        });

        // Start the timer
        timer.start();
		
		//////////////////////////////////////////////////////////////////////////////////
		//JFrame frame2 = new JFrame("ADD PRODUCT");

		JLabel l1 = new JLabel("NEW PRODUCT NAME :");
		l1.setFont(new Font("Algerian", Font.BOLD, 22));
		l1.setBounds(500, 50, 300, 40);
		JTextField t1 = new JTextField();
		t1.setFont(new Font("Algerian", Font.BOLD, 22));
		t1.setBounds(500, 90, 300, 40);

		JLabel l2 = new JLabel("PRODUCT QUANTITY :");
		l2.setFont(new Font("Algerian", Font.BOLD, 22));
		l2.setBounds(500, 140, 300, 40);
		
		JTextField t2 = new JTextField();
		t2.setFont(new Font("Algerian", Font.BOLD, 17));
		t2.setBounds(500, 180, 300, 40);
		

		JLabel l3 = new JLabel("PER PRODUCT RATE :");
		l3.setFont(new Font("Algerian", Font.BOLD, 22));
		l3.setBounds(500, 230, 300, 40);
		JTextField t3 = new JTextField();
		t3.setFont(new Font("Algerian", Font.BOLD, 17));
		t3.setBounds(500, 270, 300, 40);

		/*
		 * JTextField t4 = new JTextField(); t4.setFont(new
		 * Font("Algerian", Font.BOLD, 17)); t4.setBounds(50, 360,
		 * 300, 40);
		 */

		JButton totalb = new JButton("TOTAL PRICE :");
		totalb.setFont(new Font("Algerian", Font.BOLD, 22));
		totalb.setBounds(500, 320,  300, 40);

		JTextField lb1 = new JTextField();
		lb1.setBounds(500, 380, 300, 40);
		lb1.setFont(new Font("Algerian", Font.BOLD, 25));
		lb1.setForeground(Color.MAGENTA);
		
		
		
		
		
		  

	/*	totalb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int productq = Integer.parseInt(t2.getText());
				int rate = Integer.parseInt(t3.getText());
				lb1.setText("TOTAL AMT:" + (productq * rate));
				
				
				
				
				
				

			}
		});*/
		// Existing code...////////////////////////////////////////////////////////////////////////////////////////////

		totalb.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int productq = Integer.parseInt(t2.getText());
		        int rate = Integer.parseInt(t3.getText());
		        lb1.setText("TOTAL AMT:" + (productq * rate));
		    }
		});

		KeyListener keyListener = new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        calculateTotalPrice();
		    }

		    private void calculateTotalPrice() {
		        String text1 = t2.getText();
		        String text2 = t3.getText();

		        try {
		            int number1 = Integer.parseInt(text1);
		            int number2 = Integer.parseInt(text2);

		            int sum = number1 * number2;

		            lb1.setText("TOTAL AMT:" + sum);
		        } catch (NumberFormatException ex) {
		            lb1.setText("Invalid DATA!!!!!");
		        }
		    }
		};

		t2.addKeyListener(keyListener);
		t3.addKeyListener(keyListener);

		// Existing code...////////////////////////////////////////////////////////////////////////////////


		JButton addp = new JButton("ADD");
		addp.setFont(new Font("Algerian", Font.BOLD, 22));
		addp.setBounds(500, 450, 200, 40);

		addp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String name = t1.getText();
				int productq = Integer.parseInt(t2.getText());
				int rate = Integer.parseInt(t3.getText());
				String date=dateLabel.getText();
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
					int a = st.executeUpdate("Insert into inv values('" + name + "'," + productq + ","  + rate + "," + productq * rate + ",'"+ date+"')");
							                                                                   
					JOptionPane.showMessageDialog(addp, "DATA INSERTED");

				}catch(SQLException e1){
				    JOptionPane.showMessageDialog(addp, "ERROR: " + e1.getMessage());

					JOptionPane.showMessageDialog(addp, "DATA NOT INSETED");
					
				} catch(NumberFormatException f){
					
				    JOptionPane.showMessageDialog(addp, "ERROR: " + f.getMessage());
					JOptionPane.showMessageDialog(addp, "DATA NOT INSETED");

					
				}
				
				

				

			}
			
		});

		JButton clear = new JButton("clear");
		clear.setFont(new Font("Algerian", Font.BOLD, 22));
		clear.setBounds(700, 450, 200, 40);
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lb1.setText("");

				t1.setText("");
				t2.setText("");
				t3.setText("");
				// t4.setText("");
			}
		});

		panel1.add(t1);
		panel1.add(t2);
		panel1.add(lb1);
		panel1.add(t3);
		// frame2.add(t4);

		panel1.add(l1);
		panel1.add(l2);
		panel1.add(l3);
		panel1.add(totalb);

		panel1.add(addp);
		panel1.add(clear);
     	panel1.setSize(500, 800);
	   //	frame2.setLayout(null);
		//frame2.setVisible(true);

		//frame2.setSize(500, 700);*/
		
		
		
		
    


		/*panel.add(a);
		panel.add(ser);
		panel.add(u);
		panel.add(d);
		panel.add(p);
		panel.add(h);
		panel.add(sho);*/

		frame2.add(panel1);

		frame2.setVisible(true);
		
	});
	



}
}