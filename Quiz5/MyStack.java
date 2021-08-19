
public class MyStack {
	
	private int value;
	
	private Node root;

	public MyStack() {
		
		this.root = null;
		
	}
	
	public void push(int i) {
		
		Node node = new Node(i);
		
		if (!isFull()) {
			
			if (root == null) {
				
	            root = node;
	            node.setNext(null);
	        }
			
	        else { 
	        	
	        	Node temp = root; 
	        	root = node;
	            node.setNext(temp);
	        }
			
		}
		
	}
	
	public int pop()  {
		
		if (!isEmpty()) {
			
			value = root.getData();
			root = root.getNext();
		}
		
		return value;
		
	}
	
	public int top() {
		
		if (!isEmpty()) {
			
			value = root.getData();
		}
		
		return value;
			
	}
	
	public boolean isFull() {
		
		if (size()<=10) {
			
			return false;
		}
		
		else {
			
			return true;
		}
		
	}
	
	public boolean isEmpty() {
		
		if (root==null) {
			
			return true;
		}
		
		else {
			
			return false;
		}
		
	}
	
	public int size() {
		
		if (isEmpty()) {
			
			return 0;
			
		}
		
		else {
			
			int count = 0;
			
			Node temp = root; 
			
			while(!(temp==null)) {
				
				count++;
				temp= temp.getNext();
				
			}
			return count;
		}
	}
}
