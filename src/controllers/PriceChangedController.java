package controllers;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import views.EditItemView;

public class PriceChangedController implements EventHandler<KeyEvent> {

	private EditItemView eiv;
	private Stage stage;
	
	public PriceChangedController (EditItemView _eiv) {
		this.eiv = _eiv;
		this.stage = this.eiv.getStage();
	}
	
	@Override
	public void handle(KeyEvent event) {
		// TODO Auto-generated method stub
		String newPriceString = this.eiv.getCurrentPriceString();
		if (newPriceString.matches("-?\\d+(\\.\\d+)?")) {
			this.eiv.getItem().setPrice(Double.parseDouble(newPriceString));
		} else {
			Alert alert = new Alert(AlertType.ERROR, "Please enter only numerals or a decimal point. The value will be reset.");
			alert.initOwner(this.stage);
			alert.showAndWait();
			this.eiv.setPriceField(this.eiv.getItem().getPrice());
		}
		
	}

}
