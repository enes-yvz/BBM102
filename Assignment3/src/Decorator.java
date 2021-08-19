
public abstract class Decorator extends Operation {
	
	private Operation operation;
	
	public Decorator(Operation operation) {
		this.operation = operation;
	}
	
	public String printOperations() {
		return operation.printOperations();
	}

	public int cost() {
		return operation.cost();
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	
	public Operation getter() {
		return operation;	
	}
	
	
}
