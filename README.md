 🍽️ Restaurant Management System  

This is a  Java + JDBC mini-project  that simulates how a restaurant store room works.  
It provides a simple  menu-driven application  to manage groceries in the restaurant.  



   ✨ Features
- 📦  Add Grocery  → Add new grocery items (with name, count, and expiry days left).  
- 📋  View All Groceries  → Display a list of all groceries with details like:
  - ID  
  - Name  
  - Count  
  - Expiry left (in days)  
- ✏️  Update Grocery  → Update grocery details (name, count, expiry).  
- ❌  Delete Grocery  → Remove a grocery by ID.  
- 🔎  Search Grocery  → Search groceries by name.  
- ⚠️  Expiry Alert  → Groceries that are  expiring soon  are highlighted in  red  for quick attention.  



   🛠️ Tech Stack
-  Language : Java (Core Java + JDBC)  
-  Database : MySQL  
-  IDE : Eclipse / VS Code  
-  Build Tool : Plain Java (no Maven/Gradle)  



   📂 Project Structure
RestaurantManagement/
│── src/
│ └── HotBreads/
│ ├── main.java   Menu-driven main application
│ ├── GroceryDAO.java   Data Access Object (CRUD operations)
│── database/
│ └── grocery.sql   SQL schema and sample data
│── README.md



   🚀 How to Run
1. Clone this repo:
    
   git clone https://github.com/yourusername/RestaurantManagement.git
   cd RestaurantManagement

2.  Import the project into Eclipse or VS Code.
3.  Make sure MySQL is running and a database is created:
CREATE DATABASE hotbreads;
USE hotbreads;
CREATE TABLE grocery (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    count INT,
    expiry_left_in INT
);
4.  Update DB credentials in GroceryDAO.java.
5.  Run the main.java file.



📖 Future Enhancements
•	✅ Add authentication (admin login).
•	✅ Generate reports for expired groceries.
•	✅ Add a GUI with JavaFX / Swing for better user experience.
•	✅ Containerize with Docker and deploy to the cloud.

👨‍💻 Author
•	Srinivas Gone



🌟 Contributing
•	Contributions are welcome!
Fork the repo → Create a new branch → Make changes → Submit a Pull Request 🚀


📜 License
•	This project is open-source and available under the MIT License.



