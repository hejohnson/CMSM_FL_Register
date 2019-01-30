package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class RegisterTabContent extends StackPane {
	private FlowPane contentArea;
	private String tabName;
	private ImageView tabBG;
	
	private Font font = Font.font("Verdana", FontWeight.BOLD, 20);
	
	public RegisterTabContent (String _tabName, int th, int tw) {
		this.contentArea = new FlowPane();
		
		this.tabName = _tabName;
		this.tabBG = new ImageView();
		
		this.contentArea.setPadding(new Insets(th+50, 300, 30, 80));
		this.contentArea.setPrefWrapLength(800);
		this.contentArea.setHgap(80);
		this.contentArea.setVgap(40);
		//this.contentArea.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		this.getChildren().addAll(this.tabBG, this.contentArea);
		
		
//		this.setBottomAnchor(this.contentArea, 0.0);
//		this.setTopAnchor(this.contentArea, (double)th);
//		this.setLeftAnchor(this.contentArea, 0.0);
//		this.setRightAnchor(this.contentArea, 0.0);
//		
//		this.setBottomAnchor(this.tabBG, 0.0);
//		this.setTopAnchor(this.tabBG, 0.0);
//		this.setLeftAnchor(this.tabBG, 0.0);
//		this.setRightAnchor(this.tabBG, 0.0);
	}
	
	public void setBGImage(Image img) {
		this.tabBG.setImage(img);
//		this.tabBG.setPreserveRatio(true);
//		this.tabBG.setFitHeight();
	}
	
	public String getTabName() {
		return this.tabName;
	}
	
	
	public String toString() {
		return this.tabName;
	}
	
	public void addContent(Node content) {
		this.contentArea.getChildren().add(content);
	}

	public FlowPane getContentArea() {
		return this.contentArea;
	}
}
