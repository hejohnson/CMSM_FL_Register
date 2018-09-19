package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import views.EditItemView;

public class ItemNameChangedController implements EventHandler<KeyEvent> {
	private EditItemView eiv;
	
	public ItemNameChangedController (EditItemView _eiv) {
		this.eiv = _eiv;
	}

	@Override
	public void handle(KeyEvent event) {
		this.eiv.getItem().setName(this.eiv.getCurrentName());
		
	}
}
