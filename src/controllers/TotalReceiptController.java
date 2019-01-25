package controllers;

import java.util.Timer;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import views.ItemPurchaserView;
import views.ReceiptView;

public class TotalReceiptController implements EventHandler<MouseEvent> {

	private ReceiptView rv;
	private ItemPurchaserView ipv;
	private Stage rs;
	private Stage ws;
	private Alert alert;
	
	public TotalReceiptController(ReceiptView _rv, ItemPurchaserView _ipv, Stage welcomeStage, Stage registerStage) {
		// TODO Auto-generated constructor stub
		this.rv = _rv;
		this.ipv = _ipv;
		this.rs = registerStage;
		this.ws = welcomeStage;
		
		this.alert = new Alert(AlertType.INFORMATION);
		alert.initOwner(this.rs);
		alert.initModality(Modality.NONE);
	}

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		alert.setContentText(Double.toString(this.rv.getReceipt().getTotal()));
		alert.setTitle("");
		alert.setHeaderText("");
		alert.setGraphic(null);
		alert.show();
		Timer tm = new Timer();
		tm.schedule(new TimeExpiring(new CloseAndReset(this.rs, this.ws, alert, this.rv, this.ipv)), 5000);
	}

}
