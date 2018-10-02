package views;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AllItems;
import model.Item;
import model.PurchasedItem;

public class ItemPurchaserView extends GridPane {
	
	private AllItems allItems;
	private ArrayList<PurchasedItem> purchasedItems;
	private Stage stage;
	private ArrayList<PurchasableItemView> purchasableItems = new ArrayList<PurchasableItemView>();
	
	public ItemPurchaserView(AllItems _allItems, ArrayList<PurchasedItem> _purchasedItems, Stage _stage) {
		this.allItems = _allItems;
		this.stage = _stage;
		this.purchasedItems = _purchasedItems;
		this.setHgap(10);
		this.setVgap(10);
		
		this.setPadding(new Insets(20, 10, 10, 10));
		
		//this.setGridLinesVisible(true);
		
		
		
		int idx = 0;
		for (Item itm : allItems.getItems()) {
			if (itm.isPurchasable()) {
				this.addItem(itm, idx%2, (int)(idx/2));
				idx=idx+1;
			}
			
		}
		
		this.setAlignment(Pos.CENTER);
		
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

	public void addItem(Item itm, int col, int row) {
		PurchasableItemView itemView = new PurchasableItemView(itm, this.stage);
		purchasableItems.add(itemView);
		this.add(itemView, col, row);
	}
	
	
}
