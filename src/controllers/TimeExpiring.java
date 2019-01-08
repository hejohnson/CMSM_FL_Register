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
	
	private Cancelable tt;

	public TimeExpiring (Cancelable _tt) {
		this.tt = _tt;
	}
	
	@Override
	public void run() {
		Platform.runLater(this.tt);	
	}
	
	@Override
	public boolean cancel() {
		tt.cancel();
		//System.out.println("Canceled tea");
		return true;
	}

}
