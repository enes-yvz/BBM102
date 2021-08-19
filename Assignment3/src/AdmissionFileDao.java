import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface AdmissionFileDao {
	
	public List<Examination> getAll();
	public void deleteByID(String ID);
	public void createAdmission(String admissionID,String patientID); 
	public void first() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
	public void addExamination(String ID,String type,String[] operation) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException; 
	public Operation creator(String type,String[] operation) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException;
	public String calculator(String admissionID);
	
}
