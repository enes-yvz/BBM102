
public class Operations {
	
	private MyStack stack = new MyStack();
	
	public void operation(String[] list) {
		
		String total = "";
		
		for(String i: list) {
			
			String octal= "";
			
			int temp = Integer.parseInt(i);
			
			while(temp>0) {
				
				int remainder = temp % 8;
				
				stack.push(remainder);
				
				temp = temp - remainder;
				
				temp = temp/8;
				
			}
			
			while(!stack.isEmpty()) {
				
				octal += stack.pop();
				
			}
			
			total += octal + "\n" ;
		}
		
		total = total.trim();
		
		Writer.writer(total, "octal");
	}

}
