package controllers;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
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
		
		Pane spring = new Pane();
		spring.setPrefWidth(176);
		Pane spring2 = new Pane();
		spring2.setPrefWidth(192);
		
		Image image = new Image(getClass().getResourceAsStream(this.piv.getItem().getImagePath()));
		
		for (int i = 1; i <= 5; i++) {
			Button button = new Button();
			button.setGraphic(this.getCombinedImage(image, imageHeight, i));
			button.setOnAction(new PurchaseByImageController(piv.getItem(), i, alert, this.rv));
			gp.add(button, 0, i);
			//gp.add(button, (i<=3)?(int)(0.5*Math.pow(i, 2)+.5*i-1):((i%4)*4), (i<=3)?0:1, i, 1);			
		}
		
//		gp.add(spring, 1, 0);
//		gp.add(spring2, 4, 0);
		
//		Button buttonTypeOne = new Button();
////		iv = new ImageView(new Image(getClass().getResourceAsStream(this.piv.getItem().getImagePath())));
////		iv.setPreserveRatio(true);
////		iv.setFitHeight(imageHeight);
//		buttonTypeOne.setGraphic(this.getCombinedImage(image, imageHeight, 1));
//		buttonTypeOne.setOnAction(new PurchaseByImageController(piv.getItem(), this.total, 1, alert));
//		gp.add(buttonTypeOne, 0, 0);
//		
//		Button buttonTypeTwo = new Button();
////		iv = new ImageView(new Image(getClass().getResourceAsStream(this.piv.getItem().getImagePath().concat("2"))));
////		iv.setPreserveRatio(true);
////		iv.setFitHeight(imageHeight);
//		buttonTypeTwo.setGraphic(this.getCombinedImage(image, imageHeight, 2));
//		buttonTypeTwo.setOnAction(new PurchaseByImageController(piv.getItem(), this.total, 2, alert));
//		gp.add(buttonTypeTwo, 1, 0);
//		
//		Button buttonTypeThree = new Button();
////		iv = new ImageView(new Image(getClass().getResourceAsStream(this.piv.getItem().getImagePath().concat("3"))));
////		iv.setPreserveRatio(true);
////		iv.setFitHeight(imageHeight);
//		buttonTypeThree.setGraphic(this.getCombinedImage(image, imageHeight, 3));
//		buttonTypeThree.setOnAction(new PurchaseByImageController(piv.getItem(), this.total, 3, alert));
//		gp.add(buttonTypeThree, 5, 0);
//		
//		Button buttonTypeFour = new Button();
////		iv = new ImageView(new Image(getClass().getResourceAsStream(this.piv.getItem().getImagePath().concat("4"))));
////		iv.setPreserveRatio(true);
////		iv.setFitHeight(imageHeight);
//		buttonTypeFour.setGraphic(this.getCombinedImage(image, imageHeight, 4));
//		buttonTypeFour.setOnAction(new PurchaseByImageController(piv.getItem(), this.total, 4, alert));
//		gp.add(buttonTypeFour, 0, 1, 4, 1);
//		
//		Button buttonTypeFive = new Button();
////		iv = new ImageView(new Image(getClass().getResourceAsStream(this.piv.getItem().getImagePath().concat("5"))));
////		iv.setPreserveRatio(true);
////		iv.setFitHeight(imageHeight);
//		buttonTypeFive.setGraphic(this.getCombinedImage(image, imageHeight, 5));
//		buttonTypeFive.setOnAction(new PurchaseByImageController(piv.getItem(), this.total, 5, alert));
//		gp.add(buttonTypeFive, 2,1, 5, 1);
		
		alert.getDialogPane().setContent(gp);
		alert.showAndWait();

		
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
