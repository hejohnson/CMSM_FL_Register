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

public class RegisterTab extends VBox {
	private Text tabName;
	private ImageView tabGraphic;
	private int tabHeight;
	private int tabWidth;
	private Color tabColor;
	private RegisterTabContent rtc;
	private int textPadding = 5;
	private VBox tabNameContainer;
	
	private Font font = Font.font("Verdana", FontWeight.BOLD, 20);
	
	public RegisterTab (int th, int tw, RegisterTabContent _rtc) {
		
		this.tabHeight = th;
		this.tabWidth = tw;
		this.rtc = _rtc;
		
		this.tabName = new Text();
		this.tabName.setFont(font);
		this.tabName.setFill(Color.WHITE);
		
		this.tabNameContainer = new VBox();
		this.tabNameContainer.setPadding(new Insets(textPadding, 0, textPadding, 0));
		this.tabNameContainer.getChildren().add(this.tabName);
		this.tabNameContainer.setAlignment(Pos.CENTER);
		
		this.tabGraphic = new ImageView();
		
		this.getChildren().addAll(this.tabGraphic, this.tabNameContainer);
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(tabWidth);
		this.setMaxHeight(tabHeight);
		this.setPrefHeight(tabHeight);
		
		//this.contentArea.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}
	
	public void setTabImage(Image img) {
		this.tabGraphic.setImage(img);
		this.tabGraphic.setPreserveRatio(true);
		this.tabGraphic.setFitHeight(this.tabHeight-font.getSize()-2*textPadding);
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
	
	public void setSelected() {
		//this.tabName.setVisible(true);
		this.getChildren().add(this.tabNameContainer);
		this.setMaxHeight(tabHeight);
		this.setPrefHeight(tabHeight);
		this.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0, 0, 15, 15, false), new BorderWidths(0, 5, 5, 5))));
		this.rtc.toFront();
	}
	
	public void clearSelected() {
		//this.tabName.setVisible(false);
		this.getChildren().remove(this.tabNameContainer);
		this.setMaxHeight(tabHeight-font.getSize()-8);
		this.setPrefHeight(tabHeight-font.getSize()-8);
		this.setBorder(new Border(new BorderStroke(this.tabColor.brighter(), BorderStrokeStyle.SOLID, new CornerRadii(0, 0, 15, 15, false), new BorderWidths(0, 2, 2, 2))));
	}

	public void setTabAreaBG(Color color) {
		this.tabColor = color;
		//this.setBorder(new Border(new BorderStroke(color.brighter(), BorderStrokeStyle.SOLID, new CornerRadii(0, 0, 15, 15, false), new BorderWidths(5))));
		this.setBackground(new Background(new BackgroundFill(color, new CornerRadii(0, 0, 20, 20, false), Insets.EMPTY)));
	}
}
