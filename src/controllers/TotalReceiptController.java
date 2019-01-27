package controllers;

import java.util.Timer;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import views.ItemPurchaserView;
import views.ReceiptView;

public class TotalReceiptController implements EventHandler<MouseEvent> {

	private ReceiptView rv;
	private ItemPurchaserView ipv;
	private Stage rs;
	private Stage ws;
	private Alert alert;
	private Stage ds;
	private ImageView cartImg;
	
	private Font totalFont = Font.font("Verdana", FontWeight.BOLD, 20);
	
	private Font priceFont = Font.font("Verdana", FontWeight.BOLD, 32);
	
	public TotalReceiptController(ReceiptView _rv, ItemPurchaserView _ipv, Stage welcomeStage, Stage registerStage) {
		// TODO Auto-generated constructor stub
		this.rv = _rv;
		this.ipv = _ipv;
		this.rs = registerStage;
		this.ws = welcomeStage;
		
		this.alert = new Alert(AlertType.INFORMATION);
		alert.initOwner(this.rs);
		alert.initModality(Modality.NONE);
	}

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
//		alert.setContentText(Double.toString(this.rv.getReceipt().getTotal()));
//		alert.setTitle("");
//		alert.setHeaderText("");
//		alert.setGraphic(null);
//		alert.show();
		
		BorderPane layout = new BorderPane();
		
		Scene dialogScene = new Scene(layout);
		this.ds = new Stage();
		this.ds.setScene(dialogScene);
		this.ds.initStyle(StageStyle.TRANSPARENT);
		this.ds.initModality(Modality.NONE);
		this.ds.setMaximized(true);
		this.ds.show();
		this.ds.setAlwaysOnTop(true);
		this.ipv.getStage().setAlwaysOnTop(false);
		
		VBox container = new VBox();
		container.setAlignment(Pos.CENTER);
		layout.setCenter(container);
		layout.setPadding(new Insets(350, 450, 650, 450));
		dialogScene.setFill(Color.TRANSPARENT);
		layout.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 0.5), CornerRadii.EMPTY, Insets.EMPTY)));
		container.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(10))));
		container.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), new CornerRadii(30), Insets.EMPTY)));
		container.setPadding(new Insets(50, 0, 50, 0));
		
		Text totalWord = new Text("Total:");
		totalWord.setFont(totalFont);
		
		Text totalNumber = new Text(String.format("$%.2f", this.rv.getReceipt().getTotal()));
		totalNumber.setFont(priceFont);
		totalNumber.setFill(Color.GREEN);
		
		HBox cartContainer = new HBox();
		
		this.cartImg = new ImageView(new Image(getClass().getResourceAsStream("/images/shoppingCart.jpg")));
		this.cartImg.setPreserveRatio(true);
		this.cartImg.setFitWidth(100);
		
		
		
		cartContainer.setAlignment(Pos.CENTER);
		cartContainer.setPadding(new Insets(20, 0, 0, 0));
		cartContainer.getChildren().add(this.cartImg);
		
		container.getChildren().addAll(totalWord, totalNumber);
		layout.setBottom(cartContainer);
		
		Timer tm = new Timer();
		tm.schedule(new TimeExpiring(new CloseAndReset(this.rs, this.ws, this.ds, this.rv, this.ipv)), 5000);
		
		this.cartImg.setOnMouseClicked(new ReturnToRegisterController(this.ds, this.ipv.getStage(), tm));
	}

}
