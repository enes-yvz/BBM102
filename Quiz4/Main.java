
public class Main {

	public static void main(String[] args) {
		
		String[] inputList = ReadFromFile.readFile(args[0]);
		Splitter splitter = new Splitter();
		splitter.split(inputList);
	}

}
