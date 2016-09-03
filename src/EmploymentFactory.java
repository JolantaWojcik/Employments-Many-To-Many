import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EmploymentFactory {
	//Employment employment1 = EmploymentFactory.hire(e1,c1, "stanowisko", 3333, dt.parse("2010-09-08"));
	//employent1.fire(new Date());
	
	public Employment hire(Employee e, Company c, String position, int salary, Date date){
		Employment emp = new Employment(position, salary, date);
		emp.setCompanies(c);
		emp.setEmployees(e);
		c.addEmployment(emp);
		e.addEmployment(emp);
		return emp;
	}
	
	public Employment fire(Date date){
		List<Employment> emp = new ArrayList<Employment>();
		Employment empContract = new Employment();
		empContract.setEndDate(date);
		emp.removeIf(e -> e.getEndDate()==date);
		return emp;
	}
	
	public List<Employee> comapanyEmployees(Company company, List<Employment> emp) {
		return emp.stream().filter(e -> e.getCompanies() == company)
				.map(Employment::getEmployees).collect(Collectors.toList());
	}

	public List<Company> whereEmployeeWorks(Employee empl, List<Employment> emp) {
		return emp.stream().filter(e -> e.getEmployees() == empl)
				.map(Employment::getCompanies).collect(Collectors.toList());
	}
}
