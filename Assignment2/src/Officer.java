
public class Officer extends Personnel {
	
	private int baseSalary;
	
	private int ssBenefits;
	
	private int overWorkSalary = 0;

	public Officer(String name, String surname, String registrationNumber, String position, int startYear,
			int firstWeek, int secondWeek, int thirdWeek, int fourthWeek) {
		super(name, surname, registrationNumber, position, startYear, firstWeek, secondWeek, thirdWeek, fourthWeek);
		
		this.baseSalary = 2600;
		this.ssBenefits= baseSalary * 65 / 100;
		
		int[] hours= {super.getFirstWeek(),super.getSecondWeek(),super.getThirdWeek(),super.getFourthWeek()};
		
		for (int hour:hours) {
			
			if (hour>40 && hour<=50) {
				
				this.overWorkSalary += (hour - 40) * 20;	
			}
			
			else if (hour>50){
				
				this.overWorkSalary += 10 * 20;
			}
		}
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public int getSsBenefits() {
		return ssBenefits;
	}

	public int getOverWorkSalary() {
		return overWorkSalary;
	}

}
