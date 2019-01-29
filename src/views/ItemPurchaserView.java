package views;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import model.AllItems;
import model.Category;
import model.Item;

public class ItemPurchaserView extends TabbedArea {
	
	private AllItems allItems;
	private Stage stage;
	private ArrayList<PurchasableItemView> purchasableItems = new ArrayList<PurchasableItemView>();
	
	public ItemPurchaserView(AllItems _allItems, Stage _stage, int w, int h) {
		super(w, h);
		this.allItems = _allItems;
		this.stage = _stage;
		//this.setHgap(10);
		//this.setVgap(10);
		
		//this.setPadding(new Insets(20, 20, 20, 20));
		
		//this.setGridLinesVisible(true);
		
		//TabPane tabPane = new TabPane();

		
		for (Category cat:allItems.getCategories()) {
//			Tab nt = new Tab();
//			nt.setText(cat);
//			FlowPane fp = new FlowPane();
//			fp.setPrefWrapLength(2);
//			
//			nt.setContent(fp);
//			this.getTabs().add(nt);
			this.add(cat.getName(), cat.getImg(), cat.getColor());
		}
		this.get(0).toFront();
		
		for (Item itm : allItems.getItems()) {
			if (itm.isPurchasable()) {
				for (RegisterTab t:this.getTabs()) {
					if (t.getTabName().equals(itm.getCategory())) {
						FlowPane fp = (FlowPane) t.getContentArea();
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
		this.get(0).toFront();
		
	}

//	public void addItem(Item itm, int col, int row) {
//		PurchasableItemView itemView = new PurchasableItemView(itm, this.stage);
//		purchasableItems.add(itemView);
//		this.add(itemView, col, row);
//	}
	
	
}
