package views;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.PurchasedItem;

public class PurchasedItemView extends BorderPane {
	private PurchasedItem purchasedItem;
	private Text itemName;
	private Text itemSubtotal;
	private CornerRadii cr;
	
	private Font font = Font.font("Didact Gothic", FontWeight.NORMAL, 20);
	
	public PurchasedItemView (PurchasedItem pi) {
		this.purchasedItem = pi;
		this.itemName = new Text();
		this.itemSubtotal = new Text();
		this.itemName.setText(this.purchasedItem.getName());
		this.itemName.setFont(font);
		this.itemName.setFill(Color.rgb(89, 89, 89));
		this.itemSubtotal.setFont(font);
		this.itemSubtotal.setFill(Color.rgb(89, 89, 89));
		updateSubtotal();
		
		this.cr = new CornerRadii(10);
		
		this.setLeft(this.itemName);
		this.setRight(this.itemSubtotal);
//		this.setBorder(new Border(new BorderStroke(Color.BLACK, 
//	            BorderStrokeStyle.SOLID, this.cr, BorderWidths.DEFAULT)));
		this.setPadding(new Insets(-4, 10, 0, 10));
	}
	
	public void updateSubtotal() {
		
		if (this.purchasedItem.getTotalPrice() == 0.0) {
			this.itemSubtotal.setText("free");
		} else {
			this.itemSubtotal.setText(String.format("$%.2f", this.purchasedItem.getTotalPrice()));
		}
		
		//this.itemSubtotal.setText(String.format ("$%.2f", this.purchasedItem.getTotalPrice()));
	}
	
	public String getItemName() {
		return this.itemName.getText();
	}
	
	public PurchasedItem getItem() {
		return this.purchasedItem;
	}

	public void setActive() {
		// TODO Auto-generated method stub
		this.setBackground(new Background(new BackgroundFill(Color.YELLOW, this.cr, Insets.EMPTY)));
	}
	
	public void clearActive() {
		// TODO Auto-generated method stub
		this.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, this.cr, Insets.EMPTY)));
	}
}
