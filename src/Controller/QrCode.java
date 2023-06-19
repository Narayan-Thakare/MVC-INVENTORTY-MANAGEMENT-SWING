package Controller;

import javax.swing.*;
import java.awt.*;

public class QrCode {

    public static void qrcod() {
        SwingUtilities.invokeLater(() -> {
        	
            JFrame frame = new JFrame("QR CODE");
          //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setBounds(700, 300, 400, 700);

            // Set the size of the JFrame
         //   frame.setSize(400, 300);

            // Create a JPanel with a background image
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image image = new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Documents\\payment qr.jpg").getImage();
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }
            };

            // Set the layout manager for the panel
            panel.setLayout(null);

            // Create the JLabel component
            JLabel ins = new JLabel("BHAI MEKO PATA HAI TERE PASS ");
            ins.setFont(new Font("Algerian", Font.BOLD, 20));
            ins.setForeground(Color.magenta); 
            ins.setBounds(10, 20, 490, 40);
    		
    		JLabel ins1 = new JLabel(" PAISE TOH HONGE NHI....");
            ins1.setFont(new Font("Algerian", Font.BOLD, 20));
            ins1.setForeground(Color.magenta);  
            ins1.setBounds(10, 38, 490, 40);

    		JLabel ins2 = new JLabel("HONGE TOHH PAYMENT KRKE BATA!!");
            ins2.setFont(new Font("Algerian", Font.BOLD, 20));
            ins2.setForeground(Color.magenta);
            ins2.setBounds(10, 56, 490, 40);

    		
            // Add the JLabel to the panel
            panel.add(ins);
            panel.add(ins1);
            panel.add(ins2);         

            // Add other components to the panel
            // ...

            // Add the panel to the frame
            frame.add(panel);

            // Set the frame visible
            frame.setVisible(true);
        });
    }
}
