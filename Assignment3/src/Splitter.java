
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class Splitter {
	
	private String allPatients= "";
	private String allExaminations= "";
	private String total= "";
	
	public void split(String[] inputList) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		PatientFileDao patientFileDao = new PatientDaoImp();
		
		AdmissionFileDao admissionFileDao = new AdmissionDaoImp();
		
		admissionFileDao.first();
		
		for(String i: inputList) {
			
			String[] inputParts = i.split(" ");
			
			if(inputParts[0].equals("AddPatient")) {
				
				int x = 0;
				
				String[] temporary = new String[inputParts.length-5];
				
				for(int j=5 ;j<inputParts.length;j++) {
					
					temporary[x]= inputParts[j];
					
					x++;
					 
				}
				
				Patient patient = new Patient();
					
				patient.setID(inputParts[1]);
				patient.setName(inputParts[2]);
				patient.setSurname(inputParts[3]);
				patient.setPhoneNumber(inputParts[4]);
				patient.setAddress("Address: " + Arrays.toString(temporary).replaceAll("\\[|\\]|," , ""));
				
				patientFileDao.add(patient);
				
				total += "Patient " +patient.getID() +" " + patient.getName()+ " added\n";
			}
			
			else if(inputParts[0].equals("RemovePatient")) {
				
				total += "Patient " +patientFileDao.getByID(inputParts[1]).getID()+ " "+patientFileDao.getByID(inputParts[1]).getName()+" removed\n";
				
				patientFileDao.deleteByID(inputParts[1]);
				
				admissionFileDao.deleteByID(inputParts[1]);
			}
			
			else if(inputParts[0].equals("CreateAdmission")) {
				
				admissionFileDao.createAdmission(inputParts[1], inputParts[2]);
				
				total += "Admission " + inputParts[1] + " created\n";
					
			}
			
			else if(inputParts[0].equals("AddExamination")) {
				
				int x = 0;
				
				String[] temporary = new String[inputParts.length-3];
				
				for(int j=3 ;j<inputParts.length;j++) {
					
					temporary[x]= inputParts[j];
					
					x++;
					 
				}
				
				admissionFileDao.addExamination(inputParts[1],inputParts[2],temporary);
				
				total += inputParts[2] + " examination added to admission " + inputParts[1] + "\n";
					
			}
			
			else if(inputParts[0].equals("TotalCost")) {
				
				total += "Total cost for admission " + inputParts[1]+ "\n";
				
				total += admissionFileDao.calculator(inputParts[1]);
					
			}
			
			else if(inputParts[0].equals("ListPatients")) {
				
				total += "Patient List:\n";
				
				for(Patient l:patientFileDao.getAll()) {
					
					total += l.getID()+" "+l.getName()+" "+l.getSurname()+" "+l.getPhoneNumber()+" "+l.getAddress()+"\n";
				}
			}
		}
		
		List<Patient> patientList = patientFileDao.getAll();
		
		for (int i = 0; i < patientList.size(); i++) {
			
			int pos = i;
			
            for (int j = i; j < patientList.size(); j++) {
            	
                if (Integer.parseInt(patientList.get(j).getID()) < Integer.parseInt(patientList.get(pos).getID()))
                    pos = j;
            }
            
            Patient min = patientList.get(pos);
            patientList.set(pos, patientList.get(i));
            patientList.set(i, min);  
		}
		
		for(Patient l:patientList) {
			
			allPatients += l.getID()+"\t"+l.getName()+" "+l.getSurname()+"\t"+l.getPhoneNumber()+"\t"+l.getAddress()+"\n";
		}
		
		for(Examination l:admissionFileDao.getAll()) {
			
			allExaminations += l.getAdmissionID()+"\t"+l.getID()+"\n";
			
			for(Operation op:l.getOperation()) {
				
				String[] array =  op.printOperations().split(" ");
				
				allExaminations += array[0]+"\t";
				
				for(int h=1;h<array.length;h++) {
					
					if (h==array.length-1) {
						
						allExaminations += array[h]+"\n";
					}
					
					else {
						
						allExaminations += array[h]+" ";
						
					}
				}
			}
		}
		
		total = total.trim();
		allPatients =allPatients.trim();
		allExaminations = allExaminations.trim();
		
		Writer.writer(total, "output");
		Writer.writer(allPatients, "patient");
		Writer.writer(allExaminations, "admission");
		
	}

}
