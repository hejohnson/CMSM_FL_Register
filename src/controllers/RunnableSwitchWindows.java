package controllers;

import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import views.ItemPurchaserView;
import views.ReceiptView;
import views.RegisterView;

public class RunnableSwitchWindows implements Runnable {
	
	private RegisterView rs;
	private Stage ws;
	private Stage al;
	private ReceiptView rv;
	private ItemPurchaserView ipv;
	private ActivityMonitorController amc;

	public RunnableSwitchWindows (RegisterView _rs, Stage _ws, ReceiptView _rv, ItemPurchaserView _ipv, ActivityMonitorController _amc) {
		this.rs = _rs;
		this.ws = _ws;
//		this.al = al2;
		this.rv = _rv;
		this.ipv = _ipv;
		this.amc = _amc;
	}
	
	@Override
	public void run() {
		this.rs.removePopup();
//		AnchorPane registerLayout = (AnchorPane) (this.rs.getScene().getRoot());
//		registerLayout.getChildren().remove(registerLayout.getChildren().size()-1);
//		this.al.close();
//		this.rs.hide();
		this.rs.setAlwaysOnTop(false);
		this.rs.setFullScreen(false);
//		this.ws.show();
		this.ws.setAlwaysOnTop(true);
		this.ws.setFullScreen(true);
		this.rv.getReceipt().clear();
		this.rv.clear();
		this.ipv.reset();
		//this.amc.cancel();
		
	}

}
