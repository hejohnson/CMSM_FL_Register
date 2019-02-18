package controllers;

import java.util.Timer;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import views.ItemPurchaserView;
import views.ReceiptView;
import views.RegisterView;

public class ActivityMonitorController implements EventHandler<MouseEvent> {

	private Timer tm;
	private Timer tm2;
	private ReceiptView rv;
	private RegisterView registerView;
	private ItemPurchaserView ipv;

	private TimeExpiring te;

	public ActivityMonitorController(ReceiptView _rv, ItemPurchaserView _ipv, RegisterView _registerView) {
		this.tm = new Timer();
		this.tm2 = new Timer();
		
		this.rv = _rv;
		this.ipv = _ipv;
		this.registerView = _registerView;
		
		te = new TimeExpiring(new WarnTimeExpiring(this.registerView, this));
//
//		tm2.schedule(te, 20000);
		//tm.schedule(new Reset(rv, ipv, ws, rs, te), 15000);
	}

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("triggered");
		//te.cancel();
//		te.cancel();
//		tm2.cancel();
//		
//		te = new TimeExpiring(new WarnTimeExpiring(this.rs, this.ws, this));
//		
//		tm2 = new Timer();
//		tm2.schedule(te, 20000);
		
		//tm = new Timer();
		//tm.schedule(new Reset(rv, ipv, ws, rs, te), 15000);
		this.cancel();
		this.start();
		
	}
	
	public void cancel() {
		te.cancel();
		tm2.cancel();
	}
	
	public void start() {
		te.cancel();
		tm2.cancel();
		
		te = new TimeExpiring(new WarnTimeExpiring(this.registerView, this));
		
		tm2 = new Timer();
		tm2.schedule(te, 20000);
	}
	
	public ReceiptView getReceiptView() {
		return this.rv;
	}
	
	public ItemPurchaserView getIPV() {
		return this.ipv;
	}

}
