package controllers;

import java.util.Timer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import views.ItemPurchaserView;
import views.ReceiptView;
import views.RegisterView;

public class ActivityMonitorController implements EventHandler<MouseEvent> {

	private Timer tm2;
	private ReceiptView rv;
	private RegisterView registerView;
	private ItemPurchaserView ipv;
	private Boolean enabled;

	private TimeExpiring te;

	public ActivityMonitorController(ReceiptView _rv, ItemPurchaserView _ipv, RegisterView _registerView) {
		this.tm2 = new Timer();
		this.enabled = false;
		this.rv = _rv;
		this.ipv = _ipv;
		this.registerView = _registerView;
		te = new TimeExpiring(new WarnTimeExpiring(this.registerView, this)); // Prevents NPE on first click
	}

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (enabled) {
			this.cancel();
			this.start();
		}
		
	}
	
	public void disable() {
		this.enabled = false;
		this.tm2.cancel();
	}
	
	public void enable() {
		this.enabled = true;
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
