package controllers;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import views.PurchasableItemView;
import views.ReceiptView;
import views.RegisterView;

public class ItemPurchasedControllerScenario2 implements EventHandler<MouseEvent> {

	private PurchasableItemView piv;
	private ReceiptView rv;
	private RegisterView registerView;
//	private Stage ds;
	
	public ItemPurchasedControllerScenario2(RegisterView _registerView, PurchasableItemView _piv, ReceiptView _rv) {
		this.piv = _piv;
		this.rv = _rv;
		this.registerView = _registerView;
	}

	@Override
	public void handle(MouseEvent event) {
		
		int imageHeight = 64;
		
		BorderPane layout = new BorderPane();
		
		VBox container = new VBox();
		container.setAlignment(Pos.CENTER);
		layout.setCenter(container);
		layout.setPadding(new Insets(350, 450, 350, 450));

		layout.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 0.5), CornerRadii.EMPTY, Insets.EMPTY)));
		container.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(5))));
		container.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), new CornerRadii(15), Insets.EMPTY)));
		
		Text promptText = new Text("how many?");
		
		promptText.setFont(Font.font("Fredoka One", FontWeight.NORMAL, 30));
		
		container.getChildren().add(promptText);
		container.setPadding(new Insets(20, 20, 20, 20));
		VBox spacer = new VBox();
		spacer.setMinHeight(20);
		container.getChildren().add(spacer);
		//gp.setGridLinesVisible(true);
		
		this.rv.setActiveBG(this.piv.getItem().getName());
		
		Image image = new Image(getClass().getResourceAsStream(this.piv.getItem().getImagePath()));
		
		for (int i = 1; i <= 5; i++) {
			Canvas button = getCombinedImage(image, imageHeight, i);
			button.setOnMouseReleased(new PurchaseByImageController(piv.getItem(), i, this.registerView, this.rv));
//			Button button = new Button();
//			button.setGraphic(this.getCombinedImage(image, imageHeight, i));
//			button.setOnMousePressed(new PurchaseByImageController(piv.getItem(), i, this.registerView, this.rv));
//			button.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), new CornerRadii(5), Insets.EMPTY)));
			container.getChildren().add(button);
			//gp.add(button, (i<=3)?(int)(0.5*Math.pow(i, 2)+.5*i-1):((i%4)*4), (i<=3)?0:1, i, 1);			
		}
		
		layout.setOnMousePressed(new CancelPurchaseItemController(this.registerView, this.rv));
		this.registerView.addPopup(layout);
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
