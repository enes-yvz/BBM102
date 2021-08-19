
public class MyStack {
	
	private int value;
	
	private Node head;

	public MyStack() {
		
		this.head = null;
		
	}
	
	public void push(int i) {
		
		Node node = new Node(i);
			
		if (head == null) {
			
            head = node;
            node.setNext(null);
        }
		
        else { 
        	
        	Node temp = head; 
        	head = node;
            node.setNext(temp);
        }
			
	}
	
	public int pop()  {
		
		if (!empty()) {
			
			value = head.getData();
			head = head.getNext();
		}
		
		return value;
		
	}
	
	public int peek() {
		
		if (!empty()) {
			
			value = head.getData();
		}
		
		return value;
			
	}
	
	public boolean empty() {
		
		if (head==null) {
			
			return true;
		}
		
		else {
			
			return false;
		}
		
	}
}