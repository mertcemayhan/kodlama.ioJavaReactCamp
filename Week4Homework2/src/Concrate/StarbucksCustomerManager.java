package Concrate;

import Abstract.BaseCustomerManager;
import Abstract.CustomerCheckService;
import Entities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager {

	private CustomerCheckService _customerCheckService;

	public StarbucksCustomerManager(CustomerCheckService _customerCheckService) {
		super();
		this._customerCheckService = _customerCheckService;
	}

	@Override
	public void Save(Customer customer) {
		if (_customerCheckService.checkIfRealPerson(customer)) {
			super.Save(customer);
		} else {
			System.out.println("Not a valid person");
		}

	}
}
