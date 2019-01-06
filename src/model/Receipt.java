package model;

import java.util.LinkedList;

public class Receipt {
	
	private LinkedList<PurchasedItem> items;
	
	public Receipt () {
		items = new LinkedList<PurchasedItem>();
	}
	
	public void purchaseItem (Item itm, int qty) {
		for (PurchasedItem pi:items) {
			if (pi.getName().equals(itm.getName())) {
				pi.incrementQty(qty);
				return;
			}
		}
		items.add(new PurchasedItem(itm, qty));
	}

	public LinkedList<PurchasedItem> getItems() {
		// TODO Auto-generated method stub
		return items;
	}
	
	public double getTotal() {
		double total = 0;
		for (PurchasedItem pi:items) {
			total = total + pi.getTotalPrice();
		}
		return total;
	}
	
	public void clear() {
		this.items.clear();
	}

}
