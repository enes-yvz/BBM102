
public class Chief extends FullTime {
	
	private int dayOfWorkSalary;
	private int overWorkSalary = 0;

	public Chief(String name, String surname, String registrationNumber, String position, int startYear, int firstWeek,
			int secondWeek, int thirdWeek, int fourthWeek) {
		super(name, surname, registrationNumber, position, startYear, firstWeek, secondWeek, thirdWeek, fourthWeek);
		
		this.dayOfWorkSalary= 20 * 125;
		
		int[] hours= {super.getFirstWeek(),super.getSecondWeek(),super.getThirdWeek(),super.getFourthWeek()};
		
		for (int hour:hours) {
		
			if (hour>40 && hour<=48) {
				
				this.overWorkSalary += (hour - 40) * 15;	
			}
			
			else if (hour>48){
				
				this.overWorkSalary += 8 * 15;
			}
		
		}
	}

	public int getDayOfWorkSalary() {
		return dayOfWorkSalary;
	}

	public int getOverWorkSalary() {
		return overWorkSalary;
	}
}
