public class Display {
	
	public static void display(String[] shoppingList, String[] priceList) throws Exception {
		
		for (String shoppingLine : shoppingList) {/*This loop is splitting 
		every element in shoppingList array and create new array and its name is shoppingParts*/
			Double total = 0.0;
			String[] shoppingParts = shoppingLine.split("\t");
			System.out.print("---");
			System.out.print(shoppingParts[0]);//shoppingParts first element is name of costumer printing this to the screen
			System.out.println("---");
			for (int i=3;i+2<=shoppingParts.length;i+=2) {
				System.out.print(shoppingParts[i]);/*shoppingParts odd elements from 3 to the second from end is product name*/
				System.out.print("\t");
				Calculate calculate = new Calculate();/*Create new object from class Calculate*/
				String price = calculate.calculator(shoppingParts[1]/*Type Of Membership*/,
													shoppingParts[2]/*Shopping Date*/,
													shoppingParts[i]/*Product Name*/,
													priceList/*Array from priceList.txt*/);	// Create new String name price equals to the result of calculator
				System.out.print(price);
				System.out.print("\t");
				System.out.print(shoppingParts[i+1]);/*shoppingParts even elements from 4 to the end is quantity*/
				System.out.print("\t");
				System.out.println(Double.parseDouble(price)*Double.parseDouble(shoppingParts[i+1]));	
				total += Double.parseDouble(price)*Double.parseDouble(shoppingParts[i+1]);/* Multiply price with quantity and add to the result of this to total */
			}
			System.out.println("Total" + "\t" + total);/* For each costumer print total price to the screen */
		}
	}
}