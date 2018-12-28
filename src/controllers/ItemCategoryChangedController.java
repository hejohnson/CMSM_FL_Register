package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import views.EditItemView;

public class ItemCategoryChangedController implements EventHandler<KeyEvent> {
	private EditItemView eiv;
	
	public ItemCategoryChangedController (EditItemView _eiv) {
		this.eiv = _eiv;
	}

	@Override
	public void handle(KeyEvent event) {
		this.eiv.getItem().setCategory(this.eiv.getCurrentCategory());
		
	}
}
