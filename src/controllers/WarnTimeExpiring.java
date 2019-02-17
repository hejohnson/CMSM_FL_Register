package controllers;

import java.util.Timer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import views.FullscreenPopup;
import views.RegisterView;
import views.TimeExpiringAlert;

public class WarnTimeExpiring implements Runnable, Cancelable {
	
	private RegisterView rs;
	private Stage ws;
	private ActivityMonitorController amc;
	private Alert alert;
	private Timer countdown;
	private FullscreenPopup fps;

	public WarnTimeExpiring (RegisterView _rs, Stage _ws, ActivityMonitorController _amc) {
		this.rs = _rs;
		this.ws = _ws;
		this.amc = _amc;
		//this.ds = new Stage();
		this.countdown = new Timer();
		this.fps = new FullscreenPopup();
		
	}
	
	@Override
	public void run() {
		//if (this.rs.isAlwaysOnTop()) {
		
			BorderPane layout = new BorderPane();
			
			//Scene dialogScene = new Scene(layout);
			
			this.fps = new FullscreenPopup(layout);
			
//			this.ds.setScene(dialogScene);
//			this.ds.initStyle(StageStyle.TRANSPARENT);
//			this.ds.initModality(Modality.NONE);
//			this.ds.setMaximized(true);
//			this.ds.show();
//			this.ds.setAlwaysOnTop(true);
//			this.rs.setAlwaysOnTop(false);
			
//			this.fps.display(this.rs);
			
//			AnchorPane registerLayout = (AnchorPane) (this.rs.getScene().getRoot());
//			registerLayout.getChildren().add(layout);
//			registerLayout.setBottomAnchor(layout, 0.0);
//			registerLayout.setTopAnchor(layout, 0.0);
//			registerLayout.setLeftAnchor(layout, 0.0);
//			registerLayout.setRightAnchor(layout, 0.0);
			
			this.rs.addPopup(layout);
			
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
			
			countdown.scheduleAtFixedRate(new TimeTick(timeLeft, this.rs, this.ws, this.amc.getReceiptView(), this.amc.getIPV(), this.amc), 1000, 1000);
			
			//countdown.cancel();
		//}
		
//		tea = new TimeExpiringAlert(this.amc);
//		//tea.getDialogPane().setOnMouseMoved(amc);
//		//tea.getDialogPane().setContent(new Text("Time is expiring. Tap anywhere to continue"));
//		tea.show();
	}
	
	public void cancel() {
		AnchorPane registerLayout = (AnchorPane) (this.rs.getScene().getRoot());
		System.out.println(registerLayout.getChildren().size());
		if (registerLayout.getChildren().size() >= 3) {
			registerLayout.getChildren().remove(registerLayout.getChildren().size()-1);
		}
//		
//		this.rs.setAlwaysOnTop(true);
		countdown.cancel();
		//System.out.println("Closed tea");
	}

}
