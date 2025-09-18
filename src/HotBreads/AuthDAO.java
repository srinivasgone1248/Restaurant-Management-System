package HotBreads;


import java.sql.*;

public class AuthDAO {

	private final String url = "jdbc:mysql://localhost:3306/hotbreads";
	private final String user = "root";
	private final String pass = "Nivas@1248";
	
	//create a new user admin
	
	public boolean createUser(String username, String plainPassword, String role) {
		
		if(userExists(username)) {
			System.out.println("User already exists: "+ username);
			return false;
		}
		String sql = "INSERT INTO users(username, password_hash, salt, role) VALUES (?,?,?,?)";
		String salt = PasswordUtils.generatesalt();
		String hash = PasswordUtils.hashPassword(plainPassword, salt);
		
		
		
		try(Connection con = DriverManager.getConnection(url, user,pass);
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, username);
			ps.setString(2, hash);
			ps.setString(3, salt);
			ps.setString(4, role);
			ps.executeUpdate();
			System.out.println("User Created: "+username);
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	// check whether user name exists
	
	public boolean userExists(String username) {
		
		String sql = "SELECT id FROM users WHERE username = ?";
		try(Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1,  username);
			try(ResultSet rs = ps.executeQuery()){
				return rs.next();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//Authenticate credentials
	
	public boolean authenticate(String username, String plainPassword) throws SQLException {
		String sql = "SELECT password_hash, salt FROM users WHERE username = ?";
		try(Connection con = DriverManager.getConnection(url, user,pass);
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, username);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					String storeHash = rs.getString("password_hash");
					String salt = rs.getString("salt");
					return PasswordUtils.verifyPassword(plainPassword, salt, storeHash);
					
					
				}else {
					return false;
				}
			}catch(SQLException e) {
					e.printStackTrace();
					return false;
			}
		}
		
	}
}
