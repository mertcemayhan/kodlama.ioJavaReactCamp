package Concrete;

import Abstract.SaleService;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public class SaleManager implements SaleService {

	@Override
	public void sale(Gamer gamer, Game game) {
			System.out.println("Merhaba " + gamer.getFirstName() + ". " + game.getGameName() + " oyununu " 
								+ game.getPrice() + " TL kar��l���nda sat�n ald�n�z.");
	}

	@Override
	public void campaignSale(Campaign campaign, Game game, Gamer gamer) {
		System.out.println("Merhaba " + gamer.getNickName() + ". " + campaign.getCampaignName() + " kampanyas�yla "
				+ game.getGameName() + " oyununu " + "%" + campaign.getDiscountRate() + " indirimle "
				+ campaign.getPriceAfterDiscount() + " TL'ye sat�n ald�n�z.");

	}

}
