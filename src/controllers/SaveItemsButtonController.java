package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import model.AllItems;
import views.ItemEditorView;

public class SaveItemsButtonController implements EventHandler<ActionEvent>{
	AllItems allItems;

	public SaveItemsButtonController(ItemEditorView iev) {
		allItems = iev.getAllItems();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		allItems.saveItems();
	}
	
	

}
