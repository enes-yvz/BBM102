import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Splitter {
	
	private String article = "";
	
	public void split(String[] inputList) {
			
			List<Contact> arrayList = new ArrayList<Contact>();
			
			Set<Contact> hashSet = new HashSet<Contact>();
			
			Set<Contact> treeSet = new TreeSet<Contact>();
			
			Set<Contact> treeSetComparator = new TreeSet<Contact>(new LastNameComparator());
			
			Map<String,Contact> hashMap = new HashMap<String,Contact>();
			
			for(String i: inputList) {
				
				String[] inputParts = i.split(" ");
				
				Contact contact = new Contact(inputParts[0],inputParts[1],inputParts[2],inputParts[3]);
				
				arrayList.add(contact);
				
				hashSet.add(contact);
				
				treeSet.add(contact);
				
				treeSetComparator.add(contact);
				
				hashMap.put(inputParts[0], contact);
				
			}
			
			create(arrayList,"contactsArrayList");
			
			Collections.sort(arrayList, new LastNameComparator());
				
			create(arrayList,"contactsArrayListOrderByLastName");
			
			create(hashSet,"contactsHashSet");
			
			create(treeSet,"contactsTreeSet");
			
			create(treeSetComparator,"contactsTreeSetOrderByLastName");
			
			Collection<Contact> newVariable = hashMap.values();
			
			create(newVariable,"contactsHashMap");		
		
	}
	
	public void create(Collection<Contact> collection,String fileName) {
		
		for (Contact c : collection) {
			
			article += c.getPhoneNumber()+" "+c.getFirstName()+" "+c.getLastName()+" "+c.getSocialSecurityNumber()+"\n";	
		}
		
		article = article.trim();
		
		Writer.writer(article, fileName);
		
		article = "";
	}
}
