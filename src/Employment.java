import java.text.SimpleDateFormat;
import java.util.Date;

public class Employment {
	//jakie stanowisko pe³ni³,
	//ile zarabia³ oraz od kiedy do kiedy pracowa³.
	
	private String position;
	private int salary;
	private Date startDate;
	private Date endDate;
	//one-to-many
	private Employee employees;
	private Company companies;
	private SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
	
	public Employment(){
		
	}
	
	public Employment(String position, int salary, Date startDate) {
		super();
		this.position = position;
		this.salary = salary;
		this.startDate = startDate;
	}
	
	public Employment(String position, int salary, Date startDate, Date endDate) {
		super();
		this.position = position;
		this.salary = salary;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	public Company getCompanies() {
		return companies;
	}

	public void setCompanies(Company companies) {
		this.companies = companies;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	//zle?
	@Override
	public String toString() {
		return "Employment [position=" + position + ", salary=" + salary + ", startDate=" + dt.format((startDate)) + "]";
	}

	public void fire(Date date) {
		setEndDate(date);
	}

}
