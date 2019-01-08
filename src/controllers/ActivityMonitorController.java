package controllers;

import java.util.Timer;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import views.ItemPurchaserView;
import views.ReceiptView;

public class ActivityMonitorController implements EventHandler<MouseEvent> {

	private Timer tm;
	private Timer tm2;
	private ReceiptView rv;
	private ItemPurchaserView ipv;
	private Stage rs;
	private Stage ws;
	private TimeExpiring te;

	public ActivityMonitorController(ReceiptView _rv, ItemPurchaserView _ipv, Stage welcomeStage, Stage registerStage) {
		this.tm = new Timer();
		this.tm2 = new Timer();
		
		this.rv = _rv;
		this.ipv = _ipv;
		this.rs = registerStage;
		this.ws = welcomeStage;
		
		te = new TimeExpiring(new WarnTimeExpiring(this.rs, this.ws, this));

		tm2.schedule(te, 20000);
		//tm.schedule(new Reset(rv, ipv, ws, rs, te), 15000);
	}

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("triggered");
		//te.cancel();
		tm.cancel();
		te.cancel();
		tm2.cancel();
		
		te = new TimeExpiring(new WarnTimeExpiring(this.rs, this.ws, this));
		
		tm2 = new Timer();
		tm2.schedule(te, 20000);
		
		//tm = new Timer();
		//tm.schedule(new Reset(rv, ipv, ws, rs, te), 15000);
		
	}
	
	public ReceiptView getReceiptView() {
		return this.rv;
	}
	
	public ItemPurchaserView getIPV() {
		return this.ipv;
	}

}
