package app;

import controllers.EditorCloseController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.AllItems;
import views.ItemEditorView;

public class Editor extends Application{
	
	private static AllItems allItems;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		allItems = new AllItems();
		System.out.println(allItems.toString());
		launch();
		
	}
	
	@Override
    public void start(Stage primaryStage) {
        ItemEditorView iev = new ItemEditorView(allItems, primaryStage);
        StackPane root = new StackPane();
        
        
        root.getChildren().add(iev);
        
        
        
        primaryStage.setScene(new Scene(root));
        primaryStage.setFullScreen(true);        
	    primaryStage.show();
	    primaryStage.setOnCloseRequest(new EditorCloseController(iev));
    }

}
