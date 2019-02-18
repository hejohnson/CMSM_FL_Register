package views;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegisterView extends Scene{
	
	private Parent popup;
	private AnchorPane registerLayout;
	private ImageView welcomeScreen;
	
	public RegisterView (AnchorPane p, int w, int h) {
		super(p, w, h);
		this.registerLayout = p;
	}

	public void addPopup(Parent layout) {
		this.popup = layout;
		registerLayout.getChildren().add(layout);
		registerLayout.setBottomAnchor(layout, 0.0);
		registerLayout.setTopAnchor(layout, 0.0);
		registerLayout.setLeftAnchor(layout, 0.0);
		registerLayout.setRightAnchor(layout, 0.0);
	}
	
	public void removePopup() {
		if (popup != null) {
			registerLayout.getChildren().remove(popup);
			popup = null;
		}
	}
	
	public void setWelcome(ImageView iv) {
		this.welcomeScreen = iv;
	}
	
	public void showWelcome() {
		this.registerLayout.getChildren().add(this.welcomeScreen);
		registerLayout.setBottomAnchor(this.welcomeScreen, 0.0);
	    registerLayout.setTopAnchor(this.welcomeScreen, 0.0);
        registerLayout.setLeftAnchor(this.welcomeScreen, 0.0);
        registerLayout.setRightAnchor(this.welcomeScreen, 0.0);
	}
	
	public void hideWelcome() {
		registerLayout.getChildren().remove(this.welcomeScreen);
	}
}
