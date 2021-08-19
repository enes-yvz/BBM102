
public class Measurement extends Decorator{
	
	public Measurement(Operation operation) {
		super(operation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String printOperations() {
		Operation newOperation = super.getter();
		return newOperation.printOperations()+" measurements";
		// TODO Auto-generated method stub
		
	}

	@Override
	public int cost() {
		Operation newOperation = super.getter();
		return newOperation.cost() + 5;
		
	}
}
