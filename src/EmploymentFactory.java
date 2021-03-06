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
		if(emp.getEndDate()== null){
			c.addEmployment(emp);
			e.addEmployment(emp);
		}
		else if(emp.getEndDate()!= null){
			c.removeEmployment(emp);
			e.removeEmployment(emp);
		}
		return emp;
	}

	public List<Employment> fire(Employee e, Company c, List<Employment> empList){
		for(Employment empl: empList){
			if(empl.getEndDate()!=null){
			//	empList.remove(empl);
				c.removeEmployment(empl);
				e.removeEmployment(empl);
			}
		}
		empList.removeIf(a->a.getEndDate()!=null);
	//	emp.stream().filter(u -> u.getEndDate() != null).collect(Collectors.toList());
	//	return emp;
		return empList;
	}


	public List<Employee> comapanyEmployees(Company company, List<Employment> emp) {
//		List<Employee> currentCompanyEmpl = 
//				emp.stream().filter(u -> u.getCompanies() == company)
//				.map(Employment::getEmployees).collect(Collectors.toList());
		for(Employment e: emp){
			if(e.getEndDate()!=null){
				emp.remove(e);
				company.removeEmployment(e);
			}
		}
//		List<Employee> newList = emp.stream().filter(u -> u.getCompanies() == company)
//		.map(Employment::getEmployees).collect(Collectors.toList());
//		Employment e = emp.stream().filter(a->a.getEndDate()!=null).findAny().get();
//		company.removeEmployment(e);
		return emp.stream().filter(u -> u.getCompanies() == company)
				.map(Employment::getEmployees).collect(Collectors.toList());
	}

	public List<Company> whereEmployeeWorks(Employee empl, List<Employment> emp) {
		return emp.stream().filter(e -> e.getEmployees() == empl)
				.map(Employment::getCompanies).collect(Collectors.toList());
	}
}
