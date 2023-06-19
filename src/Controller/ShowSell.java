package Controller;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ShowSell {

    public DefaultTableModel tableModel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShowSell frame = new ShowSell();
            frame.shosell();
        });
    }

    public void shosell() {
        JFrame frame = new JFrame("Data History");
      //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(350, 550, 1100, 400);

        // Create a table with default table model
        JTable table = new JTable();
        tableModel = new DefaultTableModel();
        table.setModel(tableModel);
		table.setFont(new Font("algerian", Font.BOLD, 14));


        // Add columns to the table model
        tableModel.addColumn("Costomer Name");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Product Rate");
        tableModel.addColumn("Date");


        // Fetch data from the database and populate the table model
        fetchAndPopulateData();

        // Create a scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a panel and add the scroll pane to it
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add the panel to the frame
        frame.add(panel);

        // Set the frame visible
        frame.setVisible(true);
    }

    private void fetchAndPopulateData() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoryy", "root", "abc123");

            // Create a statement to execute SQL queries
            statement = connection.createStatement();

            // Execute a SELECT query to fetch the data from the database
            String sql = "SELECT * FROM inv2 ORDER BY date DESC";
            resultSet = statement.executeQuery(sql);

            // Iterate over the result set and add data to the table model
            while (resultSet.next()) {
                String coname = resultSet.getString("name");
                String name = resultSet.getString("productname");
                int productq = resultSet.getInt("productquantity");
                int rate = resultSet.getInt("productrate");
                String date = resultSet.getString("date");

                

                tableModel.addRow(new Object[]{coname, name, productq, rate,date});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
