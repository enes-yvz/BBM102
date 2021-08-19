
public class Worker extends FullTime {
	
	private int dayOfWorkSalary;
	private int overWorkSalary = 0;

	public Worker(String name, String surname, String registrationNumber, String position, int startYear, int firstWeek,
			int secondWeek, int thirdWeek, int fourthWeek) {
		super(name, surname, registrationNumber, position, startYear, firstWeek, secondWeek, thirdWeek, fourthWeek);
		
		this.dayOfWorkSalary= 20 * 105;
		
		int[] hours= {super.getFirstWeek(),super.getSecondWeek(),super.getThirdWeek(),super.getFourthWeek()};
		
		for (int hour:hours) {
			
			if (hour>40 && hour<=50) {
				
				this.overWorkSalary += (hour - 40) * 11;	
			}
			
			else if (hour>50){
				
				this.overWorkSalary += 10 * 11;
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
