package views;
import controllers.AddItemButtonController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
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
		addItemButton = new Button();
		addItemButton.setText("Add a new item");
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
