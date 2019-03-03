package app;

import java.util.ArrayList;

import controllers.ApplicationExitController;
import controllers.EditorCloseController;
import controllers.KeyExitController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
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
        
        ArrayList<Rectangle> boxes = new ArrayList<Rectangle>();
        boxes.add(new Rectangle(0,0,250,250));
        boxes.add(new Rectangle(1030,0,250,250));
        boxes.add(new Rectangle(0,775,250,250));
        boxes.add(new Rectangle(1030,775,250,250));        
        
        primaryStage.setScene(new Scene(root));
        primaryStage.setFullScreen(true);        
	    primaryStage.show();
//	    primaryStage.setOnCloseRequest(new EditorCloseController(iev));
	    primaryStage.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, new EditorCloseController(iev));
	    root.addEventFilter(KeyEvent.KEY_PRESSED, new KeyExitController(primaryStage));
        root.addEventFilter(MouseEvent.MOUSE_PRESSED, new ApplicationExitController(primaryStage, boxes));
    }

}
