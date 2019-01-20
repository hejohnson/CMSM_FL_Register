package views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TimeExpiringAlert extends Stage {

	public TimeExpiringAlert (EventHandler<MouseEvent> _amc) {
//		super(AlertType.CONFIRMATION);
//		this.setTitle("");
//		this.setHeaderText("");
//		this.initOwner(stage);
//		this.setGraphic(null);
		super();
		BorderPane borderPane = new BorderPane();
		
		Scene scene = new Scene(borderPane, 600, 600);
		this.initStyle(StageStyle.UNDECORATED);
		this.setScene(scene);
		borderPane.getChildren().add(new Text("Time is expriring"));
		borderPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		borderPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setTitle("Cool Window");
		borderPane.setOnMouseMoved(_amc);
		
	}
	
}
