package views;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.PurchasedItem;

public class PurchasedItemView extends HBox {
	private PurchasedItem purchasedItem;
	private Text itemName;
	private Text itemSubtotal;
	
	public PurchasedItemView (PurchasedItem pi) {
		this.purchasedItem = pi;
		this.itemName = new Text();
		this.itemSubtotal = new Text();
		this.itemName.setText(this.purchasedItem.getName());
		updateSubtotal();
		
		this.getChildren().addAll(this.itemName, this.itemSubtotal);
	}
	
	public void updateSubtotal() {
		this.itemSubtotal.setText(Double.toString(this.purchasedItem.getTotalPrice()));
	}
}
