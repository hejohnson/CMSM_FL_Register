package views;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PopupWindow extends Stage {

	public PopupWindow () {
		this.initStyle(StageStyle.TRANSPARENT);
	    this.setMaximized(true);
	    this.show();
	    this.setAlwaysOnTop(true);
	}
}
