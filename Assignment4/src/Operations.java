
public class Operations {
	
	private MyStack myStack = new MyStack();
	
	private MyQueue myQueue = new MyQueue();
	
	private String[] stackParts;
	
	private String[] queueParts;
	
	public void operation(String[] list) {
		
		String[] stack = ReadFromFile.readFile("stack.txt");
		
		if (stack.length>0) {
			
			stackParts = stack[0].split(" ");
			
			for(int f =stackParts.length-1 ; f>=0 ;f -- ) {
				
				myStack.push(Integer.parseInt(stackParts[f]));
				
			}
			
		}
		
		String[] queue = ReadFromFile.readFile("queue.txt");
		
		if (queue.length>0) {
			
			queueParts = queue[0].split(" ");	
			
			for (String i: queueParts) {
				
				myQueue.enqueue(Integer.parseInt(i));
				
			}
			
		}
		
		StackOperations stackOperation = new StackOperations(myStack);
		
		QueueOperations queueOperation = new QueueOperations(myQueue);
		
		String totalStack = "" ;
		
		String totalQueue = "" ;
		
		for(String i: list) {
			
			String[] parts = i.split(" ");
			
			if (parts[0].equals("Q")) {
				
				if (parts[1].equals("removeGreater")) {
					
					queueOperation.removeGreater(Integer.parseInt(parts[2]));
					
					totalQueue += "After removeGreater " + parts[2] + ":" + "\n" ;
					
					totalQueue += queueOperation.print() + "\n" ;
					
				}
				
				else if (parts[1].equals("calculateDistance")) {
					
					totalQueue += "After calculateDistance:"+ "\n" ;
					
					totalQueue += "Total distance= "+queueOperation.calculateDistance() + "\n" ;
					
				}
				
				else if (parts[1].equals("addOrRemove")) {
					
					queueOperation.addOrRemove(Integer.parseInt(parts[2]));
					
					totalQueue += "After addOrRemove " + parts[2] + ":" + "\n" ;
					
					totalQueue += queueOperation.print() + "\n" ;
					
				}
				
				else if (parts[1].equals("reverse")) {
					
					queueOperation.reverse(Integer.parseInt(parts[2]));
					
					totalQueue += "After reverse " + parts[2] + ":" + "\n" ;
					
					totalQueue += queueOperation.print() + "\n" ;
					
				}
				
				else if (parts[1].equals("sortElements")) {
					
					queueOperation.sorting();
					
					totalQueue += "After sortElements:" + "\n" ;
					
					totalQueue += queueOperation.print() + "\n" ;
					
				}
				
				else if (parts[1].equals("distinctElements")) {
					
					totalQueue += "After distinctElements:" + "\n" ;
					
					totalQueue += "Total distinct element=" +queueOperation.distinctElements() + "\n";
						
				}
				
			}
			
			else if (parts[0].equals("S")) {
				
				if (parts[1].equals("removeGreater")) {
					
					stackOperation.removeGreater(Integer.parseInt(parts[2]));
					
					totalStack += "After removeGreater " + parts[2] + ":" + "\n" ;
					
					totalStack += stackOperation.display() + "\n" ;
					
				}
				
				else if (parts[1].equals("calculateDistance")) {
					
					totalStack += "After calculateDistance:"+ "\n" ;
					
					totalStack += "Total distance=" + stackOperation.calculateDistance() + "\n" ;
				}
				
				else if (parts[1].equals("addOrRemove")) {
					
					stackOperation.addOrRemove(Integer.parseInt(parts[2]));
					
					totalStack += "After addOrRemove " + parts[2] + ":" + "\n" ;
					
					totalStack += stackOperation.display() + "\n" ;
				}
				
				else if (parts[1].equals("reverse")) {
					
					stackOperation.reverse(Integer.parseInt(parts[2]));
					
					totalStack += "After reverse " + parts[2] + ":" + "\n" ;
					
					totalStack += stackOperation.display() + "\n" ;
					
				}
				
				else if (parts[1].equals("sortElements")) {
					
					stackOperation.sorting();
					
					totalStack += "After sortElements:" + "\n" ;
					
					totalStack += stackOperation.display() + "\n" ;
					
				}
				
				else if (parts[1].equals("distinctElements")) {
					
					totalStack += "After distinctElements:" + "\n" ;
					
					totalStack += "Total distinct element=" +stackOperation.distinctElements() + "\n" ;
					
				}
			}
			
		}
		
		totalStack = totalStack.trim();
		
		totalQueue = totalQueue.trim();
		
		Writer.writer(totalStack, "stackOut");
		
		Writer.writer(stackOperation.display(), "stack");
		
		Writer.writer(totalQueue, "queueOut");
		
		Writer.writer(queueOperation.print(), "queue");
	}

}
