package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Controller.*;

public class Test {

    public static void main(String[] args) {
    	
    	
    	Student s=new Student();
    	Search se=new Search();
    	Update up=new Update();
    	Delete dele=new Delete();
    	Show sh=new Show();
    	
        SwingUtilities.invokeLater(() -> {
        	
            JFrame frame = new JFrame("Background Image Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Set the size of the JFrame
            frame.setSize(1400, 800);

            // Create a JPanel with a background image
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image image = new ImageIcon("C:\\Users\\ASUS\\Downloads\\for elcsipse.jpg").getImage();
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }
            };

            panel.setLayout(null);

        	JButton a = new JButton("ADD");
			a.setFont(new Font("Algerian", Font.BOLD, 18));
			a.setForeground(Color.black);
			a.setBackground(Color.lightGray);
			a.setBounds(00, 100, 150, 40);     
			a.addActionListener(new ActionListener() {
				
			public void actionPerformed(ActionEvent arg0) {
					  s.add();
				}
			});
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			JButton ser = new JButton("SEARCH");
			ser.setFont(new Font("Algerian", Font.BOLD, 18));
			ser.setForeground(Color.black);
			ser.setBounds(200, 100, 150, 40);
			ser.setBackground(Color.lightGray);
			ser.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									se.sear();

									
									
				}
			});
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			JButton u = new JButton("UPDATE");
			u.setFont(new Font("Algerian", Font.BOLD, 18));
			u.setForeground(Color.black);
			u.setBounds(400, 100, 150, 40);
			u.setBackground(Color.lightGray);
u.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
		up.updat();
		
	}
});///////////////////////////////////////////////////////////////////////////////////////////////////
            

JButton d = new JButton("DELETE");
d.setFont(new Font("Algerian", Font.BOLD, 18));
d.setForeground(Color.black);
d.setBounds(600, 100, 150, 40);
d.setBackground(Color.lightGray);
d.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dele.del();

		
		
		
	}
});/////////////////////////////////////////////////////////////////////////////////////////////////////////
            

JButton sho = new JButton("SHOW");
sho.setFont(new Font("Algerian", Font.BOLD, 18));
sho.setForeground(Color.black);
sho.setBounds(1200, 100, 150, 40);
sho.setBackground(Color.lightGray);
sho.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			sh.shoo();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
});

            
            
            
            
            panel.add(sho);
            panel.add(d);
    		panel.add(ser);
    		panel.add(u);
	       	panel.add(a);
		
            frame.add(panel);

            frame.setVisible(true);
        });
    }
}
