package views;

import java.io.File;

import controllers.ButtonImageChangeRequestedController;
import controllers.DeleteItemController;
import controllers.ImageChangeRequestedController;
import controllers.ItemCategoryChangedController;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.AllItems;
import model.Item;

public class EditItemView extends HBox{

	private Stage stage;
	
	private Item item;
	// Needs a place to display the name
	private TextField nameField = new TextField();
	
	// Needs a place to display the name
	private TextField categoryField = new TextField();
	
	// Needs a clickable picture of the item
	private Button itemImgButton = new Button("");
	
	private Button buttonImgButton = new Button("");

	// Needs a box with the price
	private TextField priceField = new TextField();
	// Needs a checkbox for enabling/disabling
	private ToggleButton purchasableCheckbox = new ToggleButton();
	
	private Button deleteItemButton = new Button("");
	
	private Font textFieldFont = Font.font("Verdana", FontWeight.BOLD, 30);
	
	public EditItemView(Item _item, Stage _stage) {
		this.item = _item;
		this.stage = _stage;
		
		this.nameField.setText(this.item.getName());
		this.nameField.setAlignment(Pos.CENTER);
		this.nameField.setFont(textFieldFont);
		this.nameField.setPrefWidth(36*12);
		
		this.categoryField.setText(this.item.getCategory());
		this.categoryField.setAlignment(Pos.CENTER);
		this.categoryField.setFont(textFieldFont);
		this.categoryField.setPrefWidth(36*8);
		
		this.priceField.setText(String.format("%.2f", item.getPrice()));
		this.priceField.setAlignment(Pos.CENTER);
		this.priceField.setFont(textFieldFont);
		this.priceField.setPrefWidth(48*4);
		
		this.purchasableCheckbox.setSelected(item.isPurchasable());
		this.setToggleButtonImage();
		this.purchasableCheckbox.setAlignment(Pos.CENTER);
		this.purchasableCheckbox.setMaxHeight(72);
		this.purchasableCheckbox.setMinHeight(72);
		this.purchasableCheckbox.setPrefHeight(72);
		this.purchasableCheckbox.setMaxWidth(72);
		this.purchasableCheckbox.setMinWidth(72);
		this.purchasableCheckbox.setPrefWidth(72);
		
		this.updateImage(new Image("file:"+ new File(this.item.getImagePath()).getAbsolutePath()));
		this.updateButtonImage(new Image("file:"+ new File(this.item.getButtonImgPath()).getAbsolutePath()));
		
		ImageView deleteImage = new ImageView(new Image("file:"+new File("resources/core/trashcan.jpg").getAbsolutePath()));
		deleteImage.setPreserveRatio(true);
		deleteImage.setFitHeight(72);
		this.deleteItemButton.setGraphic(deleteImage);
		
		this.getChildren().addAll(this.buttonImgButton, this.itemImgButton, this.nameField, this.categoryField, this.priceField, this.purchasableCheckbox, this.deleteItemButton);
		this.setAlignment(Pos.CENTER);
	}
	
	public void initializeControllers(AllItems ai, VBox ei) {
		this.purchasableCheckbox.setOnAction(new PurchasableToggleController(this));
		this.nameField.setOnKeyReleased(new ItemNameChangedController(this));
		this.categoryField.setOnKeyReleased(new ItemCategoryChangedController(this));
		this.priceField.setOnKeyReleased(new PriceChangedController(this));
		this.itemImgButton.setOnAction(new ImageChangeRequestedController(this));
		this.buttonImgButton.setOnAction(new ButtonImageChangeRequestedController(this));
		this.deleteItemButton.setOnAction(new DeleteItemController(this, ai, ei));
		
	}
	
	private void setToggleButtonImage() {
		ImageView img;
		if (this.item.isPurchasable()) {
			img = new ImageView(new Image("file:"+new File("resources/core/checked.png").getAbsolutePath()));
		} else {
			img = new ImageView(new Image("file:"+new File("resources/core/unchecked.png").getAbsolutePath()));
		}
		img.setPreserveRatio(true);
		img.setFitHeight(72);
		this.purchasableCheckbox.setGraphic(img);
	}
	
	public Item getItem() {
		return item;
	}
	
	public String getCurrentName() {
		return this.nameField.getText();
	}
	
	public String getCurrentCategory() {
		return this.categoryField.getText();
	}
	
	public void updateImage(Image image) {
		ImageView itemImage = new ImageView(image);
		itemImage.setPreserveRatio(true);
		itemImage.setFitHeight(72);
		this.itemImgButton.setGraphic(itemImage);
	}
	
	public void updateButtonImage(Image image) {
		ImageView itemImage = new ImageView(image);
		itemImage.setPreserveRatio(true);
		itemImage.setFitHeight(72);
		this.buttonImgButton.setGraphic(itemImage);
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
