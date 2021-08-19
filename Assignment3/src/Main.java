import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String[] inputList = ReadFromFile.readFile(args[0]);
		Splitter splitter = new Splitter();
		splitter.split(inputList);
		
	}
}
