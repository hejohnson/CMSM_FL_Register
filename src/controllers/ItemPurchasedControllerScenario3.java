package controllers;

import java.util.Timer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Item;
import views.ItemPurchaserView;
import views.PurchasableItemView;

public class ItemPurchasedControllerScenario3 implements EventHandler<MouseEvent> {

	private PurchasableItemView piv;
	private Text total;
	private BorderPane totalBox;
	
	public ItemPurchasedControllerScenario3(ItemPurchaserView _ipv, PurchasableItemView _piv, Text _total, BorderPane _totalBox) {
		this.piv = _piv;
		this.total = _total;
		this.totalBox = _totalBox;
	}

	@Override
	public void handle(MouseEvent event) {
		this.purchaseItem(this.piv.getItem(), 1);
		this.totalBox.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
		this.piv.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
		
		new Timer();
		
		
		
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
