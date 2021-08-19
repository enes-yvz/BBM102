import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Integer> seats =new ArrayList<Integer>();
		ArrayList<Seat> seatList = new ArrayList<Seat>();
		ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
		ArrayList<Phone> phoneList = new ArrayList<Phone>();
		
		while (true) {
			
				Bus bus = new Bus("06 HUBM 06", 42,seats,seatList,passengerList,phoneList);
				bus.setPlate("06 HUBM 06");
				bus.setSeatCount(42);
				
				System.out.print  ("1-Book a seat\n"+
								   "2-Display all passengers with their seat numbers\n"+
								   "3-Display all avaliable seatIDs\n"+
								   "4-Search\n"+
								   "5-Exit\n"+
								   "Enter your choose: ");
				
				Scanner scanner = new Scanner(System.in);
				int choose = scanner.nextInt();
				
				if (choose==1) {
					System.out.print("Enter seat id:");
					int seatID =scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter name:");
					String name =scanner.nextLine();					
					System.out.print("Enter surname:");				
					String surname =scanner.nextLine();					
					System.out.print("Enter gender:");					
					String gender =scanner.nextLine();				
					Passenger passenger = new Passenger(name,surname,gender);
					passenger.setName(name);
					passenger.setSurname(surname);
					passenger.setGender(gender);
					bus.bookSeat(passenger, seatID);
				}
				
				if (choose==2) {
					bus.printAllPassengers();
						}
				if (choose==3) {
					bus.printAllAvailableSeatIDs();	
						}
				if (choose==4) {
					bus.search();	
						}
				if (choose==5) {
					break;		
						}		
		}
	}
}
