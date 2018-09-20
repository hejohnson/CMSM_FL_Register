package views;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AllItems;
import model.Item;
import model.PurchasedItem;

public class ItemPurchaserView extends VBox {
	
	private AllItems allItems;
	private ArrayList<PurchasedItem> purchasedItems;
	private Stage stage;
	private Text total = new Text();
	private ArrayList<PurchasableItemView> purchasableItems = new ArrayList<PurchasableItemView>();
	
	public ItemPurchaserView(AllItems _allItems, ArrayList<PurchasedItem> _purchasedItems, Stage _stage) {
		this.allItems = _allItems;
		this.stage = _stage;
		this.purchasedItems = _purchasedItems;
		
		
		for (Item itm : allItems.getItems()) {
			if (itm.isPurchasable()) {
				this.addItem(itm);
			}
		}
		this.setAlignment(Pos.TOP_CENTER);
		this.total.setText("$0");
		this.getChildren().add(total);
		
		
	}
	
	public Stage getStage() {
		return this.stage;
	}
	
	public AllItems getAllItems() {
		return allItems;
	}
	
	public ArrayList<PurchasableItemView> getPurchasableItems() {
		return this.purchasableItems;
	}

	public void addItem(Item itm) {
		PurchasableItemView itemView = new PurchasableItemView(itm, this.stage);
		purchasableItems.add(itemView);
		this.getChildren().add(itemView);
	}
	
	public void purchaseItem(Item itm, int _qty) {
		// increment total
		this.purchasedItems.add(new PurchasedItem(itm, _qty));
		Double totalCost = 0.0;
		for (PurchasedItem pitm:purchasedItems) {
			totalCost = totalCost + pitm.getTotalPrice();
		}
		this.total.setText("$".concat(totalCost.toString()));
		
	}
}
