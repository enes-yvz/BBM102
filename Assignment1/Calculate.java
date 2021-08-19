public class Calculate {
	
	public String calculator(String membership,String date,String product,String[] priceList) throws Exception {
		
		for (String priceLine : priceList) {
			String[] priceParts = priceLine.split("\t");
			Setting setter = new Setting();/* Create new object from class of Setting*/
			setter.setProductDate(date);
			setter.setStartDate(priceParts[2]);
			setter.setEndDate(priceParts[3]);
			
			if (product.equals(priceParts[0]) && 
				(setter.getProductDate().after(setter.getStartDate()) || 
				setter.getProductDate().equals(setter.getStartDate())) && /* Getting product date and start date 
				from class setting type as Date and comparing this values with each other*/
				(setter.getProductDate().before(setter.getEndDate()) || 
				setter.getProductDate().equals(setter.getEndDate())) && /* Getting product date and end date 
				from class setting type as Date and comparing this values with each other*/
				membership.equals(priceParts[1])) {
				String price = priceParts[4];
				return price;/* If product name and membership types is equal and 
				product date is between start date and end date	
				create new value name as price and it is equal to price of product*/ 			
			}
		}
		return null;
	}
}
