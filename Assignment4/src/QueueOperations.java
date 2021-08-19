
import java.util.Random;

public class QueueOperations {
	
	private MyQueue firstQueue;
	
	private MyQueue secondQueue = new MyQueue();
	
	private MyQueue thirdQueue = new MyQueue();
	
	private MyQueue fourthQueue = new MyQueue();
	
	private MyQueue fifthQueue = new MyQueue();
	
	public QueueOperations(MyQueue firstQueue) {
		this.firstQueue = firstQueue;
	}

	public String print() {
		
		String total = "";
		
		while (!firstQueue.isEmpty()) {
			
			int element = firstQueue.dequeue();
			
			total += element + " ";
			
			secondQueue.enqueue(element);
						
		}
		
		while (!secondQueue.isEmpty()) {
			
			firstQueue.enqueue(secondQueue.dequeue());
			
		}
		
		total = total.trim();
		
		return total;
	}
	
	public void removeGreater(int i) {
		
		while (!firstQueue.isEmpty()) {
			
			int element = firstQueue.dequeue();
			
			if (element<=i) {
				
				secondQueue.enqueue(element);
			}	
		}
		
		while (!secondQueue.isEmpty()) {
			
			firstQueue.enqueue(secondQueue.dequeue());
			
		}
	}
	
	public int calculateDistance() {
		
		int total =0;
		
		while (!firstQueue.isEmpty()) {
			
			int element = firstQueue.dequeue();
			
			thirdQueue.enqueue(element);
			
			while (!firstQueue.isEmpty()) {
				
				int temp = firstQueue.dequeue();
				
				total += Math.abs(element-temp);
				
				secondQueue.enqueue(temp);
			}
			
			while (!secondQueue.isEmpty()) {
				
				firstQueue.enqueue(secondQueue.dequeue());
				
			}
	
		}
		
		while (!thirdQueue.isEmpty()) {
			
			firstQueue.enqueue(thirdQueue.dequeue());
			
		}
		
		return total;

	}
	
	public void addOrRemove(int i) {
		
		if (i<0) {
			
			i = Math.abs(i);
			
			for (int k =0 ; k<i; k++) {
				
				if (!firstQueue.isEmpty()) {
					
					firstQueue.dequeue();
					
				}
				
			}
		}
		
		else if (i>0) {
			
			Random random = new Random();
			
			for (int k =0 ; k<i; k++) {
				
				int randomNumber = random.nextInt(49);
				
				randomNumber +=1;
				
				firstQueue.enqueue(randomNumber);
			}	
			
		}
		
	}
	
	public void reverse(int i) {
		
		MyStack stack = new MyStack();
		
		int size = 0;
		
		while (!firstQueue.isEmpty()) {
			
			size++;
			
			secondQueue.enqueue(firstQueue.dequeue());
						
		}
		
		while(!secondQueue.isEmpty()) {
			
			firstQueue.enqueue(secondQueue.dequeue());
			
		}
		
		if (!firstQueue.isEmpty()) {
			
			if (size<i ) {
				
				i = size;
					
			}
				
			for(int k =0; k<i; k++) {
				
				stack.push(firstQueue.dequeue());
				
			}
			
			while (!stack.empty()) {
				
				secondQueue.enqueue(stack.pop());
			}
			
			while (!firstQueue.isEmpty()) {
				
				secondQueue.enqueue(firstQueue.dequeue());
			}
			
			while (!secondQueue.isEmpty()) {
				
				firstQueue.enqueue(secondQueue.dequeue());
				
			} 
				
		}	
		
	}
	
	public void sorting() {
		
		while (!firstQueue.isEmpty()) {
			
			int smallest = firstQueue.dequeue();
			
			secondQueue.enqueue(smallest);
				
			while (!firstQueue.isEmpty()) {
				
				int temp = firstQueue.dequeue();
				
				secondQueue.enqueue(temp);
				
				if (smallest<temp) {
					
					
				}
				
				else {
					
					smallest = temp;
				}
				
			}
			
			while (!secondQueue.isEmpty()) {
				
				int control =secondQueue.dequeue();
				
				if (control==smallest) {
					
					thirdQueue.enqueue(control);
					
				}
				
				else {
					
					firstQueue.enqueue(control);
					
				}
				
			}
			
		}
		
		while (!thirdQueue.isEmpty()) {
			
			firstQueue.enqueue(thirdQueue.dequeue());
		}
		
	}	
	
	public int distinctElements() {
		
		while (!firstQueue.isEmpty()) {
			
			int element = firstQueue.dequeue();
			
			fourthQueue.enqueue(element);
			
			fifthQueue.enqueue(element);
			
		}
		
		while (!fourthQueue.isEmpty()) {
			
			firstQueue.enqueue(fourthQueue.dequeue());
			
		}
		
		int total= 0;
		
		while (!firstQueue.isEmpty()) {
			
			int element = firstQueue.dequeue();
			
			thirdQueue.enqueue(element);
			
			while (!firstQueue.isEmpty()) {
				
				int temp = firstQueue.dequeue();
				
				if (element==temp) {
					
				}
				
				else {
					
					secondQueue.enqueue(temp);
				}
			}
			
			while (!secondQueue.isEmpty()) {
				
				firstQueue.enqueue(secondQueue.dequeue());
				
			}
				
		}
		
		while (!thirdQueue.isEmpty()) {
			
			thirdQueue.dequeue();
			
			total +=1;
			
		}
		
		while (!fifthQueue.isEmpty()) {
			
			firstQueue.enqueue(fifthQueue.dequeue());
			
		}
		
		return total;	
		
	}
	
}	
	
