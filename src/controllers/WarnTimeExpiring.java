package controllers;

import java.util.Timer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.text.Text;
import views.RegisterView;

public class WarnTimeExpiring implements Runnable, Cancelable {
	
	private RegisterView registerView;
	private ActivityMonitorController amc;
	private Timer countdown;

	public WarnTimeExpiring (RegisterView _registerView, ActivityMonitorController _amc) {
		this.registerView = _registerView;
		this.amc = _amc;
		//this.ds = new Stage();
		this.countdown = new Timer();
		
	}
	
	@Override
	public void run() {
		
		BorderPane layout = new BorderPane();
			
		this.registerView.addPopup(layout);
		
		VBox container = new VBox();
		container.setAlignment(Pos.CENTER);
		layout.setCenter(container);
		layout.setPadding(new Insets(350, 450, 350, 450));
		//dialogScene.setFill(Color.TRANSPARENT);
		layout.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255, 0.5), CornerRadii.EMPTY, Insets.EMPTY)));
		container.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(5))));
		container.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), new CornerRadii(15), Insets.EMPTY)));
		
		layout.addEventFilter(MouseEvent.MOUSE_PRESSED, amc);
		
		Text timeLeft = new Text();
		
		int time = 10;
		
		timeLeft.setText("Time Remaining: ".concat(Integer.toString(time)));

		container.getChildren().add(timeLeft);
		
		countdown.scheduleAtFixedRate(new TimeTick(timeLeft, this.registerView, this.amc.getReceiptView(), this.amc.getIPV(), this.amc), 1000, 1000);

	}
	
	public void cancel() {
		this.registerView.removePopup();

		countdown.cancel();
	}

}
