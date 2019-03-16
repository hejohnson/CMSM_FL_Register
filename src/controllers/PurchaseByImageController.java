package controllers;

import java.util.Timer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Item;
import views.ReceiptView;
import views.RegisterView;

public class PurchaseByImageController implements EventHandler<MouseEvent> {

	private Item item;
	private int qty;
	private ReceiptView rv;
	private RegisterView rs;
	
	public PurchaseByImageController(Item _item, int _i, RegisterView _rs, ReceiptView _rv) {
		this.item = _item;
		this.qty = _i;
		this.rv = _rv;
		this.rs = _rs;
	}
	
	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		this.rv.getReceipt().purchaseItem(this.item, this.qty);
		this.rv.update();

		this.rs.removePopup();
		this.rv.setTotalBG();
		Timer tm = new Timer();
		tm.schedule(new ResetBackground(this.rv), 1000);
	}

}
