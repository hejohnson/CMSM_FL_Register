package controllers;

import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import views.ItemPurchaserView;
import views.PurchasableItemView;
import views.ReceiptView;

public class Reset extends TimerTask {
	private ReceiptView rv;
	private ItemPurchaserView ipv;
	private Stage rs;
	private Stage ws;
	private TimeExpiring te;

	public Reset (ReceiptView _rv, ItemPurchaserView _ipv, Stage welcomeStage, Stage registerStage, TimeExpiring _te) {
		this.rv = _rv;
		this.ipv = _ipv;
		this.rs = registerStage;
		this.ws = welcomeStage;
		this.te = _te;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Platform.runLater(new RunnableReset(this.rv, this.ipv, this.ws, this.rs, this.te));
	}

}
