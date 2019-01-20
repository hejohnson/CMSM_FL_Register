package controllers;

import java.util.Timer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import views.TimeExpiringAlert;

public class WarnTimeExpiring implements Runnable, Cancelable {
	
	private Stage rs;
	private Stage ws;
	private ActivityMonitorController amc;
	private Alert alert;

	public WarnTimeExpiring (Stage _rs, Stage _ws, ActivityMonitorController _amc) {
		this.rs = _rs;
		this.ws = _ws;
		this.amc = _amc;
		this.alert = new Alert(AlertType.INFORMATION);
		alert.initOwner(this.rs);
		alert.initModality(Modality.NONE);
	}
	
	@Override
	public void run() {
		if (this.rs.isAlwaysOnTop()) {
		
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
		}
		
//		tea = new TimeExpiringAlert(this.amc);
//		//tea.getDialogPane().setOnMouseMoved(amc);
//		//tea.getDialogPane().setContent(new Text("Time is expiring. Tap anywhere to continue"));
//		tea.show();
	}
	
	public void cancel() {
		alert.close();
		//System.out.println("Closed tea");
	}

}
