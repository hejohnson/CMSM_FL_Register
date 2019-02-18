package controllers;

import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import views.ItemPurchaserView;
import views.ReceiptView;
import views.RegisterView;

public class RunnableSwitchWindows implements Runnable {
	
	private RegisterView registerView;
	private ReceiptView rv;
	private ItemPurchaserView ipv;
	private ActivityMonitorController amc;

	public RunnableSwitchWindows (RegisterView _registerView, ReceiptView _rv, ItemPurchaserView _ipv, ActivityMonitorController _amc) {
		this.registerView = _registerView;
//		this.al = al2;
		this.rv = _rv;
		this.ipv = _ipv;
		this.amc = _amc;
	}
	
	@Override
	public void run() {
		this.registerView.removePopup();
//		AnchorPane registerLayout = (AnchorPane) (this.rs.getScene().getRoot());
//		registerLayout.getChildren().remove(registerLayout.getChildren().size()-1);
//		this.al.close();
//		this.rs.hide();
//		this.ws.show();
		this.registerView.showWelcome();
		this.rv.getReceipt().clear();
		this.rv.clear();
		this.ipv.reset();
		//this.amc.cancel();
		
	}

}
