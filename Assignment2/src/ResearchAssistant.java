
public class ResearchAssistant extends Academician{
	
	private int ssBenefits;
	
	public ResearchAssistant(String name, String surname, String registrationNumber, String position, int startYear,
			int firstWeek, int secondWeek, int thirdWeek, int fourthWeek) {
		super(name, surname, registrationNumber, position, startYear, firstWeek, secondWeek, thirdWeek, fourthWeek);
		
		this.ssBenefits=super.getBaseSalary()*105/100;
	}

	public int getSsBenefits() {
		return ssBenefits;
	}
}
