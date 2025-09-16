package HotBreads;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

public class main {

	public static void main(String[] args) throws SQLException {
		GroceryDAO gdao = new GroceryDAO();
		Scanner sc= new Scanner(System.in);
		
		while(true) {
			System.out.println("\n==== Restaurant Management System===");
			System.out.println("1. Add Grocery");
			System.out.println("2. View Groceries");
			System.out.println("3. Update grocery");
			System.out.println("4. Delete grocery");
			System.out.println("5. Search Grocery");
			System.out.println("6. Expiring Soon");
			System.out.println("7. Exit");
			System.out.println("Enter Choice: ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.print("Enter name: ");
				String name = sc.next();
				System.out.print("Enter count: ");
				int count = sc.nextInt();
				System.out.print("expiry_left_in: ");
				int expiry_left_in = sc.nextInt();
				
				gdao.addGrocery(new Grocery(name, count, expiry_left_in));
				break;
			case 2:
				List <Grocery> list = gdao.getAllGrocery();
				System.out.println("ID | Name | Count | Expiry");
				System.out.println("-------------------------------------");
				for(Grocery g:list) {
					System.out.println(g);
					
				}
				break;
				
			case 3:
				System.out.print("Enter id to update");
				int id = sc.nextInt();
				System.out.print("Enter new name");
				String newName = sc.next();
				System.out.print("Enter new count");
				int newCount = sc.nextInt();
				System.out.print("Enter new expiry_left_in");
				int newexpiryLeftIn = sc.nextInt();
				gdao.updateGrocery(new Grocery (id,  newName, newCount, newexpiryLeftIn));
				break;
				
			case 4:
				System.out.print("Enter ID to delete: ");
				int delId =sc.nextInt();
				gdao.deleteGrocery(delId);
				break;
			case 5:
				System.out.print("Enter keyword to search: ");
				String keyword = sc.next();
				List<Grocery> found = gdao.searchGroceriesByName(keyword);
				if(found.isEmpty()) {
					System.out.println("No groceries found for: "+keyword);
				} else {
					System.out.println("\nID | Name | Count | Expiry");
					for (Grocery g: found) {
						System.out.println(g);
						
					}
				}
				break;
				
			case 6:
				System.out.println("Enter number of days check: ");
				int days =  sc.nextInt();
				List<Grocery> expiring = gdao.getExpiringSoon(days);
				if(expiring.isEmpty()) {
					System.out.println("No groceries expiring within"+days+" days!");
				}else {
					System.out.println("\n Groceries expiring soon (within " +days +"days):");
					System.out.println("ID | Name | Count | Expiry");
					System.out.println("---------------------------------------");
					for(Grocery g: expiring) {
						System.out.println(g);
					}
				}
				break;
				
				
			case 7:
				System.out.print("exiting..");
				sc.close();
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid option!, try again!");
			}
		}
	}//main

}//class
