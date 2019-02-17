package views;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegisterView extends Stage{
	
	private Parent popup;
	
	public RegisterView () {
		super();
	}

	public void addPopup(Parent layout) {
		AnchorPane registerLayout = (AnchorPane) this.getScene().getRoot();
		this.popup = layout;
		registerLayout.getChildren().add(layout);
		registerLayout.setBottomAnchor(layout, 0.0);
		registerLayout.setTopAnchor(layout, 0.0);
		registerLayout.setLeftAnchor(layout, 0.0);
		registerLayout.setRightAnchor(layout, 0.0);
	}
	
	public void removePopup() {
		if (popup != null) {
			AnchorPane registerLayout = (AnchorPane) this.getScene().getRoot();
			registerLayout.getChildren().remove(popup);
			popup = null;
		}
	}
}
