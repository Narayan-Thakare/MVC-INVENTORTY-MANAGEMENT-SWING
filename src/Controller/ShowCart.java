package Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowCart {
	
	
	public static void updat() {
		
		SwingUtilities.invokeLater(() -> {

			JFrame frame3 = new JFrame("UPDATE CART");
		//	frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//	frame6.setSize(500, 800);
			frame3.setBounds(450, 400, 950, 600);
			JPanel panel = new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Image image = new ImageIcon("C:\\Users\\ASUS\\OneDrive\\Pictures\\Screenshots\\Screenshot 2023-06-16 102026.png").getImage();
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

			JLabel l1 = new JLabel("PRODUCT NAME");
			l1.setFont(new Font("Algerian", Font.BOLD, 22));
			l1.setBounds(60, 50, 300, 40);
			JTextField t1 = new JTextField();
			t1.setFont(new Font("Algerian", Font.BOLD, 17));
			t1.setBounds(50, 90, 300, 40);

			JLabel l2 = new JLabel("PRODUCT QUANTITY");
			l2.setFont(new Font("Algerian", Font.BOLD, 22));
			l2.setBounds(60, 140, 300, 40);
			JTextField t2 = new JTextField();
			t2.setFont(new Font("Algerian", Font.BOLD, 17));
			t2.setBounds(50, 180, 300, 40);

			JLabel l3 = new JLabel("PER PRODUCT RATE");
			l3.setFont(new Font("Algerian", Font.BOLD, 22));
			l3.setBounds(60, 230, 300, 40);
			JTextField t3 = new JTextField();
			t3.setFont(new Font("Algerian", Font.BOLD, 17));
			t3.setBounds(50, 270, 300, 40);

			/*
			 * JTextField t4 = new JTextField(); t4.setFont(new
			 * Font("Algerian", Font.BOLD, 17)); t4.setBounds(50, 360,
			 * 300, 40);
			 */

			JButton totalb = new JButton("TOATAL PRICE");
			totalb.setFont(new Font("Algerian", Font.BOLD, 22));
			totalb.setBounds(60, 320, 300, 40);

			JTextField lb1 = new JTextField();
			lb1.setBounds(285, 380, 300, 40);
			lb1.setFont(new Font("Algerian", Font.BOLD, 25));
			lb1.setForeground(Color.MAGENTA);

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

			JButton update = new JButton("UPDATE");
			update.setFont(new Font("Algerian", Font.BOLD, 22));
			update.setBounds(50, 450, 200, 40);

			update.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {


					
					String name = t1.getText();
			//        int oldQuantity = getproductQunatity(name); // Get the old product quantity from the database

					int productq = Integer.parseInt(t2.getText());
					int rate = Integer.parseInt(t3.getText());
					String date =dateLabell.getText();
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

					
					
					try {
						int b = st.executeUpdate("UPDATE inv3 SET productQunatity = " + productq
								+ "  WHERE productname = '" + name + "'");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						int d = st.executeUpdate("UPDATE inv3 SET Perproductrate = " + rate
								+ "  WHERE productname = '" + name + "'");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						int c = st.executeUpdate("UPDATE inv3 SET Tatalprice = " + productq * rate
								+ "  WHERE productname = '" + name + "'");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						int d = st.executeUpdate("UPDATE inv3 SET date = '" + date
								+ "'  WHERE productname = '" + name + "'");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(update, "DATA -INSETED");

				}
			});

			JButton clear = new JButton("clear");
			clear.setFont(new Font("Algerian", Font.BOLD, 22));
			clear.setBounds(230, 450, 200, 40);
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
			
		

			frame3.add(panel);

			frame3.setVisible(true);
		});





	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        shoocart();
    }

    public static void shoocart() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoryy", "root", "abc123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql ="SELECT * FROM inv3 ORDER BY date DESC";
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JFrame f = new JFrame("SHOW DATA");
        JTable table = null;
        
        try {
            table = new JTable(buildTableModel(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        table.setFont(new Font("Algerian", Font.BOLD, 14));

        // Add delete and update button columns to the table model
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addColumn("Delete");
        model.addColumn("Update");

        // Create button column renderers and editors
        TableColumn deleteColumn = table.getColumnModel().getColumn(model.getColumnCount() - 2);
        deleteColumn.setCellRenderer(new ButtonRenderer("Delete"));
        deleteColumn.setCellEditor(new ButtonEditor("Delete"));

        TableColumn updateColumn = table.getColumnModel().getColumn(model.getColumnCount() - 1);
        updateColumn.setCellRenderer(new ButtonRenderer("Update"));
        updateColumn.setCellEditor(new ButtonEditor("Update"));

        f.add(new JScrollPane(table));
        f.pack();
        f.setBounds(350, 550, 1100, 400);/////////////////////////////////////////////////////////////////////////////////////////
        f.setVisible(true);
    }
    /////////////////////////////////////////////////////////////////////////

    private static DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        DefaultTableModel tableModel = new DefaultTableModel();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            tableModel.addColumn(metaData.getColumnName(i));
        }

        while (resultSet.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            tableModel.addRow(row);
        }
        return tableModel;
    }
    /////////////////////////////////////////////////////////////////////

    private static void deleteProduct(Object name) {
        // Perform the delete operation based on the product ID
        // Implement your delete logic here
        // For example:
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoryy", "root", "abc123");
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM inv3 WHERE productname = '" + name + "'";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateProduct(Object name) {
    	
    	updat();
    	//shoo();
        // Perform the update operation based on the product ID
        // Implement your update logic here
        // For example:
        // You can open a new window/dialog to allow the user to update the product details
        // and perform the update operation based on the updated values.
        System.out.println("Update product: " + name);
    }

    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer(String text) {
            setText(text);
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setBackground(table.getSelectionBackground());
            } else {
                setBackground(table.getBackground());
            }
            return this;
        }
    }

    static class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(String text) {
            super(new JTextField());
            setClickCountToStart(1);
            button = new JButton(text);
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                JTable table = (JTable) button.getParent();
                int modelRow = table.convertRowIndexToModel(table.getEditingRow());
                int modelColumn = table.convertColumnIndexToModel(table.getEditingColumn());
                Object productId = table.getModel().getValueAt(modelRow, 0);
                String columnName = table.getModel().getColumnName(modelColumn);

                if (columnName.equals("Delete")) {
                    int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this entry?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        deleteProduct(productId);
                        ((DefaultTableModel) table.getModel()).removeRow(modelRow);
                    }
                } else if (columnName.equals("Update")) {
                    updateProduct(productId);
                }
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
}
