package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Receipt;

public class ReceiptView extends AnchorPane{
	private Receipt receipt;
	private VBox items;
	private Text totalValue;
	private Text totalText;
	private VBox totalBox;
	private PurchasedItemView activePIV;
	private CornerRadii cr;
	private BorderPane container;
	private ImageView cartImg;
	
	private HBox cartImgContainer;
	
	private Font totalFont = Font.font("Verdana", FontWeight.BOLD, 20);
	
	private Font priceFont = Font.font("Verdana", FontWeight.BOLD, 26);
	
	private VBox headerContainer;
	
	private Text headerText;
	
	public ReceiptView (Receipt _r) {
		this.receipt = _r;
		this.items = new VBox();
		this.totalBox = new VBox();
		this.totalValue = new Text();
		this.totalValue.setFont(priceFont);
		this.totalText = new Text();
		this.totalText.setFont(totalFont);
		this.totalText.setText("total");
		this.container = new BorderPane();
		
		this.headerText = new Text("shopping cart");
		this.headerText.setFont(priceFont);
		
		this.headerContainer = new VBox();
		this.headerContainer.setAlignment(Pos.CENTER);
		
//		Separator sep1 = new Separator();
//		sep1.setPadding(new Insets(10, 0, 10, 0));
//		
//		Separator sep2 = new Separator();
//		sep2.setPadding(new Insets(10, 0, 10, 0));
		
//		Line sep1 = new Line();
//		sep1.setStrokeWidth(5);
//		sep1.setLe
		
		
		this.headerContainer.getChildren().add(headerText);
		this.headerContainer.setPadding(new Insets(0, 0, 5, 0));
		this.headerContainer.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0, 0, 5, 0))));
		//this.headerContainer.getChildren().add(sep1);
		
		this.container.setTop(this.headerContainer);
		this.container.setCenter(this.items);
		this.cartImgContainer = new HBox();
		
		this.cartImg = new ImageView(new Image(getClass().getResourceAsStream("/images/shoppingCart.jpg")));
		this.cartImg.setPreserveRatio(true);
		this.cartImg.setFitWidth(100);
		
		this.cartImgContainer.getChildren().add(this.cartImg);
		this.cartImgContainer.setAlignment(Pos.CENTER);
		
		this.totalBox.setAlignment(Pos.CENTER);
		
		this.cr = new CornerRadii(10);
		
		this.container.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 0.65), CornerRadii.EMPTY, Insets.EMPTY)));
		this.container.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));
		
		this.totalBox.getChildren().addAll(this.totalText, this.totalValue);
		this.totalBox.setPadding(new Insets(10, 10, 10, 10));
		this.items.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0, 0, 5, 0))));
		//this.totalBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, this.cr, BorderWidths.DEFAULT)));
		this.container.setBottom(this.totalBox);
		//this.getChildren().addAll(this.items, this.total);
		this.container.setMinWidth(280);
		this.container.setPadding(new Insets(8, 20, 50, 20));
		//this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
		this.update();
		
		this.getChildren().addAll(this.container, this.cartImgContainer);
		
		this.setTopAnchor(this.container, 0.0);
		this.setBottomAnchor(this.container, 50.0);
		this.setLeftAnchor(this.cartImgContainer, 0.0);
		this.setRightAnchor(this.cartImgContainer, 0.0);
		this.setBottomAnchor(this.cartImgContainer, 0.0);
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
	
	public Node getCartImage() {
		return this.cartImg;
	}
}
