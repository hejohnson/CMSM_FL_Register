package controllers;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.ItemPurchaserView;
import views.ReceiptView;
import views.TimeExpiringAlert;

public class RunnableSwitchWindows implements Runnable {
	
	private Stage rs;
	private Stage ws;
	private EventHandler<MouseEvent> amc;
	private TimeExpiringAlert tea;
	private Alert al;
	private ReceiptView rv;
	private ItemPurchaserView ipv;

	public RunnableSwitchWindows (Stage _rs, Stage _ws, Alert _al, ReceiptView _rv, ItemPurchaserView _ipv) {
		this.rs = _rs;
		this.ws = _ws;
		this.al = _al;
		this.rv = _rv;
		this.ipv = _ipv;
	}
	
	@Override
	public void run() {
		this.rs.setAlwaysOnTop(false);
		this.ws.setAlwaysOnTop(true);
		this.al.close();
		this.rv.clear();
		this.rv.getReceipt().clear();
		this.ipv.reset();
	}

}
