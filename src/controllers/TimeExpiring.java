package controllers;

import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import views.TimeExpiringAlert;

public class TimeExpiring extends TimerTask {
	
	private Stage rs;
	private Stage ws;
	private ActivityMonitorController amc;
	private RunnableTimeExpiring rte;

	public TimeExpiring (Stage _rs, Stage _ws, ActivityMonitorController _amc) {
		this.rs = _rs;
		this.amc = _amc;
		this.ws = _ws;
		this.rte = new RunnableTimeExpiring(this.rs, this.ws, this.amc);
	}
	
	@Override
	public void run() {
		if (this.rs.isAlwaysOnTop()) {
			Platform.runLater(this.rte);
		}
		
	}
	
	@Override
	public boolean cancel() {
		rte.cancel();
		//System.out.println("Canceled tea");
		return true;
	}

}
