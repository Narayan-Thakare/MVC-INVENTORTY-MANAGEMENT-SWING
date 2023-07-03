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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class Sell{
public static void sel() {
	
	SwingUtilities.invokeLater(() -> {

		JFrame frame3 = new JFrame("SELLING");
	//	frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	frame6.setSize(500, 800);
		frame3.setBounds(450, 400, 950, 600);
		JPanel panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image image = new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\code4678.jpg").getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

			}
		};

		panel.setLayout(null);
		
		
		JLabel dateLabell = new JLabel();
        dateLabell.setFont(new Font("Algerian", Font.BOLD, 25));
      //  dateLabell.setBounds(550, 300, 300, 50);
        panel.add(dateLabell);

        // Create a Timer to update the date label every second
        Timer timer = new Timer(1000, (e) -> {
            // Get the current date
            Date currentDate = new Date();

            // Create a date formatter to format the date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            // Format the current date
            String formattedDate = dateFormat.format(currentDate);

            // Update the date label
            dateLabell.setText(formattedDate);
        });

        // Start the timer
        timer.start();

        JLabel c = new JLabel("COSTMAR NAME");
		c.setFont(new Font("Algerian", Font.BOLD, 22));
		c.setForeground(Color.magenta);
		c.setBounds(60, 10, 300, 40);
		JTextField t = new JTextField();
		t.setFont(new Font("Algerian", Font.BOLD, 17));
		t.setBounds(250, 10, 200, 40);

        
		JLabel l1 = new JLabel("PRODUCT NAME");
		l1.setFont(new Font("Algerian", Font.BOLD, 22));
		l1.setForeground(Color.magenta);
		l1.setBounds(60, 50, 300, 40);
		JTextField t1 = new JTextField();
		t1.setFont(new Font("Algerian", Font.BOLD, 17));
		t1.setBounds(50, 90, 300, 40);

		JLabel l2 = new JLabel("PRODUCT QUANTITY");
		l2.setFont(new Font("Algerian", Font.BOLD, 22));
		l2.setForeground(Color.magenta);
		l2.setBounds(60, 140, 300, 40);
		JTextField t2 = new JTextField();
		t2.setFont(new Font("Algerian", Font.BOLD, 17));
		t2.setBounds(50, 180, 300, 40);

		JLabel l3 = new JLabel("PER PRODUCT RATE");
		l3.setFont(new Font("Algerian", Font.BOLD, 22));
		l3.setForeground(Color.magenta);

		l3.setBounds(60, 230, 300, 40);
		JTextField t3 = new JTextField();
		t3.setFont(new Font("Algerian", Font.BOLD, 17));
		t3.setBounds(50, 270, 300, 40);

		/*
		 * JTextField t4 = new JTextField(); t4.setFont(new
		 * Font("Algerian", Font.BOLD, 17)); t4.setBounds(50, 360,
		 * 300, 40);
		 */

		JButton totalb = new JButton("TOTAL PRICE");
		totalb.setFont(new Font("Algerian", Font.BOLD, 22));
		totalb.setBounds(60, 320, 200, 40);

		JTextField lb1 = new JTextField();
		lb1.setBounds(50, 380, 300, 40);
		lb1.setForeground(Color.magenta);
		lb1.setFont(new Font("Algerian", Font.BOLD, 25));

		totalb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int productq = Integer.parseInt(t2.getText());
				int rate = Integer.parseInt(t3.getText());
				lb1.setText("TOTAL AMT:" + (productq * rate));

			}
		});
//////////////////////////////////////////////
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
////////////////////////////////////////
		
		
		JButton update = new JButton("SELL");
		update.setFont(new Font("Algerian", Font.BOLD, 22));
		update.setBounds(50, 450, 200, 40);

		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {



				String name = t1.getText();

				int productq = Integer.parseInt(t2.getText());
				int rate = Integer.parseInt(t3.getText());
				String date =dateLabell.getText();
				String coname=t.getText();

				// int Price = Integer.parseInt(t4.getText());
		     //   int totalQuantity = productq + (newQuantity * rate);

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
////////////////////////////////////////////////////////////////
				
				
				try {
          //          String query = "INSERT INTO inv (productname, productQunatity, Perproductrate, Totalprice,cname) VALUES (?, ?, ?, ?)";

					int a = st.executeUpdate("Insert into inv2 values('" +coname + "','" + name + "',"  +productq + "," +  rate + ",'"+ date+"')");
					
					/*
					PreparedStatement ps = con.prepareStatement("INSERT INTO inv2 (cname) VALUES (?)");
					
					ps.setString(1, coname);

					//ps.setString(6, coname);

					int a = ps.executeUpdate();*/


				}catch(SQLException e1){
				    JOptionPane.showMessageDialog(update, "ERROR: " + e1.getMessage());

					JOptionPane.showMessageDialog(update, "DATA NOT INSETED");
					
				} catch(NumberFormatException f){
					
				    JOptionPane.showMessageDialog(update, "ERROR: " + f.getMessage());
					JOptionPane.showMessageDialog(update, "DATA NOT INSETED");

					
				}
				
				//////////////////////////////////////////////////////
				 int currentQuantity = 0;
                 try {
                     ResultSet rs = st.executeQuery("SELECT productQunatity FROM inv WHERE productname = '" + name + "'");
                     if (rs.next()) {
                         currentQuantity = rs.getInt("productQunatity");
                     }
                 } catch (SQLException e1) {
                     e1.printStackTrace();
                 }

                 // Calculate the updated quantity
                 int updatedQuantity = currentQuantity - productq;
                 //////////////////////////////////////////////////////////
               /*  int currentrate = 0;
                 try {
                     ResultSet rs = st.executeQuery("SELECT productQunatity FROM inv WHERE productname = '" + name + "'");
                     if (rs.next()) {
                         currentrate = rs.getInt("Perproductrate");
                     }
                 } catch (SQLException e1) {
                     e1.printStackTrace();
                 }

                 // Calculate the updated quantity
                 int updatedrate = currentrate + rate;
*/
                 

				
				try {
					int b = st.executeUpdate("UPDATE inv SET productQunatity = " +  updatedQuantity 
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
					int c = st.executeUpdate("UPDATE inv SET Totalprice = " + updatedQuantity  * rate
							+ "  WHERE productname = '" + name + "'");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					int d = st.executeUpdate("UPDATE inv SET date = '" + date
							+ "'  WHERE productname = '" + name + "'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				/*try {
					int d = st.executeUpdate("UPDATE inv SET cname = '" + coname
							+ "'  WHERE productname = '" + name + "'");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/

				JOptionPane.showMessageDialog(update, "PRODUCT -SELL");

			}
		});

		JButton clear = new JButton("CLEAR");
		clear.setFont(new Font("Algerian", Font.BOLD, 22));
		clear.setBounds(230, 450, 200, 40);
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
t.setText("");
lb1.setText("");
				t1.setText("");
				t2.setText("");
				t3.setText("");
			//	t.setText("");
				// t4.setText("");
			}
		});
        panel.add(c);
        panel.add(t);
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
	//	frame3.setSize(500, 800);
	
		
		
		
		
		
		
		
	//	frame3.setSize(500, 600);
	

		frame3.add(panel);

		frame3.setVisible(true);
	});



}
}