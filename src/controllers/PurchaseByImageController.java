package controllers;

import java.util.Timer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Item;
import views.ReceiptView;
import views.RegisterView;

public class PurchaseByImageController implements EventHandler<ActionEvent> {

	private Item item;
	private Text total;
	private int qty;
	private Stage alert;
	private ReceiptView rv;
	private RegisterView rs;
	
	public PurchaseByImageController(Item _item, int _i, Stage _alert, RegisterView _rs, ReceiptView _rv) {
		this.item = _item;
		this.qty = _i;
		this.alert = _alert;
		this.rv = _rv;
		this.rs = _rs;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		this.rv.getReceipt().purchaseItem(this.item, this.qty);
		this.rv.update();
//		this.rv.clearActiveBG();
		
//		double currentTotal = Double.parseDouble(this.total.getText().substring(1));
//		Double totalCost = currentTotal + this.item.getPrice()*this.qty;
//		this.total.setText("$".concat(new Integer(totalCost.intValue()).toString()));
//		AnchorPane registerLayout = (AnchorPane) (this.rs.getScene().getRoot());
		//registerLayout.getChildren().remove(registerLayout.getChildren().size()-1);
//		alert.hide();
		this.rs.removePopup();
		this.rs.setAlwaysOnTop(true);
		this.rv.setTotalBG();
		Timer tm = new Timer();
		tm.schedule(new ResetBackground(this.rv), 1000);
	}

}
