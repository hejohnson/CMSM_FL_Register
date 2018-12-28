package views;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Item;
import model.PurchasedItem;
import model.Receipt;

public class ReceiptView extends VBox{
	private Receipt receipt;
	private VBox items;
	private Text total;
	
	public ReceiptView (Receipt _r) {
		this.receipt = _r;
		this.items = new VBox();
		this.total = new Text();
		this.getChildren().addAll(this.items, this.total);
	}
	
	public void update() {
		this.clear();
		for (PurchasedItem i:this.receipt.getItems()) {
			this.items.getChildren().add(new PurchasedItemView(i));
		}
		total.setText(Double.toString(this.receipt.getTotal()));
		
	}
	
	public void clear() {
		this.items.getChildren().clear();
	}
	
	public Receipt getReceipt() {
		return this.receipt;
	}
}
