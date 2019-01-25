package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
import model.Receipt;

public class ReceiptView extends BorderPane{
	private Receipt receipt;
	private VBox items;
	private Text totalValue;
	private Text totalText;
	private VBox totalBox;
	private PurchasedItemView activePIV;
	private CornerRadii cr;
	
	public ReceiptView (Receipt _r) {
		this.receipt = _r;
		this.items = new VBox();
		this.totalBox = new VBox();
		this.totalValue = new Text();
		this.totalText = new Text();
		this.totalText.setText("total");
		this.setTop(this.items);
		
		this.totalBox.setAlignment(Pos.CENTER);
		
		this.cr = new CornerRadii(10);
		
		this.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 0.65), CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));
		
		this.totalBox.getChildren().addAll(this.totalText, this.totalValue);
		this.totalBox.setPadding(new Insets(10, 10, 10, 10));
		//this.totalBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, this.cr, BorderWidths.DEFAULT)));
		this.setBottom(this.totalBox);
		//this.getChildren().addAll(this.items, this.total);
		this.setMinWidth(280);
		this.setPadding(new Insets(15, 30, 30, 30));
		//this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
		this.update();
	}
	
	public void update() {
		if (this.receipt.getItems().size() != this.items.getChildren().size()) {
			this.items.getChildren().add(new PurchasedItemView(this.receipt.getItems().getLast()));
		}
		
		for (Node n:this.items.getChildren()) {
			((PurchasedItemView) n).updateSubtotal();
		}
		
		
//		this.clear();
//		for (PurchasedItem i:this.receipt.getItems()) {
//			this.items.getChildren().add(new PurchasedItemView(i));
//		}
		totalValue.setText(String.format ("$%.2f", this.receipt.getTotal()));
		
	}
	
	public void clear() {
		this.items.getChildren().clear();
		totalValue.setText(String.format ("$%.2f", this.receipt.getTotal()));
	}
	
	public Receipt getReceipt() {
		return this.receipt;
	}
	
	public void setTotalBG() {
		this.totalBox.setBackground(new Background(new BackgroundFill(Color.ORANGERED, this.cr, Insets.EMPTY)));
	}

	public void clearTotalBG() {
		this.totalBox.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, this.cr, Insets.EMPTY)));
	}
	
	public void setActiveBG(String item) {
		for (Node n:this.items.getChildren()) {
			if (item.equals(((PurchasedItemView) n).getItemName())) {
				((PurchasedItemView) n).setActive();
				this.activePIV = (PurchasedItemView) n;
			}
		}
	}

	public void clearActiveBG() {
		// TODO Auto-generated method stub
		if (this.activePIV != null) {
			this.activePIV.clearActive();
		}
	}
	
	public Node getShoppingCart() {
		return this.totalBox;
	}
}
