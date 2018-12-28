package model;

public class PurchasedItem {
	private Item item;
	private int quantity;
	
	public PurchasedItem (Item itm, int qty) {
		this.item = itm;
		this.quantity = qty;
	}
	
	public String getName() {
		return this.item.getName();
	}
	
	public int incrementQty(int by) {
		quantity = quantity + by;
		return quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getTotalPrice() {
		return quantity*this.item.getPrice();
	}
}
