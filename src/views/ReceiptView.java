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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Item;
import model.PurchasedItem;
import model.Receipt;

public class ReceiptView extends BorderPane{
	private Receipt receipt;
	private VBox items;
	private Text totalValue;
	private Text totalText;
	private BorderPane totalBox;
	
	public ReceiptView (Receipt _r) {
		this.receipt = _r;
		this.items = new VBox();
		this.totalBox = new BorderPane();
		this.totalValue = new Text();
		this.totalText = new Text();
		this.totalText.setText("Total: ");
		this.setTop(this.items);
		
		this.totalBox.setLeft(this.totalText);
		this.totalBox.setRight(this.totalValue);
		this.totalBox.setPadding(new Insets(10, 10, 10, 10));
		this.totalBox.setBorder(new Border(new BorderStroke(Color.BLACK, 
     		   BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBottom(this.totalBox);
		//this.getChildren().addAll(this.items, this.total);
		this.setMinWidth(300);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            		   BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.update();
	}
	
	public void update() {
		this.clear();
		for (PurchasedItem i:this.receipt.getItems()) {
			this.items.getChildren().add(new PurchasedItemView(i));
		}
		totalValue.setText(String.format ("$%.2f", this.receipt.getTotal()));
		
	}
	
	public void clear() {
		this.items.getChildren().clear();
	}
	
	public Receipt getReceipt() {
		return this.receipt;
	}
	
	public void setTotalBG() {
		this.totalBox.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void clearTotalBG() {
		this.totalBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
