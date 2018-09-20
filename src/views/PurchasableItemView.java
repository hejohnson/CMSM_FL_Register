package views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Item;

public class PurchasableItemView extends VBox{

	private Stage stage;
	
	private Item item;
	// Needs a place to display the name
	private Text nameField = new Text();

	// Needs a box with the price
	private Text priceField = new Text();
	
	private Font textFieldFont = Font.font("Verdana", FontWeight.BOLD, 48);
	
	private ImageView imgView;
	
	public PurchasableItemView(Item _item, Stage _stage) {
		this.item = _item;
		this.stage = _stage;
		
//		this.nameField.setText(this.item.getName());
//		this.nameField.setFont(textFieldFont);
//		this.nameField.prefHeight(48);
//		
		this.priceField.setText(String.format("%.2f", item.getPrice()));
		this.priceField.setFont(textFieldFont);
		this.priceField.prefHeight(48);
		
		this.updateImage(new Image(getClass().getResourceAsStream(this.item.getImagePath())));
		
		this.getChildren().addAll(this.imgView, this.nameField, this.priceField);
		this.setAlignment(Pos.CENTER);
	}
	
	public Item getItem() {
		return item;
	}
	
	public void updateImage(Image image) {
		imgView = new ImageView(image);
		imgView.setPreserveRatio(true);
		imgView.setFitHeight(96);
	}

	public Stage getStage() {
		return this.stage;
	}
	
	public ImageView getImage() {
		return new ImageView(new Image(getClass().getResourceAsStream(this.item.getImagePath())));
	}
	
	
}
