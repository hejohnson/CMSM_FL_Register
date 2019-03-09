package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import views.ReceiptView;
import views.RegisterView;

public class CancelPurchaseItemController implements EventHandler<MouseEvent> {


	private RegisterView rs;
	private ReceiptView rv;
	
	public CancelPurchaseItemController (RegisterView _rs, ReceiptView _rv) {
		this.rs = _rs;
		this.rv = _rv;
	}
	
	@Override
	public void handle(MouseEvent arg0) {
		arg0.consume();
		this.rs.removePopup();
		this.rv.clearActiveBG();
	}

}
