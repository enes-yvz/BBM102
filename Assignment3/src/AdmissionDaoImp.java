import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class AdmissionDaoImp implements AdmissionFileDao {
	
	private String[] firstList;
	
	private List<Examination> admissionList = new ArrayList<Examination>();
	
	@Override
	public void first() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		firstList = ReadFromFile.readFile("admission.txt");
		
		Examination examination = new Examination();
		
		if (0<firstList.length) {
			
			examination.setID(firstList[0].split("\t")[1]);
			
			examination.setAdmissionID(firstList[0].split("\t")[0]);	
			
		}
		
		for(int i = 1 ;i<firstList.length;i++) {
			
			String[] admissionParts = firstList[i].split("\t");
			
			String[] operation = admissionParts[1].split(" ");
			
			if (!admissionParts[0].equals("Outpatient") && !admissionParts[0].equals("Inpatient")) {
				
				
				admissionList.add(examination);
				
				examination = new Examination();
				
				examination.setID(admissionParts[1]);
				
				examination.setAdmissionID(admissionParts[0]);
					 
			}
			
			else {
				
				Operation object = creator(admissionParts[0], operation);
				
				examination.addOperation(object);
				
			}
		}
		
		if (0<firstList.length) {
			
			admissionList.add(examination);
			
		}
	
	}
	
	@Override
	public void createAdmission(String admissionID,String patientID) {

		Examination examination = new Examination();
		
		examination.setID(patientID);
		
		examination.setAdmissionID(admissionID);
		
		admissionList.add(examination);
		
	}

	@Override
	public void addExamination(String ID,String type,String[] operation) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		for(int i=0;i<admissionList.size();i++) {
			
			if (admissionList.get(i).getAdmissionID().equals(ID)) {

				admissionList.get(i).addOperation(creator(type,operation));
		
			}
		}	
	}
	
	
	@Override
	public Operation creator(String type,String[] operation) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
	
		for(int k=0; k < operation.length; k++) 
        {
            if(operation[k].equals("imaging")) {
                operation[k]="Imaging";
            }
            
            if(operation[k].equals("tests")) {
            	operation[k]="Test";
            }
            
            if(operation[k].equals("measurements")) {
            	operation[k]="Measurement";
            }
            
            if(operation[k].equals("doctorvisit")) {
            	operation[k]="Visit";
            }
        }
        
        Class<?> myClass2 = Class.forName(operation[0]);
        Constructor<?> ctr2 = myClass2.getConstructor(Operation.class);
        Operation arg2 = (Operation) Class.forName(type).newInstance();
        Operation second = (Operation) ctr2.newInstance(arg2);
        
        if (operation.length==2 || operation.length==3) {
        	
        	Class<?> myClass3 = Class.forName(operation[1]);
            Constructor<?> ctr3 = myClass3.getConstructor(Operation.class);
            Operation third = (Operation) ctr3.newInstance(second);
            
            if (operation.length==3) {
            	
            	
            	Class<?> myClass4 = Class.forName(operation[2]);
                Constructor<?> ctr4 = myClass4.getConstructor(Operation.class);
                Operation fourth = (Operation) ctr4.newInstance(third);
                
                return fourth;
            	
            }
            
            return third;	
        	
        }
        
        return second;
		
	}

	@Override
	public List<Examination> getAll() {
		
		for (int i = 0; i < admissionList.size(); i++) {
			
			int pos = i;
			
            for (int j = i; j < admissionList.size(); j++) {
            	
                if (Integer.parseInt(admissionList.get(j).getID()) < Integer.parseInt(admissionList.get(pos).getID()))
                    pos = j;
            }
            
            Examination min = admissionList.get(pos);
            admissionList.set(pos, admissionList.get(i));
            admissionList.set(i, min);  
		} 
		
		return admissionList;
	}

	@Override
	public void deleteByID(String ID) {
		
		for(int i=0;i<admissionList.size();i++) {
			
			if (admissionList.get(i).getID().equals(ID)) {
				
				admissionList.remove(i);
		
			}
		}
		
	}

	@Override
	public String calculator(String admissionID) {
		
		String article = "";
		int total =0;
		
		for(int i=0;i<admissionList.size();i++) {
			
			if (admissionList.get(i).getAdmissionID().equals(admissionID)) {
				
				for(Operation oper:admissionList.get(i).getOperation()) {
					
					total +=oper.cost();
					article +="\t" + oper.printOperations() +" " + oper.cost()+ "$\n";
				}
		
			}
		}
		
		article +="\t" +"Total: "+total+"$\n";
		return article;
	}

}
