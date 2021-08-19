
public class Main {

	public static void main(String[] args) {
		
		String[] commandList = ReadFromFile.readFile(args[0]);
		
		Operations operation = new Operations();
		
		operation.operation(commandList);

	}

}
