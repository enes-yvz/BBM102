
public class MyQueue {
	
	private int value;
	
	private Node front;
	
	private Node rear;
	
	public MyQueue() {
		
		this.front=null;
		this.rear=null;
				
	}

	public int dequeue() {
		
		if (!isEmpty()) {
			
			if (front == rear){
	            
				rear = null;
	        }
			
			value = front.getData();
			
			front = front.getNext();
			
		}

		return value;
		
	}
	
	public void enqueue(int i) {
		
		Node node = new Node(i);
		
		if(rear == null){
			
            front = node;
            
            rear = front;
        }
		
        else {
        	
            rear.setNext(node);
            rear = node;
        }

	}
	
	public boolean isEmpty() {
		
		if(front == null && rear == null){
			
			return true;
		}
		
		else {
			
			return false;
		}
		
	}

}
