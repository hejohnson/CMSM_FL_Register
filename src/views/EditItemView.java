package views;

import controllers.DeleteItemController;
import controllers.ImageChangeRequestedController;
import controllers.ItemNameChangedController;
import controllers.PriceChangedController;
import controllers.PurchasableToggleController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Item;

public class EditItemView extends HBox{

	private Stage stage;
	
	private Item item;
	// Needs a place to display the name
	private TextField nameField = new TextField();
	
	// Needs a clickable picture of the item
	private Button imageButton = new Button("");

	// Needs a box with the price
	private TextField priceField = new TextField();
	// Needs a checkbox for enabling/disabling
	private ToggleButton purchasableCheckbox = new ToggleButton();
	
	private Button deleteItemButton = new Button("");
	
	private Font textFieldFont = Font.font("Verdana", FontWeight.BOLD, 48);
	
	public EditItemView(Item _item, Stage _stage) {
		this.item = _item;
		this.stage = _stage;
		
		this.nameField.setText(this.item.getName());
		this.nameField.setAlignment(Pos.CENTER);
		this.nameField.setFont(textFieldFont);
		this.nameField.setPrefWidth(48*12);
		
		this.priceField.setText(String.format("%.2f", item.getPrice()));
		this.priceField.setAlignment(Pos.CENTER);
		this.priceField.setFont(textFieldFont);
		this.priceField.setPrefWidth(48*5);
		
		this.purchasableCheckbox.setSelected(item.isPurchasable());
		this.setToggleButtonImage();
		this.purchasableCheckbox.setAlignment(Pos.CENTER);
		this.purchasableCheckbox.setMaxHeight(96);
		this.purchasableCheckbox.setMinHeight(96);
		this.purchasableCheckbox.setPrefHeight(96);
		this.purchasableCheckbox.setMaxWidth(96);
		this.purchasableCheckbox.setMinWidth(96);
		this.purchasableCheckbox.setPrefWidth(96);
		
		this.updateImage(new Image(getClass().getResourceAsStream(this.item.getImagePath())));
		
		ImageView deleteImage = new ImageView(new Image(getClass().getResourceAsStream("/images/trashcan.jpg")));
		deleteImage.setPreserveRatio(true);
		deleteImage.setFitHeight(96);
		this.deleteItemButton.setGraphic(deleteImage);
		
		this.getChildren().addAll(this.imageButton, this.nameField, this.priceField, this.purchasableCheckbox, this.deleteItemButton);
		this.setAlignment(Pos.CENTER);
	}
	
	public void initializeControllers() {
		this.purchasableCheckbox.setOnAction(new PurchasableToggleController(this));
		this.nameField.setOnKeyReleased(new ItemNameChangedController(this));
		this.priceField.setOnKeyReleased(new PriceChangedController(this));
		this.imageButton.setOnAction(new ImageChangeRequestedController(this));
		//this.deleteItemButton.setOnAction(new DeleteItemController(this));
		
	}
	
	private void setToggleButtonImage() {
		ImageView img;
		if (this.item.isPurchasable()) {
			img = new ImageView(new Image(getClass().getResourceAsStream("/images/checked.png")));
		} else {
			img = new ImageView(new Image(getClass().getResourceAsStream("/images/unchecked.png")));
		}
		img.setPreserveRatio(true);
		img.setFitHeight(96);
		this.purchasableCheckbox.setGraphic(img);
	}
	
	public Item getItem() {
		return item;
	}
	
	public String getCurrentName() {
		return this.nameField.getText();
	}
	
	public void updateImage(Image image) {
		ImageView itemImage = new ImageView(image);
		itemImage.setPreserveRatio(true);
		itemImage.setFitHeight(96);
		this.imageButton.setGraphic(itemImage);
	}
	public String getCurrentPriceString() {
		return this.priceField.getText();
	}
	public void togglePurchasable() {
		this.item.setPurchasable(this.item.isPurchasable()^true);
		this.setToggleButtonImage();
	}

	public void setPriceField(double price) {
		this.priceField.setText(Double.toString(price));
		
	}

	public Stage getStage() {
		return this.stage;
	}
	
	
}
