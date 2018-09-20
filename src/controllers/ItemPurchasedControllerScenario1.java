package controllers;

import java.util.ArrayList;
import java.util.Optional;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.PurchasedItem;
import views.ItemPurchaserView;
import views.PurchasableItemView;

public class ItemPurchasedControllerScenario1 implements EventHandler<MouseEvent> {

	private PurchasableItemView piv;
	private ItemPurchaserView ipv;
	
	public ItemPurchasedControllerScenario1(ItemPurchaserView _ipv, PurchasableItemView _piv) {
		this.piv = _piv;
		this.ipv = _ipv;
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
		
		alert.getDialogPane().setExpandableContent(itemImage);

		ButtonType buttonTypeOne = new ButtonType("1");
		ButtonType buttonTypeTwo = new ButtonType("2");
		ButtonType buttonTypeThree = new ButtonType("3");
		ButtonType buttonTypeFour = new ButtonType("4");
		ButtonType buttonTypeFive = new ButtonType("5");

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeFour, buttonTypeFive);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne){
		    ipv.purchaseItem(piv.getItem(), 1);
		} else if (result.get() == buttonTypeTwo) {
		    // ... user chose "Two"
			ipv.purchaseItem(piv.getItem(), 2);
		} else if (result.get() == buttonTypeThree) {
		    // ... user chose "Three"
			ipv.purchaseItem(piv.getItem(), 3);
		} else if (result.get() == buttonTypeFour) {
		    // ... user chose "Three"
			ipv.purchaseItem(piv.getItem(), 4);
		} else if (result.get() == buttonTypeFive) {
		    // ... user chose "Three"
			ipv.purchaseItem(piv.getItem(), 5);
		} else {
		    // ... user chose CANCEL or closed the dialog
		}
		
	}

}
