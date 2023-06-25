package view;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Controller.*;

public class Test {

    public static void testt() {
    	
    	
    	Student s=new Student();
    	Search se=new Search();
    	Update up=new Update();
    	Delete dele=new Delete();
    	Show sh=new Show();
    	History hi=new History();
    	Purchase pur=new Purchase();
    	OutOFStock out=new OutOFStock();
    	Sell see=new Sell();
    	ShowSell shsel=new ShowSell();
    	QrCode qrc=new QrCode();
    	Cart car=new Cart();
    	ShowCart scar=new ShowCart();
    	
    	
    	
    	
    	
    	
        SwingUtilities.invokeLater(() -> {
        	
            JFrame frame = new JFrame("MY INVENTORY");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setBounds(200, 200, 1400, 800);
            // Set the size of the JFrame
          //  frame.setSize(1400, 800);

            // Create a JPanel with a background image
            JPanel panel = new JPanel() {
            	
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
           //     String    src = "C:\\Users\\ASUS\Downloads\\wallpaperflare.com_wallpaper (1).jpg"
                    Image image = new ImageIcon("C:\\Users\\ASUS\\Downloads\\wallpaperflare.com_wallpaper (1).jpg").getImage();
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }
            };

            panel.setLayout(null);
            
            ////////////////////////////////////////////////////////////////////
            JLabel dateLabel = new JLabel();
            dateLabel.setFont(new Font("Algerian", Font.BOLD, 25));
			dateLabel.setForeground(Color.red);

            dateLabel.setBounds(550, 30, 300, 50);
            panel.add(dateLabel);

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
//////////////////////////////////////////////////////////////////////////////////////////////////

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
		
		sh.shoo();
	}
});

JButton p = new JButton("PURCHASE");
p.setFont(new Font("Algerian", Font.BOLD, 18));
p.setForeground(Color.black);
p.setBounds(800, 100, 150, 40);
p.setBackground(Color.lightGray);
p.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
pur.purch();		
	}
});

// Add the JLabel to the panel

JButton h = new JButton("HISTORY");
h.setFont(new Font("Algerian", Font.BOLD, 18));
h.setForeground(Color.black);
h.setBounds(1000, 100, 150, 40);
h.setBackground(Color.lightGray);
h.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
hi.history();		
	}
});///////////////////////////////////////////////////////////////////////////////////////////////////////
JButton st= new JButton("STOCK");
st.setFont(new Font("Algerian", Font.BOLD, 18));
st.setForeground(Color.black);
st.setBounds(50, 200, 150, 40);
st.setBackground(Color.lightGray);
st.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {

	out.outs();
	}
});
//////////////////////////////////////////////////////////////////////
JButton sel= new JButton("SELLS");
sel.setFont(new Font("Algerian", Font.BOLD, 18));
sel.setForeground(Color.black);
sel.setBounds(250, 200, 150, 40);
sel.setBackground(Color.lightGray);
sel.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {

see.sel();
	}
});
////////////////////////////////////////////////////
JButton shosel= new JButton("SELLS DATA");
shosel.setFont(new Font("Algerian", Font.BOLD, 18));
shosel.setForeground(Color.black);
shosel.setBounds(450, 200, 150, 40);
shosel.setBackground(Color.lightGray);
shosel.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {


		shsel.shosell();
		
		
	}
});
///////////////////////////////////////////////////////////
JButton qr= new JButton("QR CODE");
qr.setFont(new Font("Algerian", Font.BOLD, 18));
qr.setForeground(Color.black);
qr.setBounds(650, 200, 150, 40);
qr.setBackground(Color.lightGray);
qr.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {


qrc.qrcod();		
		
	}
});
///////////////////////////////////////////////////////////////
JButton ac= new JButton("ADD CART");
ac.setFont(new Font("Algerian", Font.BOLD, 18));
ac.setForeground(Color.black);
ac.setBounds(850, 200, 150, 40);
ac.setBackground(Color.lightGray);
ac.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {


car.addcart();		
	}
});/////////////////////////////////////////////////////////////////////
JButton sc= new JButton("SHOW CART");
sc.setFont(new Font("Algerian", Font.BOLD, 18));
sc.setForeground(Color.black);
sc.setBounds(1050, 200, 150, 40);
sc.setBackground(Color.lightGray);
sc.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {


scar.shoocart();		
	}
});////////////////////////////////////////////

             panel.add(sc);
             panel.add(ac);
            panel.add(sel);
            panel.add(st);            
            panel.add(p);
            panel.add(h);
            panel.add(sho);
            panel.add(d);
    		panel.add(ser);
    		panel.add(u);
	       	panel.add(a);
		panel.add(shosel);
        panel.add(qr);
		
		frame.add(panel);

            frame.setVisible(true);
        });
    }
}
