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
import javafx.stage.Modality;
import javafx.stage.Stage;
import views.TimeExpiringAlert;

public class RunnableTimeExpiring implements Runnable {
	
	private Stage rs;
	private Stage ws;
	private ActivityMonitorController amc;
	private TimeExpiringAlert tea;
	private Alert alert;

	public RunnableTimeExpiring (Stage _rs, Stage _ws, ActivityMonitorController _amc) {
		this.rs = _rs;
		this.ws = _ws;
		this.amc = _amc;
		this.alert = new Alert(AlertType.INFORMATION);
		alert.initOwner(this.rs);
		alert.initModality(Modality.NONE);
	}
	
	@Override
	public void run() {
		
		alert.setTitle("");
		alert.setHeaderText("");
		alert.setGraphic(null);
		
		GridPane gp = new GridPane();
		
		Text timeLeft = new Text();
		Integer time = 10;
		timeLeft.setText("Time Remaining: ".concat(Integer.toString(time)));

		gp.getChildren().add(timeLeft);
		
		Timer countdown = new Timer();
		countdown.scheduleAtFixedRate(new TimeTick(timeLeft, this.rs, this.ws, alert, this.amc.getReceiptView(), this.amc.getIPV()), 1000, 1000);
		
		alert.getDialogPane().setContent(gp);
		alert.showAndWait();
		
		countdown.cancel();
		
//		tea = new TimeExpiringAlert(this.amc);
//		//tea.getDialogPane().setOnMouseMoved(amc);
//		//tea.getDialogPane().setContent(new Text("Time is expiring. Tap anywhere to continue"));
//		tea.show();
	}
	
	public boolean cancel() {
		alert.close();
		//System.out.println("Closed tea");
		return true;
	}

}
