package controllers;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import views.RegisterView;

public class WelcomeClickedController implements EventHandler<MouseEvent> {
	
	private RegisterView registerView;
	private ActivityMonitorController amc;

	public WelcomeClickedController(RegisterView _registerView, ActivityMonitorController _amc) {
		this.registerView = _registerView;
		this.amc = _amc;
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
//		this.rs.setFullScreen(true);
//		this.ws.hide();
//		this.rs.setFullScreen(true);
//		this.rs.show();
//		this.ws.hide();
//		this.ws.setAlwaysOnTop(false);
//		this.ws.setFullScreen(false);
////		this.rs.show();
//		this.rs.setFullScreen(true);
//		this.rs.setAlwaysOnTop(true);
		this.registerView.hideWelcome();
		this.amc.start();
		System.out.println("Clicked");
	}

}
