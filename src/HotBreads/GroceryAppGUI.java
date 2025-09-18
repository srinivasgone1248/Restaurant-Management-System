package HotBreads;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;


public class GroceryAppGUI {

	public static void main(String[] args) {
	JFrame frame = new JFrame("Restaurant Management System");
	frame.setSize(500,400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//frame.setVisible(true);
	
	//panel to hold buttons
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(5,1,10,10));
	
	//buttons
	JButton addButton = new JButton("Add Grocery");
	JButton viewButton = new JButton("View Grocery");
	JButton updateButton = new JButton("Update Grocery");
	JButton deleteButton = new JButton("Delete Grocery");
	JButton searchButton = new JButton("Search Grocery");
	JButton expiryButton = new JButton("Expiring Soon");
	JButton reportButton = new JButton("Generate Expired Report");
	JButton exitButton = new JButton("Exit");
	
	//add buttons to panel
	panel.add(addButton);
	panel.add(viewButton);
	panel.add(updateButton);
	panel.add(deleteButton);
	panel.add(searchButton);
	panel.add(expiryButton);
	panel.add(reportButton);
	panel.add(exitButton);
	
	frame.add(panel);
	frame.setVisible(true);
	
	
//Buttons 
    
    viewButton.addActionListener(e -> {
    	GroceryDAO gdao = new GroceryDAO();
    	StringBuilder sb = new StringBuilder("ID | Name | Count | Expiry\n");
    	for(Grocery g: gdao.getAllGrocery()) {
    	sb.append(g.getId()).append(" | ")
    	  .append(g.getName()).append(" | ")
    	  .append(g.getName()).append(" | ")
    	  .append(g.getCount()).append(" | ")
    	  .append(g.getexpiryLeftIn()).append("\n");	
    	}
    	JOptionPane.showMessageDialog(frame, sb.toString(), "Groceries", JOptionPane.INFORMATION_MESSAGE);
    	
    });
    
    
    // 
    addButton.addActionListener(e -> {
        String name = JOptionPane.showInputDialog("Enter Grocery Name:");
        int count = Integer.parseInt(JOptionPane.showInputDialog("Enter Count:"));
        int expiry = Integer.parseInt(JOptionPane.showInputDialog("Enter Expiry Days:"));
        
        
        Grocery g = new Grocery();
        g.setName(name);
        g.setCount(count);
        g.setexpiryLeftIn(expiry);
        
        GroceryDAO gdao = new GroceryDAO();
        gdao.addGrocery(g);

        JOptionPane.showMessageDialog(frame, "Grocery Added Successfully!");
    });

    
 // Update grocery
    updateButton.addActionListener(e -> {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Grocery ID to Update:"));
        String name = JOptionPane.showInputDialog("Enter New Name:");
        int count = Integer.parseInt(JOptionPane.showInputDialog("Enter New Count:"));
        int expiry = Integer.parseInt(JOptionPane.showInputDialog("Enter New Expiry Days:"));

        Grocery g = new Grocery();
        g.setId(id);
        g.setName(name);
        g.setCount(count);
        g.setexpiryLeftIn(expiry);
        
        GroceryDAO gdao = new GroceryDAO();
        gdao.updateGrocery(g);

        JOptionPane.showMessageDialog(frame, "✅ Grocery Updated Successfully!");
    });

    // Delete grocery
    deleteButton.addActionListener(e -> {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Grocery ID to Delete:"));
        
        
        GroceryDAO gdao = new GroceryDAO();
        try {
			gdao.deleteGrocery(id);
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}

        JOptionPane.showMessageDialog(frame, "✅ Grocery Deleted Successfully!");
    });

    // Exit app
    exitButton.addActionListener(e -> {
        frame.dispose(); // close window
    });
	}

}
