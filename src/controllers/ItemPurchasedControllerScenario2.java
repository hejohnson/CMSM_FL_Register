package controllers;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import views.ItemPurchaserView;
import views.PurchasableItemView;
import views.ReceiptView;

public class ItemPurchasedControllerScenario2 implements EventHandler<MouseEvent> {

	private PurchasableItemView piv;
	private ItemPurchaserView ipv;
	private ReceiptView rv;
	private Stage ds;
	
	public ItemPurchasedControllerScenario2(ItemPurchaserView _ipv, PurchasableItemView _piv, ReceiptView _rv) {
		this.piv = _piv;
		this.ipv = _ipv;
		this.rv = _rv;
	}

	@Override
	public void handle(MouseEvent event) {
		
		int imageHeight = 64;
		
		BorderPane layout = new BorderPane();
		
		Scene dialogScene = new Scene(layout);
		this.ds = new Stage();
		this.ds.setScene(dialogScene);
		this.ds.initStyle(StageStyle.TRANSPARENT);
		this.ds.setMaximized(true);
		this.ds.show();
		this.ds.setAlwaysOnTop(true);
		this.ipv.getStage().setAlwaysOnTop(false);
		
		VBox container = new VBox();
		container.setAlignment(Pos.CENTER);
		layout.setCenter(container);
		layout.setPadding(new Insets(350, 450, 350, 450));
		dialogScene.setFill(Color.TRANSPARENT);
		layout.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 0.5), CornerRadii.EMPTY, Insets.EMPTY)));
		container.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(5))));
		container.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), new CornerRadii(15), Insets.EMPTY)));
		
		Text promptText = new Text("how many?");
		
		promptText.setFont(Font.font("FredokaOne", FontWeight.NORMAL, 30));
		
		container.getChildren().add(promptText);
		container.setPadding(new Insets(20, 20, 20, 20));
		VBox spacer = new VBox();
		spacer.setMinHeight(20);
		container.getChildren().add(spacer);
		//gp.setGridLinesVisible(true);
		
		this.rv.setActiveBG(this.piv.getItem().getName());
		
		Image image = new Image(getClass().getResourceAsStream(this.piv.getItem().getImagePath()));
		
		for (int i = 1; i <= 5; i++) {
			Button button = new Button();
			button.setGraphic(this.getCombinedImage(image, imageHeight, i));
			button.setOnAction(new PurchaseByImageController(piv.getItem(), i, ds, this.ipv.getStage(), this.rv));
			button.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), new CornerRadii(5), Insets.EMPTY)));
			container.getChildren().add(button);
			//gp.add(button, (i<=3)?(int)(0.5*Math.pow(i, 2)+.5*i-1):((i%4)*4), (i<=3)?0:1, i, 1);			
		}
		
		layout.setOnMouseClicked(new CancelPurchaseItemController(this.ds, this.ipv.getStage(), this.rv));

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
