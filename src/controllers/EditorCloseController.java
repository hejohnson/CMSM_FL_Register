package controllers;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import model.AllItems;
import views.ItemEditorView;

public class EditorCloseController implements EventHandler<WindowEvent>{
	AllItems allItems;

	public EditorCloseController(ItemEditorView iev) {
		allItems = iev.getAllItems();
	}

	@Override
	public void handle(WindowEvent event) {
		// TODO Auto-generated method stub
		allItems.saveItems();
	}
	
	

}
