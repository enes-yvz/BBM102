
public class FacultyMember extends Academician {
	
	private int ssBenefits;
	
	private int addCourseFee = 0;
	
	public FacultyMember(String name, String surname, String registrationNumber, String position, int startYear,
			int firstWeek, int secondWeek, int thirdWeek, int fourthWeek) {
		super(name, surname, registrationNumber, position, startYear, firstWeek, secondWeek, thirdWeek, fourthWeek);
		
		this.ssBenefits=super.getBaseSalary()*135/100;
		
		int[] hours= {super.getFirstWeek(),super.getSecondWeek(),super.getThirdWeek(),super.getFourthWeek()};
		
		for (int hour:hours) {
		
			if (hour>40 && hour<=48) {
				
				this.addCourseFee += (hour - 40) * 20;	
			}
			
			else if (hour>48){
				
				this.addCourseFee += 8 * 20;
			}
		
		}
	}

	public int getSsBenefits() {
		return ssBenefits;
	}

	public int getAddCourseFee() {
		return addCourseFee;
	}
}
