package controllers;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class WelcomeClickedController implements EventHandler<MouseEvent> {
	
	private Stage ws;
	private Stage rs;

	public WelcomeClickedController(Stage welcomeStage, Stage registerScreen) {
		this.ws = welcomeStage;
		this.rs = registerScreen;
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
//		this.rs.setFullScreen(true);
//		this.ws.hide();
//		this.rs.setFullScreen(true);
//		this.rs.show();
		this.rs.setAlwaysOnTop(true);
		this.ws.setAlwaysOnTop(false);
	}

}
