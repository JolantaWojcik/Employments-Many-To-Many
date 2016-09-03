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

		EmploymentFactory ef = new EmploymentFactory();
		//Employment employment1 = ef.hire(e1,c1, "stanowisko", 3333, dt.parse("2010-09-08"));
		//employent1.fire(new Date());

		Employment emp1 = ef.hire(e1, c1, "Accountant", 4000, dt.parse("2010-09-08"));
		Employment emp2 = ef.hire(e2, c1, "Senior HR", 3600, dt.parse("2000-05-08"));
		Employment emp3 = ef.hire(e2, c2, "Coach", 3500, dt.parse("2005-07-08"));
		Employment emp4 = ef.hire(e3, c2, "Support", 3000, dt.parse("2011-01-08"));
		
		ArrayList<Employment> employment = new ArrayList<>();
		employment.add(emp1);
		employment.add(emp2);
		employment.add(emp3);
		employment.add(emp4);
		employment.forEach(System.out::println);
		
		System.out.println("\n");
		System.out.println("IBM " + c1.getEmployment());
		System.out.println("IBM employees " + ef.comapanyEmployees(c1, employment));
		System.out.println("ABB " + c2.getEmployment());
		System.out.println("\n");
		System.out.println(e1.getName()+" employment " + e1.getEmployment());
		System.out.println(e2.getName()+" employment " + e2.getEmployment());
		System.out.println(e2.getName() + " is employed by " + ef.whereEmployeeWorks(e2, employment));
		System.out.println(e3.getName()+" employment " + e3.getEmployment());
		
		System.out.println("##### \n");
		((EmploymentFactory) emp1).fire(new Date());
		employment.forEach(System.out::println);
	}

}
