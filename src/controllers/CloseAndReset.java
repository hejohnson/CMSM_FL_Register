package controllers;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import views.ItemPurchaserView;
import views.ReceiptView;

public class CloseAndReset implements Cancelable {

	Stage registerStage;
	Stage welcomeStage;
	Alert al;
	ReceiptView rv;
	ItemPurchaserView ipv;
	
	public CloseAndReset (Stage rs, Stage ws, Alert _al, ReceiptView _rv, ItemPurchaserView _ipv) {
		this.registerStage = rs;
		this.welcomeStage = ws;
		this.al = _al;
		this.rv = _rv;
		this.ipv = _ipv;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Platform.runLater(new RunnableSwitchWindows(this.registerStage, this.welcomeStage, this.al, this.rv, this.ipv));		
	}
	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

}
