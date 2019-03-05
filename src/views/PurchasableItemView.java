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
	
	private Font textFieldFont = Font.font("Didact Gothic", FontWeight.NORMAL, 26);
	
	private Font priceFont = Font.font("Fredoka One", FontWeight.NORMAL, 30);
	
	private ImageView imgView;
	
	private AnchorPane container;
	
	public PurchasableItemView(Item _item) {
		this.item = _item;

		this.container = new AnchorPane();
		
		VBox nameContainer = new VBox();
		nameContainer.getChildren().add(nameField);
		nameContainer.setAlignment(Pos.CENTER);
		
		VBox priceContainer = new VBox();
		priceContainer.getChildren().add(priceField);
		priceContainer.setAlignment(Pos.CENTER);
		
		this.updateImage(new Image(getClass().getResourceAsStream(this.item.getButtonImgPath())));
		
		VBox imgContainer = new VBox();
		imgContainer.getChildren().add(this.imgView);
		imgContainer.setAlignment(Pos.CENTER);
		
//		this.setPadding(new Insets(0, 20, 30, 20));
		
		
		
		this.nameField.setText(this.item.getName());
		this.nameField.setWrappingWidth(150);
		this.nameField.setFont(textFieldFont);
		this.nameField.setFill(Color.rgb(89, 89, 89));
		//this.nameField.prefHeight(36);
		this.nameField.setTextAlignment(TextAlignment.CENTER);
		this.nameField.setLineSpacing(-10);
		this.container.setPadding(new Insets(5,10,5,10));
		
		DropShadow ds = new DropShadow();
		ds.setRadius(25);
		ds.setWidth(5);
		ds.setHeight(5);
		ds.setOffsetX(-5.0);
		ds.setOffsetY(5.0);
		ds.setColor(Color.rgb(30, 30, 30));
		
		//this.container.setAlignment(Pos.CENTER);
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
		
		if (this.item.getPrice() == 0.0) {
			this.priceField.setText("free");
		} else {
			this.priceField.setText(String.format("$%.2f", item.getPrice()));
		}
		
		
		this.priceField.setFont(priceFont);
		this.priceField.setFill(Color.rgb(89, 89, 89));
		//this.priceField.prefHeight(36);
		
//		this.priceBackgroundImg = new ImageView(new Image(getClass().getResourceAsStream("/images/priceBG.jpg")));
//		this.priceBackgroundImg.setPreserveRatio(true);
//		this.priceBackgroundImg.setFitHeight(100);
		
//		this.priceDisplay = new StackPane();		
//		this.priceDisplay.getChildren().addAll(this.priceBackgroundImg, this.priceField);
		
		this.container.getChildren().addAll(nameContainer, imgContainer, priceContainer);
//		this.container.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(40), Insets.EMPTY)));
//		this.container.setBorder(new Border(new BorderStroke(Color.rgb(150,150,150), BorderStrokeStyle.SOLID, new CornerRadii(38), new BorderWidths(2))));
		this.getChildren().add(container);
		//this.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(25), new BorderWidths(10))));

//		this.setBottomAnchor(this.priceDisplay, 0.0);
//		this.setLeftAnchor(this.priceDisplay, 0.0);
//		this.setRightAnchor(this.priceDisplay, 0.0);
//		this.setTopAnchor(infoContainer, 0.0);

//		this.setAlignment(infoContainer, Pos.TOP_CENTER);
//		this.setAlignment(this.priceDisplay, Pos.BOTTOM_CENTER);
		
		this.container.setLeftAnchor(nameContainer, 15.0);
		this.container.setRightAnchor(nameContainer, 0.0);
		this.container.setTopAnchor(nameContainer, 23.0);
		
		imgContainer.toBack();
		
		
		
		this.container.setBottomAnchor(imgContainer, 0.0);
		this.container.setLeftAnchor(imgContainer, 0.0);
		this.container.setRightAnchor(imgContainer, 0.0);
		this.container.setTopAnchor(imgContainer, 0.0);
		
		this.container.setBottomAnchor(priceContainer, 40.0);
		this.container.setLeftAnchor(priceContainer, 15.0);
		this.container.setRightAnchor(priceContainer, 0.0);

	}
	
	public Item getItem() {
		return item;
	}
	
	public void updateImage(Image image) {
		imgView = new ImageView(image);
		imgView.setPreserveRatio(true);
		imgView.setFitWidth(218);
	}
	
	public ImageView getImage() {
		return new ImageView(new Image(getClass().getResourceAsStream(this.item.getImagePath())));
	}
	
	
}
