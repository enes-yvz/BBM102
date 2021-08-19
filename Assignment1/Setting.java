import java.text.SimpleDateFormat;
import java.util.Date;

/* This class turn data types of dates from String to Data with setters and getters */

public class Setting {
	
	SimpleDateFormat formatter =new SimpleDateFormat("dd.MM.yyyy"); 
	
	private Date productDate;
	private Date endDate;
	private Date startDate;
	
	public Date getProductDate() {
		return productDate;
	}
	public void setProductDate(String productDate) throws Exception {
		this.productDate = formatter.parse(productDate);
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) throws Exception {
		this.endDate=formatter.parse(endDate);
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) throws Exception {
		this.startDate=formatter.parse(startDate);
	}
}