
public class Passenger {
	
	private String name;
	private String surname;
	private String gender;
	
	public Passenger(String name, String surname, String gender) {
		this.name = name;
		this.surname = surname;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public static void display(int i){
		
		System.out.println(Bus.getPassengerList().get(i).getName() +" "+ 
		Bus.getPassengerList().get(i).getSurname()+" "+"("+
		Bus.getPassengerList().get(i).getGender()+")");
	}
}
