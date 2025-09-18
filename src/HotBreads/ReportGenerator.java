package HotBreads;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class ReportGenerator {
	
	public static void exportExpiredGroceries(List<Grocery> groceries, String fileName) {
		try(FileWriter writer = new FileWriter(fileName)){
			writer.write("ID, Name, Count, Expiry\n");
			for(Grocery g : groceries) {
				writer.write(g.getId()+ ","+g.getName()+","+g.getCount()+","+g.getexpiryLeftIn()+"\n");
				
			}
			
			System.out.println("Report Generated: "+ fileName);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
