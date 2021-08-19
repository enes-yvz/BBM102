
public class Security extends Personnel {
	
	private int hourOfWorkSalary = 0;
	private int transMoney = 0;
	private int foodMoney = 0;

	public Security(String name, String surname, String registrationNumber, String position, int startYear,
			int firstWeek, int secondWeek, int thirdWeek, int fourthWeek) {
		super(name, surname, registrationNumber, position, startYear, firstWeek, secondWeek, thirdWeek, fourthWeek);
		
		int[] hours= {super.getFirstWeek(),super.getSecondWeek(),super.getThirdWeek(),super.getFourthWeek()};
		
		for (int hour:hours) {
			
			if (hour>=30 && hour<=54) {
				
				this.hourOfWorkSalary += hour * 10;
				this.foodMoney += 6 * 10;
				this.transMoney += 6 * 5;
			}
			
			else if (hour>54){
				
				this.hourOfWorkSalary += 54 * 10;
				this.foodMoney += 6 * 10;
				this.transMoney += 6 * 5;
			}
		}
	}

	public int getHourOfWorkSalary() {
		return hourOfWorkSalary;
	}
	
	public int getTransMoney() {
		return transMoney;
	}

	public int getFoodMoney() {
		return foodMoney;
	}
}
