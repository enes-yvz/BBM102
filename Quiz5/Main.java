

public class Main {

	public static void main(String[] args) {
		
		String[] decimalList = ReadFromFile.readFile(args[0]);
		
		Operations operation = new Operations();
		
		operation.operation(decimalList);

	}

}

