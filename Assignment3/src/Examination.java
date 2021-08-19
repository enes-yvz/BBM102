import java.util.ArrayList;
import java.util.List;

public class Examination extends Patient {
	
	private List<Operation> operationList = new ArrayList<Operation>();
	private String admissionID;
	
	public void addOperation(Operation operation) {
		
		operationList.add(operation);
	}

	public List<Operation> getOperation() {
		return operationList;
	}

	public String getAdmissionID() {
		return admissionID;
	}

	public void setAdmissionID(String admissionID) {
		this.admissionID = admissionID;
	}
}
