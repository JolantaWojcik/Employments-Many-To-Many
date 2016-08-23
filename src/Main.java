import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
 * Pracownik (imie, nazwisko)
 * Firma (nazwa, adres)
 * 
 * wiele do wiele
 * Pracownik moze pracowac w wielu firmach, a firma moze miec wielu pracownikow.
 * Dla ka¿dego po³¹czzenia Pracownik<->Firma pamiêtamy jakie stanowisko pe³ni³,
 *  ile zarabia³ oraz od kiedy do kiedy pracowa³.
 */
public class Main {
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		
		//many-to-many
		Employee e1 = new Employee("Jan", "Kowalski");
		Employee e2 = new Employee("Arkadiusz", "Nowak");
		Employee e3 = new Employee("Anna", "Nowak");
		
		Company c1 = new Company("IBM", "Krakow, Bronowice");
		Company c2 = new Company("ABB", "Krakow, Starowislna");
	
	//	try {
			Employment emp1 = new Employment("Accountant", 4000, dt.parse("2010-09-08"), new Date());
			Employment emp2 = new Employment("Senior HR", 3600, dt.parse("2000-05-08"), new Date());
			Employment emp3 = new Employment("Coach", 3500, dt.parse("2005-07-08"), new Date());
			Employment emp4 = new Employment("Supporr", 3000, dt.parse("2011-01-08"), new Date());
	//	} catch (ParseException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
		
		//IBM
		c1.addEmployee(e1);
		c1.addEmployee(e2);
		
		c1.addEmployment(emp1);
		c1.addEmployment(emp2);
		//ABB
		c2.addEmployee(e2);
		c2.addEmployee(e3);
		
		c2.addEmployment(emp3);
		c2.addEmployment(emp4);
		
		//employees
		e1.addComapny(c1);
		e1.addEmployment(emp1);
		
		e2.addComapny(c2);
		e2.addComapny(c1);
		e2.addEmployment(emp2);
		e2.addEmployment(emp3);
		
		e3.addComapny(c2);
		e3.addEmployment(emp4);

	//	e1.getComapnies().forEach(System.out::println);
		System.out.println(e1.getName() +" is employeed " + e1.getComapnies() + "\n position details "+
				e1.getEmployment());
		System.out.println(e2.getName() +" is employeed " + e2.getComapnies()
		+ "\n position details "+ e2.getEmployment());
		System.out.println(e3.getName() +" is employeed " + e3.getComapnies());
		System.out.println("IBM Employees " + c1.getEmployees()
			+ "\n position details "+ c1.getEmployment());
		System.out.println("ABB Employees " + c2.getEmployees());
		
		 ArrayList<Employment> employment = new ArrayList<>();
		 employment.add(emp1);
		 employment.add(emp2);
		 employment.add(emp3);
		 employment.add(emp4);
		 employment.forEach(System.out::println);
	}
	
}
