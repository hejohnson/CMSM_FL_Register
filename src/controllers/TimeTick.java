package controllers;

import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.ItemPurchaserView;
import views.ReceiptView;
import views.RegisterView;

public class TimeTick extends TimerTask {

	Text timeDisplay;
	RegisterView registerView;
	Stage al;
	ReceiptView rv;
	ItemPurchaserView ipv;
	ActivityMonitorController amc;
	
	public TimeTick (Text td, RegisterView _registerView, ReceiptView _rv, ItemPurchaserView _ipv, ActivityMonitorController _amc) {
		this.timeDisplay = td;
		this.registerView = _registerView;
		this.rv = _rv;
		this.ipv = _ipv;
		this.timeDisplay.setFont(Font.font("FredokaOne", FontWeight.NORMAL, 20));
		this.amc = _amc;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int newTimeLeft = Integer.parseInt(this.timeDisplay.getText().substring(16))-1;
		if (newTimeLeft > 0) {
			this.timeDisplay.setText("Time Remaining: ".concat(Integer.toString(newTimeLeft)));
		} else {
			Platform.runLater(new RunnableSwitchWindows(this.registerView, this.rv, this.ipv, this.amc));
		}
		
	}

}
