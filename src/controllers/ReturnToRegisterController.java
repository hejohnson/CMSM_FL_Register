package controllers;

import java.util.Timer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
//		AnchorPane registerLayout = (AnchorPane) (this.rs.getScene().getRoot());
		//registerLayout.getChildren().remove(registerLayout.getChildren().size()-1);
		//this.ds.close();
		this.rs.removePopup();
		this.rs.setAlwaysOnTop(true);
		this.tm.cancel();
		System.out.println("RRC");
		
	}
}
