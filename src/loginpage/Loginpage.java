package loginpage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
public class Loginpage {
	static Test t=new Test();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Login Page");
        //    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Set the size of the JFrame
            frame.setBounds(450, 400, 950, 600);

            // Create a JPanel with a background image
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image image = new ImageIcon("D:\\HTML\\code 897629.jpg").getImage();
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }
            };

            // Set the layout manager for the panel
            panel.setLayout(null);

            // Create the JLabel component
            JLabel ins = new JLabel("WELCOME TO INVENTORY");
            ins.setFont(new Font("Algerian", Font.BOLD, 35));
            ins.setForeground(Color.black); // Set the font color
            ins.setBounds(250, 20, 450, 40);

            JLabel lb = new JLabel("NAME :");
            lb.setFont(new Font("Algerian", Font.BOLD, 25));
            lb.setBounds(250, 150, 160, 40);

            JTextField tx = new JTextField();
            tx.setFont(new Font("Algerian", Font.BOLD, 17));
            tx.setBounds(400, 150, 200, 40);

            JLabel lb1 = new JLabel("PASSWORD :");
            lb1.setFont(new Font("Algerian", Font.BOLD, 25));
            lb1.setBounds(240, 200, 200, 40);

            JPasswordField passwordField = new JPasswordField();
            passwordField.setFont(new Font("Algerian", Font.BOLD, 17));
            passwordField.setBounds(400, 200, 200, 40);

            JButton loginButton = new JButton("LOGIN");
            loginButton.setFont(new Font("Algerian", Font.BOLD, 25));
            loginButton.setBounds(350, 250, 200, 40);
            loginButton.setForeground(Color .magenta);

            // Add ActionListener to the login button
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = tx.getText();
                    String password = new String(passwordField.getPassword());

                    // Check if the username and password are correct
                    if (username.equals("asd") && password.equals("123")) {
                    	
                        JOptionPane.showMessageDialog(frame, "Login Successful!");
                       
                        t.testt();
                        
                        
                        
                        
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid username or password. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            // Add the JLabel to the panel
            panel.add(ins);
            panel.add(tx);
            panel.add(lb1);
            panel.add(passwordField);
            panel.add(lb);
            panel.add(loginButton);

            // Add other components to the panel
            // ...

            // Add the panel to the frame
            frame.add(panel);

            // Set the frame visible
            frame.setVisible(true);
        });
    }
}
