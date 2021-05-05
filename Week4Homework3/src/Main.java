import Adapters.MernisServiceAdapter;
import Concrete.CampaignManager;
import Concrete.GameManager;
import Concrete.GamerManager;
import Concrete.SaleManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Gamer;

public class Main {

	public static void main(String[] args) {

		Gamer gamer1 = new Gamer();
		gamer1.setId(1);
		gamer1.setFirstName("Mert Cem");
		gamer1.setLastName("Ayhan");
		gamer1.setNationalityId("12345678901");
		gamer1.setYearOfBirth(1995);
		gamer1.setNickName("Makrofaj");

		GamerManager gamerManager = new GamerManager(new MernisServiceAdapter());
		gamerManager.add(gamer1);
		gamerManager.update(gamer1);

		System.out.println("\n");

		Game game1 = new Game();
		game1.setId(1);
		game1.setGameName("World of Warcraft");
		game1.setPrice(300);

		Game game2 = new Game();
		game2.setId(2);
		game2.setGameName("Mass Effect 3");
		game2.setPrice(200);

		GameManager gameManager = new GameManager();
		gameManager.add(game1);
		gameManager.add(game2);
		gameManager.update(game2);

		System.out.println("\n");

		Campaign campaign1 = new Campaign(50, game1.getPrice());
		campaign1.setId(1);
		campaign1.setCampaignName("Black Friday");

		Campaign campaign2 = new Campaign(30, game2.getPrice());
		campaign2.setId(1);
		campaign2.setCampaignName("Yeni yıl");

		CampaignManager campaignManager = new CampaignManager();
		campaignManager.add(campaign1);
		campaignManager.add(campaign2);
		campaignManager.update(campaign2);

		System.out.println("\n");
		System.out.println();

		SaleManager saleManager = new SaleManager();
		System.out.println("Kampanyalı İşlemler");
		System.out.println();
		saleManager.campaignSale(campaign2, game2, gamer1);
		saleManager.campaignSale(campaign1, game1, gamer1);
		System.out.println();
		System.out.println("Kampanyasız İşlemler");
		System.out.println();
		saleManager.sale(gamer1, game2);

	}

}
