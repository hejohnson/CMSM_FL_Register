package controllers;

import java.util.Timer;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import views.ItemPurchaserView;
import views.ReceiptView;
import views.RegisterView;

public class TotalReceiptController implements EventHandler<MouseEvent> {

	private ReceiptView rv;
	private ItemPurchaserView ipv;
	private RegisterView registerView;
	private ImageView cartImg;
	private ActivityMonitorController amc;
	
	private Font totalFont = Font.font("Didact Gothic", FontWeight.NORMAL, 26);
	
	private Font priceFont = Font.font("Fredoka One", FontWeight.NORMAL, 30);
	
	public TotalReceiptController(ReceiptView _rv, ItemPurchaserView _ipv, RegisterView _registerView, ActivityMonitorController _amc) {
		// TODO Auto-generated constructor stub
		this.rv = _rv;
		this.ipv = _ipv;
		this.registerView = _registerView;
		this.amc = _amc;
		
	}

	@Override
	public void handle(MouseEvent arg0) {

		BorderPane layout = new BorderPane();
		
		this.registerView.addPopup(layout);
			
		VBox container = new VBox();
		container.setAlignment(Pos.CENTER);
		layout.setCenter(container);
		layout.setPadding(new Insets(350, 450, 650, 450));

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
		
		this.cartImg = new ImageView(new Image(getClass().getResourceAsStream("/images/backCart.png")));
		this.cartImg.setPreserveRatio(true);
		this.cartImg.setFitWidth(100);
		
		
		
		cartContainer.setAlignment(Pos.CENTER);
		cartContainer.setPadding(new Insets(20, 0, 0, 0));
		cartContainer.getChildren().add(this.cartImg);
		
		container.getChildren().addAll(totalWord, totalNumber);
		layout.setBottom(cartContainer);
		
		Timer tm = new Timer();
		tm.schedule(new TimeExpiring(new CloseAndReset(this.registerView, this.rv, this.ipv, this.amc)), 5000);
		
		layout.setOnMousePressed(new ReturnToRegisterController(this.registerView, tm));
	}

}
