import Abstract.BaseCustomerManager;
import Abstract.CustomerCheckService;
import Adapters.MernisServiceAdapter;
import Concrate.NeroCustomerManager;
import Concrate.StarbucksCustomerManager;
import Entities.Customer;

//JSE 15 versiyonunda mernis package'� �al��mad�. Ara�t�rma sonucu JSE 1.8 yap�ld���nda hatan�n gitti�ini g�zlemledim.
public class Main {

	public static void main(String[] args) {
		
		
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		Customer customer1 = new Customer();
		customer1.setId(1);
		customer1.setFirstName("Mert Cem");
		customer1.setLastName("Ayhan");
		customer1.setDateOfBirth(1995);
		customer1.setNationalityId("12345678901");
		//ger�ek TC yaz�ld���nda projenin mernis �zerinden �al��t��� g�zlemlendi

		customerManager.Save(customer1);
	};
}
