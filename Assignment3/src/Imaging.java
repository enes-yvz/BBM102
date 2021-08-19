
public class Imaging extends Decorator {
	
	public Imaging(Operation operation) {
		super(operation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String printOperations() {
		Operation newOperation = super.getter();
		return newOperation.printOperations()+" imaging";
		// TODO Auto-generated method stub
		
	}

	@Override
	public int cost() {
		Operation newOperation = super.getter();
		return newOperation.cost() + 10;
		
	}

}
