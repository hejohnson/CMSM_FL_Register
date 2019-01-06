package controllers;

import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import views.ItemPurchaserView;
import views.PurchasableItemView;
import views.ReceiptView;

public class RunnableReset implements Runnable {
	private ReceiptView rv;
	private ItemPurchaserView ipv;
	private Stage rs;
	private Stage ws;
	private TimeExpiring te;

	public RunnableReset (ReceiptView _rv, ItemPurchaserView _ipv, Stage welcomeStage, Stage registerStage, TimeExpiring _te) {
		this.rv = _rv;
		this.ipv = _ipv;
		this.rs = registerStage;
		this.ws = welcomeStage;
		this.te = _te;
	}
	
	@Override
	public void run() {
						// TODO Auto-generated method stub
		//System.out.println("Resetting");
		this.te.cancel();
		this.rv.clear();
		this.rv.getReceipt().clear();
		this.ipv.reset();
		this.ws.setFullScreen(true);
		this.ws.show();
	}

}
