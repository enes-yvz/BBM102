
public class Splitter {
	
	public void split(String[] personnelList, String[] monitoringList) {
		
		for (int i =0 ; i<personnelList.length;i++) {
			
			String[] personnelParts = personnelList[i].split("\t");
			String[] monitoringParts = monitoringList[i].split("\t");
			
			Personnel personnel = new Personnel(personnelParts[0].split(" ")[0],personnelParts[0].split(" ")[1],
												personnelParts[1],personnelParts[2],Integer.parseInt(personnelParts[3]),
												Integer.parseInt(monitoringParts[1]),Integer.parseInt(monitoringParts[2]),
												Integer.parseInt(monitoringParts[3]),Integer.parseInt(monitoringParts[4]));
			
			personnel.selector();
		}
	}

}
