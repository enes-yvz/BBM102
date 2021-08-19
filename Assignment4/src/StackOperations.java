
import java.util.Random;

public class StackOperations {
	
	private MyStack firstStack;
	
	private MyStack secondStack = new MyStack();
	
	private MyStack thirdStack = new MyStack ();
	
	private MyStack fourthStack = new MyStack();
	
	private MyStack	fifthStack = new MyStack();
	
	public StackOperations(MyStack firstStack) {
		this.firstStack = firstStack;
	}
	
	public String display() {
		
		String total = "";
		
		while (!firstStack.empty()) {
			
			int element = firstStack.pop();
			
			total += element + " ";
			
			secondStack.push(element);
						
		}
		
		while(!secondStack.empty()) {
			
			firstStack.push(secondStack.pop());
		}
		
		total = total.trim();
		
		return total;
	}

	public void removeGreater(int i) {
		
		while (!firstStack.empty()) {
			
			int element = firstStack.pop();
			
			if (element<=i) {
				
				secondStack.push(element);
				
			}
			
		}
		
		while(!secondStack.empty()) {
			
			firstStack.push(secondStack.pop());
		}
		
		
	}
	
	public int calculateDistance() {
		
		int total = 0;
		
		while (!firstStack.empty()) {
			
			int element = firstStack.pop();
			
			thirdStack.push(element);
			
			while (!firstStack.empty()) {
				
				int temp = firstStack.pop();
				
				total += Math.abs(element - temp);
				
				secondStack.push(temp);
				
			}
			
			while(!secondStack.empty()) {
				
				firstStack.push(secondStack.pop());
			}
			
		}
		
		while(!thirdStack.empty()) {
			
			firstStack.push(thirdStack.pop());	
			
		}
		
		return total;
		
		
	}
	
	public void addOrRemove(int i) {
		
		if (i<0) {
			
			i = Math.abs(i);
			
			for (int k =0 ; k<i; k++) {
				
				if (!firstStack.empty()) {
					
					firstStack.pop();
					
				}
			}
		}
		
		else if (i>0) {
			
			Random random = new Random();
			
			for (int k =0 ; k<i; k++) {
				
				int randomNumber = random.nextInt(49);
				
				randomNumber++;
				
				firstStack.push(randomNumber);
			}
			
			
		}
		
	}
	
	public void reverse(int i) {
		
		int size = 0;
		
		while (!firstStack.empty()) {
			
			size++;
			
			secondStack.push(firstStack.pop());
						
		}
		
		while(!secondStack.empty()) {
			
			firstStack.push(secondStack.pop());
		}
		
		if (!firstStack.empty()) {
			
			if (size<i ) {
				
				i = size;
				
			}
				
			for(int k =0; k<i; k++) {
				
				secondStack.push(firstStack.pop());
			}
			
			for(int k =0; k<i; k++) {
				
				thirdStack.push(secondStack.pop());
			}
			
			for(int k =0; k<i; k++) {
				
				firstStack.push(thirdStack.pop());
			}	
	
		}
		
	}
	
	public void sorting() {
		
		while (!firstStack.empty()) {
			
			int temp = firstStack.pop();
			
			while (!secondStack.empty() && secondStack.peek()>temp) {
				
				firstStack.push(secondStack.pop());
				
			}
			
			secondStack.push(temp);
			
		}
		
		while (!secondStack.empty()) {
			
			firstStack.push(secondStack.pop());
		}
	
	}
	
	public int distinctElements() {
		
		while (!firstStack.empty()) {
			
			int element = firstStack.pop();
			
			fourthStack.push(element);
			
			fifthStack.push(element);
			
		}
		
		while (!fourthStack.empty()) {
			
			firstStack.push(fourthStack.pop());
			
		}
		
		int total= 0;
		
		while (!firstStack.empty()) {
			
			int element = firstStack.pop();
			
			thirdStack.push(element);
			
			while (!firstStack.empty()) {
				
				int temp = firstStack.pop();
				
				if (element==temp) {
					
					
				}
				
				else {
					
					secondStack.push(temp);
				}
				
			}
			
			while(!secondStack.empty()) {
				
				firstStack.push(secondStack.pop());
			}
			
		}
		
		while (!thirdStack.empty()) {
			
			thirdStack.pop();
			
			total++;
						
		}
		
		while (!fifthStack.empty()) {
			
			firstStack.push(fifthStack.pop());
			
		}
		
		return total;
		
	}
	

}
