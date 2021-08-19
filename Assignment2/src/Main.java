
public class Main {

	public static void main(String[] args) {
		String[] personnelList = ReadFromFile.readFile(args[0]);
		String[] monitoringList = ReadFromFile.readFile(args[1]);
		Splitter splitter = new Splitter();
		splitter.split(personnelList, monitoringList);
	}

}
