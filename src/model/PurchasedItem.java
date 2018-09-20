package model;

public class PurchasedItem extends Item {
	private int quantity;
	
	public PurchasedItem (Item itm, int qty) {
		super(itm.getName(), itm.getPrice(), itm.getImagePath(), itm.isPurchasable());
		this.quantity = qty;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getTotalPrice() {
		return quantity*this.getPrice();
	}
}
