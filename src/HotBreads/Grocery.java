package HotBreads;

public class Grocery {
     private int id;
     private String name;
     private int count;
     private int expiryLeftIn;

     // Constructors
     
     public Grocery() {}
     
     public Grocery(int id, String name, int count, int expiryLeftIn) {
    	 this.id =id;
    	 this.name=name;
    	 this.count=count;
    	 this.expiryLeftIn=expiryLeftIn;
     }
     
     public Grocery(String name, int count, int expiryLeftIn) {
    	 this.name = name;
    	 this.count = count;
    	 this.expiryLeftIn = expiryLeftIn;
     }
     
     //Getters and Setters
     public int getId() {return id;}
     public void setId(int id) {this.id=id;}
     
     public String getName() {return name;}
     public void setName(String name) {this.name=name;}
     
     public int getCount() {return count;}
     public void setCount(int count) {this.count=count;}
     
     public int getexpiryLeftIn() {return expiryLeftIn;}
     public void setexpiryLeftIn(int expiryLeftIn) {this.expiryLeftIn=expiryLeftIn;}
     
     @Override
     public String toString() {
    	 if(expiryLeftIn < 30) {
    		 return ConsoleColors.RED+ id +"|"+name + "|"+count + "|"+ expiryLeftIn+"days"+ConsoleColors.RESET;
    	 }else if (expiryLeftIn < 60) {
    		 return ConsoleColors.YELLOW + id +"|"+name + "|"+count + "|"+ expiryLeftIn+"days"+ConsoleColors.RESET;
    	 }else {
    		 return ConsoleColors.GREEN+ id +"|"+name + "|"+count + "|"+ expiryLeftIn+"days"+ConsoleColors.RESET;
    	 }
    	 	 
     }
     
}
