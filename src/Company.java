import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Company {
	//Firma (nazwa, adres)
	private String companyName;
	private String address;
	private Set<Employee> employees;
	//one-to-many
	//wiele zatrudnien przez jedna firme
	private List<Employment> employment;
	
	public Company(String companyName, String address) {
		this.companyName = companyName;
		this.address = address;
		this.employees = new HashSet<>();
		this.employment = new ArrayList<>();
	}
	
	public List<Employment> getEmployment() {
		return employment;
	}

	public void setEmployment(List<Employment> employment) {
		this.employment = employment;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", address=" + address + "]";
	}
	
	public void addEmployee(Employee e){
		if (employees.contains(e)) {
				throw new IllegalStateException(e.getName() + " has already this job " + e);
		}
			employees.add(e);
			e.getComapnies().add(this);
		}
	
	public void addEmployment(Employment emp) {
		employment.add(emp);
		emp.setCompanies(this);
	}

}
