package Concrete;

import Abstract.GamerCheckService;
import Abstract.GamerService;
import Entities.Gamer;

public class GamerManager implements GamerService {

	private GamerCheckService gamerCheckService;

	
	
	public GamerManager(GamerCheckService gamerCheckService) {
		super();
		this.gamerCheckService = gamerCheckService;
	}

	@Override
	public void add(Gamer gamer) {
		if(gamerCheckService.checkIfRealPerson(gamer)) {
			System.out.println("Merhaba " + gamer.getNickName() + ". Kimlik doðrulama baþarýlýyla tamamlandý.");
		}else {
			System.out.println("Kimlik doðrulama baþarýsýz oldu.");
		}
		
	}

	@Override
	public void update(Gamer gamer) {
		if(gamerCheckService.checkIfRealPerson(gamer)) {
			System.out.println("Merhaba " + gamer.getNickName() + ". Kimlik bilgileriniz baþarýlýyla güncellendi.");
		}else {
			System.out.println("Güncelleme iþlemi baþarýsýz oldu");
		}
		
	}

	@Override
	public void delete(Gamer gamer) {
		System.out.println("Kaydýnýz baþarýyla silinmiþtir" + gamer.getNickName() );
		
	}
	
}
