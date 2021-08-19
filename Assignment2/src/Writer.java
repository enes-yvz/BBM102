import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	
	public static void writer(String name, String surname, String registrationNumber, String position, int startYear,double salary) {
		FileWriter fileWriter =null;
		try {
			fileWriter = new FileWriter(registrationNumber+".txt");
			String article= "Name : "+name+"\n"+"Surname : "+surname+"\n"+
							"Registration Number : "+registrationNumber+"\n"+"Position : "+position+
							"\n"+"Year of Start : "+Integer.toString(startYear)+"\n"+"Total Salary : "+Double.toString(salary)+"0 TL";
			fileWriter.write(article);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(fileWriter !=null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
		}	
	}
}
