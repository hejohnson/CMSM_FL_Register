package views;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FullscreenPopup extends Stage {

	public FullscreenPopup(Parent layout) {
		super();
		Scene dialogScene = new Scene(layout, 1280, 1024);
		this.setScene(dialogScene);
		this.initStyle(StageStyle.TRANSPARENT);
		this.initModality(Modality.NONE);
		//this.setMaximized(true);
		dialogScene.setFill(Color.TRANSPARENT);
		
	}
	
	public FullscreenPopup() {
		super();
	}
	
	public void display(Stage other) {
		this.show();
		this.setX(0);
		this.setY(0);
		this.setAlwaysOnTop(true);
		other.setAlwaysOnTop(false);
	}
}
