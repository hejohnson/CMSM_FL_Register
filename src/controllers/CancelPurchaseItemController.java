package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import views.ReceiptView;
import views.RegisterView;

public class CancelPurchaseItemController implements EventHandler<MouseEvent> {


	private RegisterView rs;
	private ReceiptView rv;
	
	public CancelPurchaseItemController (RegisterView _rs, ReceiptView _rv) {
		this.rs = _rs;
		this.rv = _rv;
	}
	
	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		AnchorPane registerLayout = (AnchorPane) (this.rs.getScene().getRoot());
//		registerLayout.getChildren().remove(registerLayout.getChildren().size()-1);
		arg0.consume();
		this.rs.removePopup();
		this.rs.setAlwaysOnTop(true);
		this.rv.clearActiveBG();
	}

}
