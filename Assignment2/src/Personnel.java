
public class Personnel {
	
	private String name;
	private String surname;
	private String registrationNumber;
	private String position;
	private int startYear;
	private int firstWeek;
	private int secondWeek;
	private int thirdWeek;
	private int fourthWeek;
	private double severancePay;
	private double salary;

	public Personnel(String name, String surname, String registrationNumber, String position, int startYear,
			int firstWeek, int secondWeek, int thirdWeek, int fourthWeek) {
		this.name = name;
		this.surname = surname;
		this.registrationNumber = registrationNumber;
		this.position = position;
		this.startYear = startYear;
		this.firstWeek = firstWeek;
		this.secondWeek = secondWeek;
		this.thirdWeek = thirdWeek;
		this.fourthWeek = fourthWeek;
		this.severancePay = (2020 - startYear)*20*0.8;
	}
	
	public void selector() {
		
		if (position.equals("FACULTY_MEMBER")) {
			
			FacultyMember facultyMember = new FacultyMember(name, surname, registrationNumber, position, startYear, firstWeek, secondWeek, thirdWeek, fourthWeek);
			setSalary(facultyMember.getBaseSalary() + facultyMember.getSsBenefits() + facultyMember.getSeverancePay() + facultyMember.getAddCourseFee());
		}
		
		else if (position.equals("RESEARCH_ASSISTANT")) {
			
			ResearchAssistant researchAssistant = new ResearchAssistant(name, surname, registrationNumber, position, startYear, firstWeek, secondWeek, thirdWeek, fourthWeek);
			setSalary(researchAssistant.getBaseSalary() + researchAssistant.getSsBenefits() + researchAssistant.getSeverancePay());
		}
		
		else if (position.equals("OFFICER")) {
			
			Officer officer = new Officer(name, surname, registrationNumber, position, startYear, firstWeek, secondWeek, thirdWeek, fourthWeek);
			setSalary(officer.getBaseSalary() + officer.getSsBenefits() + officer.getSeverancePay() + officer.getOverWorkSalary());
		}
		
		else if (position.equals("PARTTIME_EMPLOYEE")) {
			
			PartTime partTime = new PartTime(name, surname, registrationNumber, position, startYear, firstWeek, secondWeek, thirdWeek, fourthWeek);
			setSalary(partTime.getSeverancePay() + partTime.getHourOfWorkSalary());
		}
		
		else if (position.equals("CHIEF")) {
			
			Chief chief = new Chief(name, surname, registrationNumber, position, startYear, firstWeek, secondWeek, thirdWeek, fourthWeek);
			setSalary(chief.getSeverancePay() + chief.getDayOfWorkSalary() + chief.getOverWorkSalary());
		}
		
		else if (position.equals("WORKER")) {
			
			Worker worker = new Worker(name, surname, registrationNumber, position, startYear, firstWeek, secondWeek, thirdWeek, fourthWeek);
			setSalary(worker.getSeverancePay() + worker.getDayOfWorkSalary() + worker.getOverWorkSalary());
		}
		
		else if (position.equals("SECURITY")) {
			
			Security security = new Security(name, surname, registrationNumber, position, startYear, firstWeek, secondWeek, thirdWeek, fourthWeek);
			setSalary(security.getSeverancePay() + security.getHourOfWorkSalary() + security.getTransMoney() + security.getFoodMoney());
		}
		
		Writer.writer(name, surname, registrationNumber, position, startYear,getSalary()); 
	}

	public int getFirstWeek() {
		return firstWeek;
	}

	public int getSecondWeek() {
		return secondWeek;
	}

	public int getThirdWeek() {
		return thirdWeek;
	}

	public int getFourthWeek() {
		return fourthWeek;
	}
	
	public double getSeverancePay() {
		return severancePay;
	}

	public void setSeverancePay(double severancePay) {
		this.severancePay = severancePay;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
