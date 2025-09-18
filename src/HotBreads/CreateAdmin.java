package HotBreads;

public class CreateAdmin {
	
	public static void main(String[] args) {
	
		AuthDAO auth = new AuthDAO();
		
		String username = "admin";
		String password = "admin@123";
		String role = "admin";
		
		if(auth.createUser(username, password, role)) {
			System.out.println("Admin user created. Please change the password now.");
			
		}else {
			System.out.println("Failed to create admin (maybe already exists).");
		}
	}

}
