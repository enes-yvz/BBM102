
public class PartTime extends Employee {
	
	private int hourOfWorkSalary = 0;

	public PartTime(String name, String surname, String registrationNumber, String position, int startYear,
			int firstWeek, int secondWeek, int thirdWeek, int fourthWeek) {
		super(name, surname, registrationNumber, position, startYear, firstWeek, secondWeek, thirdWeek, fourthWeek);
		
		int[] hours= {super.getFirstWeek(),super.getSecondWeek(),super.getThirdWeek(),super.getFourthWeek()};
		
		for (int hour:hours) {
			
			if (hour>=10 && hour<=20) {
				
				this.hourOfWorkSalary += hour * 18;	
			}
			
			else if (hour>20){
				
				this.hourOfWorkSalary += 20 * 18;
			}
		}
	}

	public int getHourOfWorkSalary() {
		return hourOfWorkSalary;
	}
}
