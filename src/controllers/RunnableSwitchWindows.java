package controllers;

import javafx.scene.control.Alert;
import javafx.stage.Stage;
import views.ItemPurchaserView;
import views.ReceiptView;

public class RunnableSwitchWindows implements Runnable {
	
	private Stage rs;
	private Stage ws;
	private Stage al;
	private ReceiptView rv;
	private ItemPurchaserView ipv;
	private ActivityMonitorController amc;

	public RunnableSwitchWindows (Stage _rs, Stage _ws, Stage al2, ReceiptView _rv, ItemPurchaserView _ipv, ActivityMonitorController _amc) {
		this.rs = _rs;
		this.ws = _ws;
		this.al = al2;
		this.rv = _rv;
		this.ipv = _ipv;
		this.amc = _amc;
	}
	
	@Override
	public void run() {
		this.al.close();
		this.rs.setAlwaysOnTop(false);
		this.ws.setAlwaysOnTop(true);
		this.rv.getReceipt().clear();
		this.rv.clear();
		this.ipv.reset();
		//this.amc.cancel();
		
	}

}
