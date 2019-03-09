package controllers;

import java.util.Timer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import views.RegisterView;

public class ReturnToRegisterController implements EventHandler<MouseEvent> {

//	private Stage ds;
	private RegisterView rs;
	private Timer tm;
	
	public ReturnToRegisterController(RegisterView _rs, Timer _tm) {
//		this.ds = _ds;
		this.rs = _rs;
		this.tm = _tm;
	}

	@Override
	public void handle(MouseEvent arg0) {
		arg0.consume();
		this.rs.removePopup();
		this.tm.cancel();
		System.out.println("RRC");
		
	}
}
