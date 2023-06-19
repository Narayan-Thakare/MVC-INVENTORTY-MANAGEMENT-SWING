package Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class OutOFStock {
	
	
	
	
    public static void outs() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Out of Stock Inventory");
          //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setBounds(350, 550, 1100, 400);

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Product Name");
            tableModel.addColumn("Product Quantity");
            tableModel.addColumn("Per Product Rate");
            tableModel.addColumn("Total Price");
            tableModel.addColumn("Date");
            
      

            JTable table = new JTable(tableModel);
    		table.setFont(new Font("algerian", Font.BOLD, 18));

            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);

            JButton fetchButton = new JButton("Fetch Out of Stock");
            fetchButton.setFont(new Font("Algerian", Font.BOLD, 20));
			fetchButton.setForeground(Color.red);

            fetchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Connection con = null;
                    try {
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventoryy", "root",
                                "abc123");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM inv WHERE productQunatity <= 0");

                        tableModel.setRowCount(0); // Clear the table

                        while (rs.next()) {
                            String productName = rs.getString("productname");
                            int productQuantity = rs.getInt("productQunatity");
                            int perProductRate = rs.getInt("Perproductrate");
                            int totalPrice = rs.getInt("Totalprice");
                            String date = rs.getString("date");

                            Object[] rowData = { productName, productQuantity, perProductRate, totalPrice, date };
                            tableModel.addRow(rowData);
                        }

                        rs.close();
                        st.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } finally {
                        if (con != null) {
                            try {
                                con.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
            });

            panel.add(fetchButton, BorderLayout.SOUTH);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
