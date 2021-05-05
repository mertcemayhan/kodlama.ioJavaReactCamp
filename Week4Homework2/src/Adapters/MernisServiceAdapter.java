package Adapters;

import java.rmi.RemoteException;

import Abstract.CustomerCheckService;
import Entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;


public class MernisServiceAdapter implements CustomerCheckService {

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		try {
			return client.TCKimlikNoDogrula(Long.valueOf(customer.getNationalityId()), customer.getFirstName().toUpperCase() , 
					customer.getLastName().toUpperCase() ,customer.getDateOfBirth());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}


}
