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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class RegisterTab extends AnchorPane {
	private HBox tabSpacer;
	private VBox tabInfo;
	private FlowPane contentArea;
	private Text tabName;
	private ImageView tabGraphic;
	private int tabHeight;
	private int tabWidth;
	private Color tabColor;
	
	private Font font = Font.font("Verdana", FontWeight.BOLD, 20);
	
	public RegisterTab (int tabNumber, int th, int tw) {
		this.tabSpacer = new HBox();
		this.contentArea = new FlowPane();
		
		this.tabHeight = th;
		this.tabWidth = tw;
		
		this.tabInfo = new VBox();
		this.tabName = new Text();
		this.tabName.setFont(font);
		this.tabName.setFill(Color.WHITE);
		this.tabGraphic = new ImageView();
		
		this.tabInfo.getChildren().addAll(this.tabGraphic, this.tabName);
		this.tabInfo.setAlignment(Pos.CENTER);
		this.tabInfo.setPrefWidth(tabWidth);
		
		this.tabSpacer.setPrefHeight(tabHeight);
		this.tabSpacer.setPrefWidth(tabWidth*tabNumber);
		
		
		this.contentArea.setPadding(new Insets(this.font.getSize()+20, 300, 30, 80));
		this.contentArea.setPrefWrapLength(800);
		this.contentArea.setHgap(80);
		this.contentArea.setVgap(40);
		//this.contentArea.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		this.getChildren().addAll(this.contentArea, this.tabInfo);
		
		
		this.setBottomAnchor(this.contentArea, 0.0);
		this.setTopAnchor(this.contentArea, (double)tabHeight+5);
		this.setLeftAnchor(this.contentArea, 0.0);
		this.setRightAnchor(this.contentArea, 0.0);
		this.setLeftAnchor(this.tabInfo, (double)(tabWidth+10)*tabNumber+30);
		this.setTopAnchor(this.tabInfo, 0.0);
	}
	
	public void setTabImage(Image img) {
		this.tabGraphic.setImage(img);
		this.tabGraphic.setPreserveRatio(true);
		this.tabGraphic.setFitHeight(this.tabHeight);
	}
	
	public void setTabName(String name) {
		this.tabName.setText(name);
	}
	
	public String getTabName() {
		return this.tabName.getText();
	}
	
	public String toString() {
		return this.tabName.getText();
	}
	
	public void addContent(Node content) {
		this.contentArea.getChildren().add(content);
	}
	
	public void setContentAreaBG(Color color) {
		this.contentArea.setBackground(new Background(new BackgroundFill(color, new CornerRadii(20), Insets.EMPTY)));
		this.contentArea.setBorder(new Border(new BorderStroke(this.tabColor.brighter(), BorderStrokeStyle.SOLID, new CornerRadii(15), new BorderWidths(5))));
	}

	public void setTabAreaBG(Color color) {
		this.tabColor = color;
		this.tabInfo.setBorder(new Border(new BorderStroke(color.brighter(), BorderStrokeStyle.SOLID, new CornerRadii(15), new BorderWidths(5))));
		this.tabInfo.setBackground(new Background(new BackgroundFill(color, new CornerRadii(20), Insets.EMPTY)));
	}

	public FlowPane getContentArea() {
		return this.contentArea;
	}
}
