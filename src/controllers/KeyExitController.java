package controllers;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class KeyExitController implements EventHandler<KeyEvent> {
	
	Stage s1;
	Stage s2;
	
	public KeyExitController (Stage stage1) {
		this.s1 = stage1;
	}
	
	@Override
	public void handle(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Key pressed");
		System.out.println(arg0.getCode().toString());
		if (arg0.getCode().equals(KeyCode.ESCAPE)) {
			Platform.exit();
			this.s1.fireEvent(new WindowEvent(this.s1, WindowEvent.WINDOW_CLOSE_REQUEST));
		}
	}

}
