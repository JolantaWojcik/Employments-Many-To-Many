import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Employee {
	//Pracownik (imie, nazwisko)
	private String name;
	private String surname;
	//wiele zatrudnien jednego pracownika
	private List<Employment> employment;

	public Employee(String name, String surname) {
		this.name = name;
		this.surname = surname;
		this.employment = new ArrayList<>();
	}

	public List<Employment> getEmployment() {
		return employment;
	}

	public void setEmployment(List<Employment> employment) {
		this.employment = employment;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + "]";
	}

	public void addEmployment(Employment emp) {
		employment.add(emp);
		emp.setEmployees(this);
	}
	
	public void removeEmployment(Employment emp) {
		employment.removeIf(e->e.getEndDate()!=null);
		emp.setEmployees(this);
	}

}
