package kodlamaio.HRMS.core.utilities.adapters;

import kodlamaio.HRMS.fakeService.fakeService;

public class MernisCheckManager {
	public static boolean isRealPerson(String identityNumber) {
		fakeService fakeService = new fakeService();
		return fakeService.mernisCheck(identityNumber);
	}

}
