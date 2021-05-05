package Entities;

import Abstract.Entity;

public class Campaign implements Entity {

	private int id;
	private String campaignName;
	private int discountRate;
	private double Price;
	
	public Campaign() {
		
	}

	public Campaign(int discountRate, double Price) {
		super();
		this.discountRate = discountRate;
		this.Price = Price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double Price) {
		this.Price = Price;
	}

	public double getPriceAfterDiscount() {
		return this.Price - (this.Price * this.discountRate / 100);
	}

}
