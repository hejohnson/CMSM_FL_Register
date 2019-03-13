package controllers;

import java.util.Timer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import views.ItemPurchaserView;
import views.ReceiptView;
import views.RegisterView;

public class HaveANiceDayController implements EventHandler<MouseEvent>, Cancelable {

	private RegisterView registerView;
	private ReceiptView rv;
	private ItemPurchaserView ipv;
	private ActivityMonitorController amc;
	private Timer tm;
	
	public HaveANiceDayController(RegisterView _registerView, Timer _tm, ReceiptView _rv, ItemPurchaserView _ipv, ActivityMonitorController _amc) {
		this.registerView = _registerView;
		this.tm = _tm;
		this.rv = _rv;
		this.ipv = _ipv;
		this.amc = _amc;
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		run();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		tm.cancel();
		this.registerView.showHaveNiceDay();
		
		Timer tm = new Timer();
		tm.schedule(new TimeExpiring(new CloseHaveANiceDayController(this.registerView, rv, ipv, amc)), 7000);
		this.registerView.getHDBBack().setOnMousePressed(new ReturnToRegisterController(this.registerView, tm, amc));
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}


}
