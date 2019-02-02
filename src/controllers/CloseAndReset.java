package controllers;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import views.ItemPurchaserView;
import views.ReceiptView;

public class CloseAndReset implements Cancelable {

	Stage registerStage;
	Stage welcomeStage;
	Stage al;
	ReceiptView rv;
	ItemPurchaserView ipv;
	ActivityMonitorController amc;
	
	public CloseAndReset (Stage rs, Stage ws, Stage _al, ReceiptView _rv, ItemPurchaserView _ipv, ActivityMonitorController _amc) {
		this.registerStage = rs;
		this.welcomeStage = ws;
		this.al = _al;
		this.rv = _rv;
		this.ipv = _ipv;
		this.amc = _amc;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Platform.runLater(new RunnableSwitchWindows(this.registerStage, this.welcomeStage, this.al, this.rv, this.ipv, this.amc));		
	}
	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

}
