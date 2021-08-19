
public class Phone {
	
	private String country_code;
	private String code;
	private int number;
	private String type;
	
	public Phone(String country_code, String code, int number, String type) {
		this.country_code = country_code;
		this.code = code;
		this.number = number;
		this.type = type;
	}

	public Phone(String code, int number, String type) {
		this.country_code = "+90";
		this.code = code;
		this.number = number;
		this.type = type;
	}

	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		if (country_code==null) {	
		this.country_code = "+90";	
		}
		else {
		this.country_code = country_code;
		}
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public static void display(int i) {
			
			System.out.println(Bus.getPhoneList().get(i).getType()+" Phone:"+ 
			Bus.getPhoneList().get(i).getCode() +" "+Bus.getPhoneList().get(i).getCountry_code()
			+" "+Bus.getPhoneList().get(i).getNumber());
	}
}
