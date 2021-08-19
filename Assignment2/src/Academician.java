
public class Academician extends Personnel {

	private int baseSalary;
	
	public Academician(String name, String surname, String registrationNumber, String position, int startYear,
			int firstWeek, int secondWeek, int thirdWeek, int fourthWeek) {
		super(name, surname, registrationNumber, position, startYear, firstWeek, secondWeek, thirdWeek, fourthWeek);
		
		this.baseSalary= 2600;
		
	}
	
	public int getBaseSalary() {
		return baseSalary;
	}

}
