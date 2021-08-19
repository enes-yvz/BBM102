
public class Contact implements Comparable<Contact>{
	
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;

	public Contact(String phoneNumber, String firstName, String lastName, String socialSecurityNumber) {
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	@Override
	public int compareTo(Contact contact) {
		
		long first = Long.parseLong(this.phoneNumber.replaceAll("-", ""));
		long second = Long.parseLong(contact.getPhoneNumber().replaceAll("-", ""));
		
		if (first>second) {
			return 1;
		}
		
		else if(first<second) {	
			return -1;
		}
		
		return 0;
	}

}
