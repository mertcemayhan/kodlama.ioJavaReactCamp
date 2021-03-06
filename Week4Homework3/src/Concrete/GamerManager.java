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
			System.out.println("Merhaba " + gamer.getNickName() + ". Kimlik doğrulama başarılıyla tamamlandı.");
		}else {
			System.out.println("Kimlik doğrulama başarısız oldu.");
		}
		
	}

	@Override
	public void update(Gamer gamer) {
		if(gamerCheckService.checkIfRealPerson(gamer)) {
			System.out.println("Merhaba " + gamer.getNickName() + ". Kimlik bilgileriniz başarılıyla güncellendi.");
		}else {
			System.out.println("Güncelleme işlemi başarısız oldu");
		}
		
	}

	@Override
	public void delete(Gamer gamer) {
		System.out.println("Kaydınız başarıyla silinmiştir" + gamer.getNickName() );
		
	}
	
}
