package controllers;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import views.ItemPurchaserView;
import views.PurchasableItemView;
import views.ReceiptView;

public class ItemPurchasedControllerScenario2 implements EventHandler<MouseEvent> {

	private PurchasableItemView piv;
	private ItemPurchaserView ipv;
	private ReceiptView rv;
	
	public ItemPurchasedControllerScenario2(ItemPurchaserView _ipv, PurchasableItemView _piv, ReceiptView _rv) {
		this.piv = _piv;
		this.ipv = _ipv;
		this.rv = _rv;
	}

	@Override
	public void handle(MouseEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("");
		alert.setHeaderText("");
		alert.initOwner(this.ipv.getStage());
		alert.setGraphic(null);
		
		int imageHeight = 96;
		
		GridPane gp = new GridPane();
		//gp.setGridLinesVisible(true);
		
		this.rv.setActiveBG(this.piv.getItem().getName());
		
		Image image = new Image(getClass().getResourceAsStream(this.piv.getItem().getImagePath()));
		
		for (int i = 1; i <= 5; i++) {
			Button button = new Button();
			button.setGraphic(this.getCombinedImage(image, imageHeight, i));
			button.setOnAction(new PurchaseByImageController(piv.getItem(), i, alert, this.rv));
			gp.add(button, 0, i);
			//gp.add(button, (i<=3)?(int)(0.5*Math.pow(i, 2)+.5*i-1):((i%4)*4), (i<=3)?0:1, i, 1);			
		}
		
		alert.getDialogPane().setContent(gp);
		alert.showAndWait();
		
		if (alert.getResult() == ButtonType.CANCEL) {
			this.rv.clearActiveBG();
		}

		
	}
	
	public Canvas getCombinedImage(Image img, int height, int qty) {
		Canvas canvas = new Canvas(qty*height, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        for (int i = 0; i < qty; i++) {
			gc.drawImage(img, i*height, 0, height, height);			
		}
        
        return canvas;
	}

}
