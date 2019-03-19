package controllers;

import java.io.File;
import java.util.Timer;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
	private ImageView payImg;
	private ActivityMonitorController amc;
	
	private Font totalFont = Font.font("Didact Gothic", FontWeight.NORMAL, 28);
	
	private Font priceFont = Font.font("Fredoka One", FontWeight.NORMAL, 42);
	
	public TotalReceiptController(ReceiptView _rv, ItemPurchaserView _ipv, RegisterView _registerView, ActivityMonitorController _amc) {
		// TODO Auto-generated constructor stub
		this.rv = _rv;
		this.ipv = _ipv;
		this.registerView = _registerView;
		this.amc = _amc;
		
	}

	@Override
	public void handle(MouseEvent arg0) {

		AnchorPane layout = new AnchorPane();
		//layout.setPadding(new Insets(300, 350, 650, 350));
		layout.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 0.5), CornerRadii.EMPTY, Insets.EMPTY)));
		
		
		this.payImg = new ImageView(new Image("file:"+new File("resources/core/pay.png").getAbsolutePath()));
		VBox payContainer = new VBox();
		payContainer.getChildren().add(payImg);
		payContainer.setAlignment(Pos.CENTER);
		layout.getChildren().add(payContainer);
		layout.setLeftAnchor(payContainer, 0.0);
		layout.setRightAnchor(payContainer, 0.0);
		layout.setBottomAnchor(payContainer, 420.0);
		
		VBox container = new VBox();
		VBox totalContainer = new VBox();
		totalContainer.setAlignment(Pos.CENTER);
		container.setAlignment(Pos.CENTER);
		
		Text totalWord = new Text("total:");
		totalWord.setFont(totalFont);
		totalWord.setLineSpacing(-10);
		Text totalNumber = new Text(String.format("$%.2f", this.rv.getReceipt().getTotal()));
		totalNumber.setFont(priceFont);
		totalNumber.setLineSpacing(-25);
		totalNumber.setFill(Color.rgb(168,207,68));
		
		totalContainer.setBorder(new Border(new BorderStroke(Color.rgb(89, 89, 89), BorderStrokeStyle.SOLID, new CornerRadii(20), new BorderWidths(8))));
		totalContainer.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), new CornerRadii(30), Insets.EMPTY)));
		//totalContainer.setPadding(new Insets(50, 0, 50, 0));
		totalContainer.getChildren().addAll(totalWord, totalNumber);
		
		container.getChildren().add(totalContainer);
		totalContainer.setPrefHeight(100);
		totalContainer.setPrefWidth(240);
		totalContainer.setMaxHeight(100);
		totalContainer.setMaxWidth(240);
		//container.setPadding(new Insets(0, 75, 0, 75));
		layout.getChildren().add(container);
		layout.setLeftAnchor(container, 0.0);
		layout.setRightAnchor(container, 0.0);
		layout.setBottomAnchor(container, 320.0);
		
		HBox cartContainer = new HBox();		
		this.cartImg = new ImageView(new Image("file:"+new File("resources/core/backCart.png").getAbsolutePath()));
		this.cartImg.setPreserveRatio(true);
		this.cartImg.setFitHeight(150);
		cartContainer.setAlignment(Pos.CENTER);
		cartContainer.setPadding(new Insets(20, 0, 0, 0));
		cartContainer.getChildren().add(this.cartImg);
		layout.getChildren().add(cartContainer);
		layout.setLeftAnchor(cartContainer, 0.0);
		layout.setRightAnchor(cartContainer, 0.0);
		layout.setBottomAnchor(cartContainer, 190.0);
		
		this.registerView.addPopup(layout);
		
		this.amc.disable();
//		this.amc.cancel();
		
		Timer tm = new Timer();
		tm.schedule(new TimeExpiring(new HaveANiceDayController(this.registerView, tm, rv, ipv, amc)), 10000);
		
		this.cartImg.setOnMousePressed(new ReturnToRegisterController(this.registerView, tm, this.amc));
		layout.setOnMousePressed(new HaveANiceDayController(this.registerView, tm, rv, ipv, amc));
	}

}
