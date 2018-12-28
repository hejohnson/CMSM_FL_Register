package controllers;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Item;
import model.PurchasedItem;
import views.ItemPurchaserView;
import views.PurchasableItemView;

public class ItemPurchasedControllerScenario3 implements EventHandler<MouseEvent> {

	private PurchasableItemView piv;
	private ItemPurchaserView ipv;
	private Text total;
	private BorderPane totalBox;
	
	public ItemPurchasedControllerScenario3(ItemPurchaserView _ipv, PurchasableItemView _piv, Text _total, BorderPane _totalBox) {
		this.piv = _piv;
		this.ipv = _ipv;
		this.total = _total;
		this.totalBox = _totalBox;
	}

	@Override
	public void handle(MouseEvent event) {
		this.purchaseItem(this.piv.getItem(), 1);
		this.totalBox.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
		this.piv.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
		
		Timer tm = new Timer();
		//tm.schedule(new ResetBackground(this.piv, this.totalBox), 2000);
		
		
		
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
