package controllers;

import java.util.ArrayList;
import java.util.Optional;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import model.Item;
import model.PurchasedItem;
import views.ItemPurchaserView;
import views.PurchasableItemView;

public class ItemPurchasedControllerScenario1 implements EventHandler<MouseEvent> {

	private PurchasableItemView piv;
	private ItemPurchaserView ipv;
	private Text total;
	
	public ItemPurchasedControllerScenario1(ItemPurchaserView _ipv, PurchasableItemView _piv, Text _total) {
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
		alert.getDialogPane().setContent(itemImage);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

		ButtonType buttonTypeOne = new ButtonType("1");
		ButtonType buttonTypeTwo = new ButtonType("2");
		ButtonType buttonTypeThree = new ButtonType("3");
		ButtonType buttonTypeFour = new ButtonType("4");
		ButtonType buttonTypeFive = new ButtonType("5");

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeFour, buttonTypeFive);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne){
		    this.purchaseItem(piv.getItem(), 1);
		} else if (result.get() == buttonTypeTwo) {
		    // ... user chose "Two"
			this.purchaseItem(piv.getItem(), 2);
		} else if (result.get() == buttonTypeThree) {
		    // ... user chose "Three"
			this.purchaseItem(piv.getItem(), 3);
		} else if (result.get() == buttonTypeFour) {
		    // ... user chose "Three"
			this.purchaseItem(piv.getItem(), 4);
		} else if (result.get() == buttonTypeFive) {
		    // ... user chose "Three"
			this.purchaseItem(piv.getItem(), 5);
		} else {
		    // ... user chose CANCEL or closed the dialog
		}
		
	}
	
	public void purchaseItem(Item itm, int _qty) {
		// increment total
		//this.purchasedItems.add(new PurchasedItem(itm, _qty));
//		Double totalCost = 0.0;
//		for (PurchasedItem pitm:purchasedItems) {
//			totalCost = totalCost + pitm.getTotalPrice();
//		}
		double currentTotal = Double.parseDouble(this.total.getText().substring(1));
		Double totalCost = currentTotal + itm.getPrice()*_qty;
		this.total.setText("$".concat(new Integer(totalCost.intValue()).toString()));
		
	}

}
