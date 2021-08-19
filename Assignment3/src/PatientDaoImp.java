import java.util.ArrayList;
import java.util.List;

public class PatientDaoImp implements PatientFileDao{
	
	List<Patient> patientList;
	
	private String[] firstList;
	
	public PatientDaoImp() {
	
		firstList = ReadFromFile.readFile("patient.txt");
	
		patientList = new ArrayList<Patient>();
		
		for(String i :firstList) {
			
			String[] secondList = i.split("\t");
			
			Patient patient = new Patient();
			
			patient.setID(secondList[0]);
			patient.setName(secondList[1].split(" ")[0]);
			patient.setSurname(secondList[1].split(" ")[1]);
			patient.setPhoneNumber(secondList[2]);
			patient.setAddress(secondList[3]);
			
			patientList.add(patient);
			
		}
		
	}
	
	@Override
	public Patient getByID(String ID) {
		
		for(int i=0;i<patientList.size();i++) {
			
			if (patientList.get(i).getID().equals(ID)) {
				
				return patientList.get(i);
		
			}
		}
		
		return null;
	}

	@Override
	public void deleteByID(String ID) {
		
		for(int i=0;i<patientList.size();i++) {
			
			if (patientList.get(i).getID().equals(ID)) {
				
				patientList.remove(i);
		
			}
		}
		
	}

	@Override
	public void add(Patient patient) {
		patientList.add(patient);
	}

	@Override
	public List<Patient> getAll() {
		
		for (int i = 0; i < patientList.size(); i++) {
			
			int pos = i;
			
            for (int j = i; j < patientList.size(); j++) {
            	
                if (patientList.get(j).getName().compareTo(patientList.get(pos).getName()) <0)
                    pos = j;
            }
            
            Patient min = patientList.get(pos);
            patientList.set(pos, patientList.get(i));
            patientList.set(i, min);  
		}
		
		
		return patientList;
	}

}
