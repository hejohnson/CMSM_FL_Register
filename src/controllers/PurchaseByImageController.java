package controllers;

import java.util.Timer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import model.Item;
import views.ReceiptView;

public class PurchaseByImageController implements EventHandler<ActionEvent> {

	private Item item;
	private Text total;
	private int qty;
	private Alert alert;
	private ReceiptView rv;
	
	public PurchaseByImageController(Item _item, int _i, Alert _alert, ReceiptView _rv) {
		this.item = _item;
		this.qty = _i;
		this.alert = _alert;
		this.rv = _rv;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		this.rv.getReceipt().purchaseItem(this.item, this.qty);
		this.rv.update();
		
//		double currentTotal = Double.parseDouble(this.total.getText().substring(1));
//		Double totalCost = currentTotal + this.item.getPrice()*this.qty;
//		this.total.setText("$".concat(new Integer(totalCost.intValue()).toString()));
		alert.close();
		this.rv.setTotalBG();
		Timer tm = new Timer();
		tm.schedule(new ResetBackground(this.rv), 1000);
	}

}
