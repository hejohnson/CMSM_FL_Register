package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Item;
import views.ItemEditorView;

public class AddItemButtonController implements EventHandler<ActionEvent> {

	private ItemEditorView iev;
	
	public AddItemButtonController (ItemEditorView _iev) {
		this.iev = _iev;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Item itm = this.iev.getAllItems().addItem();
		this.iev.addItem(itm);
	}

}
