
import java.util.List;

public interface PatientFileDao {
	
	public Patient getByID(String ID); 
	public void deleteByID(String ID);
	public void add(Patient patient); 
	public List<Patient> getAll();

}
