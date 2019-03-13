package controllers;

import java.util.Timer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import views.RegisterView;

public class ReturnToRegisterController implements EventHandler<MouseEvent> {

//	private Stage ds;
	private RegisterView rs;
	private Timer tm;
	private ActivityMonitorController amc;
	
	public ReturnToRegisterController(RegisterView _rs, Timer _tm, ActivityMonitorController _amc) {
//		this.ds = _ds;
		this.rs = _rs;
		this.tm = _tm;
		this.amc = _amc;
	}
	
	public ReturnToRegisterController(RegisterView _rs, ActivityMonitorController _amc) {
//		this.ds = _ds;
		this.rs = _rs;
		this.tm = new Timer();
		this.amc = _amc;
	}

	@Override
	public void handle(MouseEvent arg0) {
		arg0.consume();
		this.rs.removePopup();
		this.rs.hideHaveNiceDay();
		this.tm.cancel();
		System.out.println("RRC");
		this.amc.enable();
	}
}
