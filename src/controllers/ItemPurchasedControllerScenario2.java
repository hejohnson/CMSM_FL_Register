package controllers;

import java.util.ArrayList;
import java.util.Optional;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import model.Item;
import model.PurchasedItem;
import views.ItemPurchaserView;
import views.PurchasableItemView;

public class ItemPurchasedControllerScenario2 implements EventHandler<MouseEvent> {

	private PurchasableItemView piv;
	private ItemPurchaserView ipv;
	private Text total;
	
	public ItemPurchasedControllerScenario2(ItemPurchaserView _ipv, PurchasableItemView _piv, Text _total) {
		this.piv = _piv;
		this.ipv = _ipv;
		this.total = _total;
	}

	@Override
	public void handle(MouseEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("");
		alert.setHeaderText("");
		alert.initOwner(this.ipv.getStage());
		ImageView itemImage = this.piv.getImage();
		itemImage.setPreserveRatio(true);
		itemImage.setFitHeight(200);
		alert.setGraphic(null);
		
		int imageHeight = 96;
		
		ImageView iv = new ImageView();
		
		GridPane gp = new GridPane();
		Button buttonTypeOne = new Button();
		iv = new ImageView(new Image(getClass().getResourceAsStream(this.piv.getItem().getImagePath())));
		iv.setPreserveRatio(true);
		iv.setFitHeight(imageHeight);
		buttonTypeOne.setGraphic(iv);
		buttonTypeOne.setOnAction(new PurchaseByImageController(piv.getItem(), this.total, 1, alert));
		gp.add(buttonTypeOne, 0, 0);
		
		Button buttonTypeTwo = new Button();
		iv = new ImageView(new Image(getClass().getResourceAsStream(this.piv.getItem().getImagePath().concat("2"))));
		iv.setPreserveRatio(true);
		iv.setFitHeight(imageHeight);
		buttonTypeTwo.setGraphic(iv);
		buttonTypeTwo.setOnAction(new PurchaseByImageController(piv.getItem(), this.total, 2, alert));
		gp.add(buttonTypeTwo, 1, 0);
		
		Button buttonTypeThree = new Button();
		iv = new ImageView(new Image(getClass().getResourceAsStream(this.piv.getItem().getImagePath().concat("3"))));
		iv.setPreserveRatio(true);
		iv.setFitHeight(imageHeight);
		buttonTypeThree.setGraphic(iv);
		buttonTypeThree.setOnAction(new PurchaseByImageController(piv.getItem(), this.total, 3, alert));
		gp.add(buttonTypeThree, 5, 0);
		
		Button buttonTypeFour = new Button();
		iv = new ImageView(new Image(getClass().getResourceAsStream(this.piv.getItem().getImagePath().concat("4"))));
		iv.setPreserveRatio(true);
		iv.setFitHeight(imageHeight);
		buttonTypeFour.setGraphic(iv);
		buttonTypeFour.setOnAction(new PurchaseByImageController(piv.getItem(), this.total, 4, alert));
		gp.add(buttonTypeFour, 0, 1, 4, 1);
		
		Button buttonTypeFive = new Button();
		iv = new ImageView(new Image(getClass().getResourceAsStream(this.piv.getItem().getImagePath().concat("5"))));
		iv.setPreserveRatio(true);
		iv.setFitHeight(imageHeight);
		buttonTypeFive.setGraphic(iv);
		buttonTypeFive.setOnAction(new PurchaseByImageController(piv.getItem(), this.total, 5, alert));
		gp.add(buttonTypeFive, 2,1, 5, 1);
		
		
		alert.getDialogPane().setContent(gp);
		alert.showAndWait();

		
	}

}
