public class Main {

	public static void main(String[] args) throws Exception {
		String[] shoppingList = ReadFromFile.readFile(args[0]);/*Create new array.
		This array name is shoppingList and its each element is lines of shoppingList.txt*/
		String[] priceList = ReadFromFile.readFile(args[1]);/*Create new array.
		This array name is priceList and its each element is lines of priceList.txt*/
		Display.display(shoppingList,priceList);//Printing results to the screen
	}
}
