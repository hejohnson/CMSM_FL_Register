package controllers;

import java.util.Timer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ReturnToRegisterController implements EventHandler<MouseEvent> {

	private Stage ds;
	private Stage rs;
	private Timer tm;
	
	public ReturnToRegisterController(Stage _ds, Stage _rs, Timer _tm) {
		this.ds = _ds;
		this.rs = _rs;
		this.tm = _tm;
	}

	@Override
	public void handle(MouseEvent arg0) {
		this.ds.close();
		this.rs.setAlwaysOnTop(true);
		this.tm.cancel();
		
	}
}
