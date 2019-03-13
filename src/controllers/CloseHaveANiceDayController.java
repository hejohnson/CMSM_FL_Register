package controllers;

import java.util.Timer;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import views.ItemPurchaserView;
import views.ReceiptView;
import views.RegisterView;

public class CloseHaveANiceDayController implements Cancelable {

	private RegisterView rv;
	private Timer tm;
	private RunnableSwitchWindows rsw;
	
	public CloseHaveANiceDayController(RegisterView registerView, ReceiptView _rv, ItemPurchaserView _ipv, ActivityMonitorController _amc) {
		this.rv = registerView;
		rsw = new RunnableSwitchWindows(registerView, _rv, _ipv, _amc);
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.rv.hideHaveNiceDay();
		Platform.runLater(rsw);
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}


}
