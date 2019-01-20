package controllers;

import javafx.scene.control.Alert;
import javafx.stage.Stage;
import views.ItemPurchaserView;
import views.ReceiptView;

public class RunnableSwitchWindows implements Runnable {
	
	private Stage rs;
	private Stage ws;
	private Alert al;
	private ReceiptView rv;
	private ItemPurchaserView ipv;

	public RunnableSwitchWindows (Stage _rs, Stage _ws, Alert _al, ReceiptView _rv, ItemPurchaserView _ipv) {
		this.rs = _rs;
		this.ws = _ws;
		this.al = _al;
		this.rv = _rv;
		this.ipv = _ipv;
	}
	
	@Override
	public void run() {
		this.al.close();
		this.rs.setAlwaysOnTop(false);
		this.ws.setAlwaysOnTop(true);
		this.rv.getReceipt().clear();
		this.rv.clear();
		this.ipv.reset();
	}

}
