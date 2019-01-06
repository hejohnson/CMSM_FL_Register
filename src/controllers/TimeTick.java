package controllers;

import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.ItemPurchaserView;
import views.ReceiptView;

public class TimeTick extends TimerTask {

	Text timeDisplay;
	Stage registerStage;
	Stage welcomeStage;
	Alert al;
	ReceiptView rv;
	ItemPurchaserView ipv;
	
	public TimeTick (Text td, Stage rs, Stage ws, Alert _al, ReceiptView _rv, ItemPurchaserView _ipv) {
		this.timeDisplay = td;
		this.registerStage = rs;
		this.welcomeStage = ws;
		this.al = _al;
		this.rv = _rv;
		this.ipv = _ipv;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int newTimeLeft = Integer.parseInt(this.timeDisplay.getText().substring(16))-1;
		if (newTimeLeft > 0) {
			this.timeDisplay.setText("Time Remaining: ".concat(Integer.toString(newTimeLeft)));
		} else {
			Platform.runLater(new RunnableSwitchWindows(this.registerStage, this.welcomeStage, this.al, this.rv, this.ipv));
		}
		
	}

}
