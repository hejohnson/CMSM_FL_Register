package views;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegisterView extends Scene{
	
	private Parent popup;
	private AnchorPane haveANiceDay;
	private AnchorPane registerLayout;
	private ImageView welcomeScreen;
	private Node hndBack;
	
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
        hideHaveNiceDay();
	}
	
	public void hideWelcome() {
		registerLayout.getChildren().remove(this.welcomeScreen);
	}
	
	public void setHaveNiceDay(AnchorPane ap) {
		this.haveANiceDay = ap;
	}
	
	public void showHaveNiceDay() {
		if (!this.registerLayout.getChildren().contains(haveANiceDay)) {
			this.registerLayout.getChildren().add(haveANiceDay);
			registerLayout.setBottomAnchor(this.haveANiceDay, 0.0);
		    registerLayout.setTopAnchor(this.haveANiceDay, 0.0);
	        registerLayout.setLeftAnchor(this.haveANiceDay, 0.0);
	        registerLayout.setRightAnchor(this.haveANiceDay, 0.0);
		}
	}
	
	public void hideHaveNiceDay() {
		if (this.registerLayout.getChildren().contains(haveANiceDay)) {
			this.registerLayout.getChildren().remove(haveANiceDay);
		}
		System.out.println("hiding hnd");
	}
	
	public void setHDBBack(Node hndb) {
		this.hndBack = hndb;
	}

	public Node getHDBBack() {
		return hndBack;
	}
}
