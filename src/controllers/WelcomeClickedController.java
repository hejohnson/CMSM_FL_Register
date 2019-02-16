package controllers;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class WelcomeClickedController implements EventHandler<MouseEvent> {
	
	private Stage ws;
	private Stage rs;
	private ActivityMonitorController amc;

	public WelcomeClickedController(Stage welcomeStage, Stage registerScreen, ActivityMonitorController _amc) {
		this.ws = welcomeStage;
		this.rs = registerScreen;
		this.amc = _amc;
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
//		this.rs.setFullScreen(true);
//		this.ws.hide();
//		this.rs.setFullScreen(true);
//		this.rs.show();
		this.ws.hide();
		this.ws.setAlwaysOnTop(false);
		this.rs.show();
		this.rs.setAlwaysOnTop(true);
		this.amc.start();
		System.out.println("Clicked");
	}

}
