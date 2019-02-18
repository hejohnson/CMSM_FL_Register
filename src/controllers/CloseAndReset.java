package controllers;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import views.ItemPurchaserView;
import views.ReceiptView;
import views.RegisterView;

public class CloseAndReset implements Cancelable {

	RegisterView registerView;
	ReceiptView rv;
	ItemPurchaserView ipv;
	ActivityMonitorController amc;
	
	public CloseAndReset (RegisterView _registerView, ReceiptView _rv, ItemPurchaserView _ipv, ActivityMonitorController _amc) {
		this.registerView = _registerView;
//		this.al = _al;
		this.rv = _rv;
		this.ipv = _ipv;
		this.amc = _amc;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Platform.runLater(new RunnableSwitchWindows(this.registerView, this.rv, this.ipv, this.amc));
		this.amc.cancel();
	}
	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

}
