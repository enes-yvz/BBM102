import java.util.ArrayList;
import java.util.Scanner;

public class Bus {
	
	Scanner scanner = new Scanner (System.in);
	
	private String plate;
	private int seatCount;
	private ArrayList<Integer> seats;
	private static ArrayList<Seat>seatList;
	private static ArrayList<Passenger> passengerList;
	private static ArrayList<Phone> phoneList;
	
	public Bus(String plate, int seatCount,ArrayList<Integer> seats,ArrayList<Seat> 
	seatList,ArrayList<Passenger> passengerList,ArrayList<Phone> phoneList) {
		this.plate = plate;
		this.seatCount = seatCount;
		this.seats =seats;
		this.seatList= seatList;
		this.passengerList = passengerList;
		this.phoneList= phoneList;
	}
	
	public void bookSeat(Passenger p,int seatID) {
		
		System.out.print("Enter country code:");
		String countryCode =scanner.nextLine();
		System.out.print("Enter code:");
		String code =scanner.nextLine();
		System.out.print("Enter number:");
		int number =scanner.nextInt();
		if (number>9999999 || number <1000000) {
			System.out.println("This is an invalid number");
			return;
		}
		scanner.nextLine();
		System.out.print("Enter type:");
		String type =scanner.nextLine();
		
		if (countryCode.equals("")) {
			countryCode =null;
		}
		
		if (seats.contains(seatID)) {
			System.out.println("The seat has already reserved!");
			return;
		}
		else {
			Phone phone = new Phone(countryCode,code,number,type);
			phone.setCountry_code(countryCode);
			phone.setCode(code);
			phone.setNumber(number);
			phone.setType(type);
			Seat seat = new Seat(seatID,true,p);
			seat.setSeatID(seatID);
			seat.setStatus(true);
		
			seatList.add(seat);
			passengerList.add(p);
			phoneList.add(phone);
			
			seats.add(seatID);
		}
		
	}
	
	public void printAllPassengers () {
		
		for (int i =0 ;i<seatList.size();i++) {
			Seat.display(i);
			Passenger.display(i);
			Phone.display(i);
			}
		}

	public void printAllAvailableSeatIDs() {
		
		for (int z=0; z<seatCount ;z++) {
			
			if (!seats.contains(z)) {
			System.out.print(" "+z+" ");
			
			}
		}
			
		System.out.println("");
	}
	
	public void search() {
		System.out.print("Enter name:");
		String name = scanner.nextLine();
		System.out.print("Enter surname:");
		String surname = scanner.nextLine();
		
		for (int i =0 ;i<passengerList.size();i++) {
			
			if (passengerList.get(i).getName().equals(name) && 
			passengerList.get(i).getSurname().equals(surname)) {
				
				System.out.println(passengerList.get(i).getName()+" "+
				passengerList.get(i).getSurname()+" ("+passengerList.get(i).getGender()+")");
				
				System.out.println(phoneList.get(i).getType()+" Phone:"+
				phoneList.get(i).getCode()+" "+phoneList.get(i).getCountry_code()+" "+
				phoneList.get(i).getNumber());				
			}
		}
	}
	
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public int getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public static ArrayList<Seat> getSeatList() {
		return seatList;
	}

	public static ArrayList<Passenger> getPassengerList() {
		return passengerList;
	}

	public static ArrayList<Phone> getPhoneList() {
		return phoneList;
	}
}
