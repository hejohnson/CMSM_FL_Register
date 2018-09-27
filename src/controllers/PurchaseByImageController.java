package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import model.Item;

public class PurchaseByImageController implements EventHandler<ActionEvent> {

	private Item item;
	private Text total;
	private int qty;
	private Alert alert;
	
	public PurchaseByImageController(Item _item, Text _total, int _i, Alert _alert) {
		this.item = _item;
		this.total = _total;
		this.qty = _i;
		this.alert = _alert;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		double currentTotal = Double.parseDouble(this.total.getText().substring(1));
		Double totalCost = currentTotal + this.item.getPrice()*this.qty;
		this.total.setText("$".concat(new Integer(totalCost.intValue()).toString()));
		alert.close();
	}

}
