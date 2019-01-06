package views;
import java.util.ArrayList;
import java.util.LinkedList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AllItems;
import model.Item;
import model.PurchasedItem;

public class ItemPurchaserView extends TabPane {
	
	private AllItems allItems;
	private ArrayList<PurchasedItem> purchasedItems;
	private Stage stage;
	private ArrayList<PurchasableItemView> purchasableItems = new ArrayList<PurchasableItemView>();
	
	public ItemPurchaserView(AllItems _allItems, ArrayList<PurchasedItem> _purchasedItems, Stage _stage) {
		this.allItems = _allItems;
		this.stage = _stage;
		this.purchasedItems = _purchasedItems;
		//this.setHgap(10);
		//this.setVgap(10);
		
		this.setPadding(new Insets(20, 10, 10, 10));
		
		//this.setGridLinesVisible(true);
		
		//TabPane tabPane = new TabPane();
		
		this.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

		
		for (String cat:allItems.getCategories()) {
			Tab nt = new Tab();
			nt.setText(cat);
			FlowPane fp = new FlowPane();
			fp.setPrefWrapLength(2);
			
			nt.setContent(fp);
			this.getTabs().add(nt);
		}
		
		for (Item itm : allItems.getItems()) {
			if (itm.isPurchasable()) {
				for (Tab t:this.getTabs()) {
					if (t.getText().equals(itm.getCategory())) {
						FlowPane fp = (FlowPane) t.getContent();
						PurchasableItemView itemView = new PurchasableItemView(itm, this.stage);
						purchasableItems.add(itemView);
						fp.getChildren().add(itemView);
					} 
				}
//				this.addItem(itm, idx%2, (int)(idx/2));
//				idx=idx+1;
			}
			
		}
		//this.setAlignment(Pos.CENTER);
		
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

	public void reset() {
		this.getSelectionModel().select(0);
		
	}

//	public void addItem(Item itm, int col, int row) {
//		PurchasableItemView itemView = new PurchasableItemView(itm, this.stage);
//		purchasableItems.add(itemView);
//		this.add(itemView, col, row);
//	}
	
	
}
