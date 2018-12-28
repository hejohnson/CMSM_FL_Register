package views;

import javafx.geometry.Insets;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.PurchasedItem;

public class PurchasedItemView extends BorderPane {
	private PurchasedItem purchasedItem;
	private Text itemName;
	private Text itemSubtotal;
	
	public PurchasedItemView (PurchasedItem pi) {
		this.purchasedItem = pi;
		this.itemName = new Text();
		this.itemSubtotal = new Text();
		this.itemName.setText(this.purchasedItem.getName());
		updateSubtotal();
		
		this.setLeft(this.itemName);
		this.setRight(this.itemSubtotal);
		this.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setPadding(new Insets(10, 10, 10, 10));
	}
	
	public void updateSubtotal() {
		this.itemSubtotal.setText(String.format ("$%.2f", this.purchasedItem.getTotalPrice()));
	}
}
