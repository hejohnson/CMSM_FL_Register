package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import model.AllItems;
import views.EditItemView;

public class DeleteItemController implements EventHandler<ActionEvent> {
	
	private EditItemView eiv;
	private AllItems ai;
	private VBox ei;

	public DeleteItemController (EditItemView _eiv, AllItems _ai, VBox _ei) {
		this.eiv = _eiv;
		this.ai = _ai;
		this.ei = _ei;
		
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		this.ei.getChildren().remove(this.eiv);
		this.ai.removeItem(this.eiv.getItem());
	}

}
