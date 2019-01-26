package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import views.ReceiptView;

public class CancelPurchaseItemController implements EventHandler<MouseEvent> {

	private Stage ds;
	private Stage rs;
	private ReceiptView rv;
	
	public CancelPurchaseItemController (Stage _ds, Stage _rs, ReceiptView _rv) {
		this.ds = _ds;
		this.rs = _rs;
		this.rv = _rv;
	}
	
	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.ds.close();
		this.rs.setAlwaysOnTop(true);
		this.rv.clearActiveBG();
	}

}
