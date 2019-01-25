package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.Item;

public class PurchasableItemView extends VBox{

	private Stage stage;
	
	private Item item;
	// Needs a place to display the name
	private Text nameField = new Text();

	// Needs a box with the price
	private Text priceField = new Text();
	
	private Font textFieldFont = Font.font("Verdana", FontWeight.BOLD, 26);
	
	private ImageView imgView;
	
	private ImageView priceBackgroundImg;
	
	private StackPane priceDisplay;
	
	private VBox itemInfo;
	
	private VBox container;
	
	public PurchasableItemView(Item _item, Stage _stage) {
		this.item = _item;
		this.stage = _stage;
		this.container = new VBox();
		
//		this.setPadding(new Insets(0, 20, 30, 20));
		
		this.updateImage(new Image(getClass().getResourceAsStream(this.item.getImagePath())));
		
		this.nameField.setText(this.item.getName());
		this.nameField.setWrappingWidth(180);
		this.nameField.setFont(textFieldFont);
		//this.nameField.prefHeight(36);
		this.nameField.setTextAlignment(TextAlignment.CENTER);
		
		DropShadow ds = new DropShadow();
		ds.setRadius(25);
		ds.setOffsetX(-3.0);
		ds.setOffsetY(3.0);
		ds.setColor(Color.BLACK);
		
		this.container.setAlignment(Pos.CENTER);
		this.container.setEffect(ds);
		
//		HBox spacerBox = new HBox();
//		spacerBox.setPrefHeight(50);
//		spacerBox.setPrefWidth(USE_COMPUTED_SIZE);
		
		
//		this.itemInfo = new VBox();
//		this.itemInfo.getChildren().addAll(this.nameField, this.imgView);
//		this.itemInfo.setAlignment(Pos.CENTER);
//		this.itemInfo.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(25), new BorderWidths(10))));
//		
//		VBox itemInfoOverlay = new VBox();
//		itemInfoOverlay.setBorder(new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID, new CornerRadii(25), new BorderWidths(10))));
//		
//		StackPane clippedItemInfo = new StackPane();
//		clippedItemInfo.getChildren().addAll(this.itemInfo, itemInfoOverlay);
//		
//		VBox infoContainer = new VBox();
//		infoContainer.getChildren().addAll(clippedItemInfo, spacerBox);
		
		this.priceField.setText(String.format("$%.2f", item.getPrice()));
		this.priceField.setFont(textFieldFont);
		//this.priceField.prefHeight(36);
		
//		this.priceBackgroundImg = new ImageView(new Image(getClass().getResourceAsStream("/images/priceBG.jpg")));
//		this.priceBackgroundImg.setPreserveRatio(true);
//		this.priceBackgroundImg.setFitHeight(100);
		
//		this.priceDisplay = new StackPane();		
//		this.priceDisplay.getChildren().addAll(this.priceBackgroundImg, this.priceField);
		
		this.container.getChildren().addAll(this.nameField, this.imgView, this.priceField);
		this.container.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(25), Insets.EMPTY)));
		this.getChildren().add(container);
		//this.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(25), new BorderWidths(10))));

//		this.setBottomAnchor(this.priceDisplay, 0.0);
//		this.setLeftAnchor(this.priceDisplay, 0.0);
//		this.setRightAnchor(this.priceDisplay, 0.0);
//		this.setTopAnchor(infoContainer, 0.0);

//		this.setAlignment(infoContainer, Pos.TOP_CENTER);
//		this.setAlignment(this.priceDisplay, Pos.BOTTOM_CENTER);

	}
	
	public Item getItem() {
		return item;
	}
	
	public void updateImage(Image image) {
		imgView = new ImageView(image);
		imgView.setPreserveRatio(true);
		imgView.setFitWidth(200);
	}

	public Stage getStage() {
		return this.stage;
	}
	
	public ImageView getImage() {
		return new ImageView(new Image(getClass().getResourceAsStream(this.item.getImagePath())));
	}
	
	
}
