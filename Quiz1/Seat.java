public class Seat {
	
	private int seatID;
	private boolean status;
	private Passenger passenger;
	
	public Seat(int seatID, boolean status,Passenger passenger) {
		
		this.seatID = seatID;
		this.status = status; 
		this.passenger = passenger;
	}
	public int getSeatID() {
		return seatID;
	}	
	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public static void display(int i) {
		
			System.out.print("Seat: " + Bus.getSeatList().get(i).getSeatID() + " ");
			
		if (Bus.getSeatList().get(i).getStatus()==true) {
			System.out.print("Status: Reserved"+"\n");
		}
		else {
			System.out.print("Status: Nonreserved"+"\n");	
			}
	}
}
