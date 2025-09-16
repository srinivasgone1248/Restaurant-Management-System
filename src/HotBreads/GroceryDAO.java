package HotBreads;

import java.util.*;
import java.sql.*;
/*JDBC mini project: restaurant management system
 * 
 * hands-on-practice with everything: create, read, update, delete(CRUD)
 * 
 * 
 * */
public class GroceryDAO {
     private final String url = "jdbc:mysql://localhost:3306/hotbreads";
     private final String user = "root";
     private final String pass = "Nivas@1248";
     
     // add grocery 
     // its return nothing so, go with void
     
     public void addGrocery(Grocery grocery){
    	  String sql = "INSERT INTO grocery(name, count, expiry_left_in) VALUES (?,?,?)";
  //try and catch method for connection to sql 
    	  
    	  try(Connection con = DriverManager.getConnection(url,user,pass);
    		  PreparedStatement ps = con.prepareStatement(sql)){
    		  
    		  ps.setString(1, grocery.getName());
    		  ps.setInt(2, grocery.getCount());
    		  ps.setInt(3, grocery.getexpiryLeftIn());
    		  ps.executeUpdate();
    		  
    		  System.out.println("grocery/s is/are added successfully");
    		  
    	  }catch(SQLException e) {
    		  e.printStackTrace();
    		  
    	  }//catch
      }//void
     
     
     // Get all grocery list 
    public List<Grocery> getAllGrocery(){
    	List<Grocery> groceries = new ArrayList<>();
    	 String sql = "SELECT * FROM grocery";
    	 
    	 //	coonection for data base
    	 	try(Connection con = DriverManager.getConnection(url, user, pass);
    	 		Statement st = con.createStatement();
    	 		ResultSet rs = st.executeQuery(sql)){
    	 		
//    	 		System.out.println("\n Grocery List: ");
//    	 		System.out.printf("%-5s %-15s %-10s %-15s%n", "ID", "Name", "Count", "Expiry_in");
    	 		while(rs.next()) {
    	 			//System.out.printf("%-5d %-15s %-10d %-15d%n",
    	 					    Grocery g = new Grocery(rs.getInt("id"),
    	 		                      rs.getString("name"),
    	 			                  rs.getInt("count"),
    	 		                      rs.getInt("expiry_left_in")
    	 		                      );//g
    	 					    groceries.add(g);
    	 			
    	 		}//while
    	 		
    	 		
    	 		
    	 	}catch(SQLException e) {
    	 		e.printStackTrace();
    	 	}//catch
    	 	return groceries;
     }//getAll
    
    
    //Update grocery
    public void updateGrocery(Grocery grocery){
          String sql = "UPDATE grocery SET name=?, count=?, expiry_left_in=? WHERE id=?";    	
          try(Connection con = DriverManager.getConnection(url, user, pass);
        	  PreparedStatement ps = con.prepareStatement(sql)){
        	 
        	  ps.setString(1, grocery.getName());
        	  ps.setInt(2, grocery.getCount());
        	  ps.setInt(3, grocery.getexpiryLeftIn());
        	  ps.setInt(4, grocery.getId());
        	  
        	  int rows = ps.executeUpdate();
        	  
        	  if(rows>0) {
        		  System.out.println("grocery updated successfully");
        		  }else {System.out.println("grocery not found!");}
          }catch(SQLException e) {
        	  e.printStackTrace();
          }//trycatch   
    
    
    }//updateGrocery

    // Delete grocery
    
    public void deleteGrocery(int id) throws SQLException {
    	String sql = "DELETE FROM grocery WHERE id=?";
    	try(Connection con = DriverManager.getConnection(url, user, pass);
    		PreparedStatement ps = con.prepareStatement(sql)){
    		ps.setInt(1, id);
    		int rows = ps.executeUpdate();
    		if(rows >0) {
    			System.out.println("grocery deleted successfully");
    			
    		}else {System.out.println("grocery not found");}
    	}catch(SQLDataException e) {e.printStackTrace();}
    }
    
  // search grocery by name   
    public List<Grocery> searchGroceriesByName(String keyword){
    	List<Grocery> groceries = new ArrayList<>();
    	String sql = "SELECT * FROM grocery WHERE name LIKE ?";
    	
    	try(Connection con = DriverManager.getConnection(url, user, pass);
    			PreparedStatement ps = con.prepareStatement(sql)){
    		
    		ps.setString(1, "%" + keyword + "%");
    		ResultSet rs = ps.executeQuery();
    		
    	    while (rs.next()) {
    	    	Grocery g = new Grocery(
    	    			rs.getInt("id"),
    	    			rs.getString("name"),
    	    			rs.getInt("count"),
    	    			rs.getInt("expiry_left_in"));
    	    	groceries.add(g);
    	    }	
    	}catch(SQLException e ) {e.printStackTrace();}
    return groceries;
    }
    
    // expiring soon groceries 
    
    public List<Grocery> getExpiringSoon(int days){
    	List<Grocery> groceries = new ArrayList<>();
    	String sql = "SELECT *FROM grocery WHERE expiry_left_in <? ORDER BY expiry_left_in ASC";
    	
    	try(Connection con = DriverManager.getConnection(url,user,pass);
    	PreparedStatement ps = con.prepareStatement(sql)){
    		ps.setInt(1,  days);
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()) {
    			Grocery g = new Grocery(
    					rs.getInt("id"),
    					rs.getString("name"),
    					rs.getInt("count"),
    					rs.getInt("expiry_left_in")
    					);
    			groceries.add(g);
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return groceries;
    }
}//class 
