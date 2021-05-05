import Abstract.BaseCustomerManager;
import Abstract.CustomerCheckService;
import Adapters.MernisServiceAdapter;
import Concrate.NeroCustomerManager;
import Concrate.StarbucksCustomerManager;
import Entities.Customer;

//JSE 15 versiyonunda mernis package'ý çalýþmadý. Araþtýrma sonucu JSE 1.8 yapýldýðýnda hatanýn gittiðini gözlemledim.
public class Main {

	public static void main(String[] args) {
		
		
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		Customer customer1 = new Customer();
		customer1.setId(1);
		customer1.setFirstName("Mert Cem");
		customer1.setLastName("Ayhan");
		customer1.setDateOfBirth(1995);
		customer1.setNationalityId("12345678901");
		//gerçek TC yazýldýðýnda projenin mernis üzerinden çalýþtýðý gözlemlendi

		customerManager.Save(customer1);
	};
}
