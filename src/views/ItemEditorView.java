package views;
import controllers.AddItemButtonController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.AllItems;
import model.Item;

public class ItemEditorView extends VBox {
	
	private AllItems allItems;
	private Button addItemButton;
	private Stage stage;
	
	public ItemEditorView(AllItems _allItems, Stage _stage) {
		this.allItems = _allItems;
		this.stage = _stage;
		Text t = new Text("Add/Edit/Delete Items");
		t.setFont(Font.font("Verdana", FontWeight.BOLD, 48));
		this.getChildren().add(t);
		addItemButton = new Button();
		addItemButton.setText("Add New Item");
		addItemButton.setPrefHeight(96);
		addItemButton.setFont(Font.font("Verdana", FontWeight.BOLD, 48));
		addItemButton.setOnAction(new AddItemButtonController(this));
		this.getChildren().add(addItemButton);
		for (Item itm : allItems.getItems()) {
			addItem(itm);
			this.setAlignment(Pos.TOP_CENTER);
		}
		
		
	}
	
	public AllItems getAllItems() {
		return allItems;
	}

	public void addItem(Item itm) {
		EditItemView itemView = new EditItemView(itm, this.stage);
		itemView.initializeControllers();
		this.getChildren().add(itemView);
	}
}
