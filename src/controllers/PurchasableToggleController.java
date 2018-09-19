package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import views.EditItemView;

public class PurchasableToggleController implements EventHandler<ActionEvent>{

	private EditItemView eiv;
	public PurchasableToggleController (EditItemView _eiv) {
		this.eiv = _eiv;
	}
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.eiv.togglePurchasable();
	}

}
