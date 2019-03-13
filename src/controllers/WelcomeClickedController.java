package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
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
		this.registerView.hideWelcome();
		this.amc.enable();
		this.amc.start();
	}

}
