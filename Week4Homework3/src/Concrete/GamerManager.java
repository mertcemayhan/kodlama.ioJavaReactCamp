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
			System.out.println("Merhaba " + gamer.getNickName() + ". Kimlik do�rulama ba�ar�l�yla tamamland�.");
		}else {
			System.out.println("Kimlik do�rulama ba�ar�s�z oldu.");
		}
		
	}

	@Override
	public void update(Gamer gamer) {
		if(gamerCheckService.checkIfRealPerson(gamer)) {
			System.out.println("Merhaba " + gamer.getNickName() + ". Kimlik bilgileriniz ba�ar�l�yla g�ncellendi.");
		}else {
			System.out.println("G�ncelleme i�lemi ba�ar�s�z oldu");
		}
		
	}

	@Override
	public void delete(Gamer gamer) {
		System.out.println("Kayd�n�z ba�ar�yla silinmi�tir" + gamer.getNickName() );
		
	}
	
}
