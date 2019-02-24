package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
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
	private int textPadding = 1;
	private VBox tabNameContainer;
	private VBox graphicContainer;
	private Color tabBorderColor;
	
	private Font font = Font.font("Fredoka One", FontWeight.BOLD, 26);
	
	public RegisterTab (int th, int tw, RegisterTabContent _rtc) {
		
		this.tabHeight = th;
		this.tabWidth = tw;
		this.rtc = _rtc;
		
		this.tabName = new Text();
		this.tabName.setFont(font);
		this.tabName.setFill(Color.WHITE);
		
		this.setPadding(new Insets(8, 3, 5, 3));
		
		this.tabNameContainer = new VBox();
		this.tabNameContainer.setPadding(new Insets(textPadding, 15, textPadding, 15));
		this.tabNameContainer.getChildren().add(this.tabName);
		this.tabNameContainer.setAlignment(Pos.CENTER);
		
		this.graphicContainer = new VBox();
		this.tabGraphic = new ImageView();
		this.graphicContainer.getChildren().add(tabGraphic);
		this.graphicContainer.setAlignment(Pos.CENTER);
		
		this.getChildren().addAll(this.graphicContainer, this.tabNameContainer);
//		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(tabWidth);
		this.setMaxWidth(tabWidth);
		this.setMaxHeight(tabHeight);
		this.setPrefHeight(tabHeight);
//		
		//this.contentArea.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}
	
	public void setTabImage(Image img) {
		this.tabGraphic.setImage(img);
		this.tabGraphic.setPreserveRatio(true);
		this.tabGraphic.setFitHeight(this.tabHeight-10);
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
		this.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(0, 0, 20, 20, false), new BorderWidths(0, 6, 6, 6))));
		this.setBackground(new Background(new BackgroundFill(this.tabColor, new CornerRadii(0, 0, 25, 25, false), Insets.EMPTY)));
		this.rtc.toFront();
		this.tabGraphic.setFitHeight(60);
		this.setPrefWidth(tabWidth*1.5);
		this.setMaxWidth(tabWidth*1.5);
	}
	
	public void clearSelected() {
		//this.tabName.setVisible(false);
		this.getChildren().remove(this.tabNameContainer);
		this.setBackground(new Background(new BackgroundFill(this.tabColor, new CornerRadii(0, 0, 20, 20, false), Insets.EMPTY)));
		this.tabGraphic.setFitHeight(this.tabHeight-10);
		this.setPrefWidth(tabWidth);
		this.setMaxWidth(tabWidth);
	}
	
	public void setTabBorderColor(Color c) {
		this.tabBorderColor = c;
	};
	
	public Color getTabBorderColor() {
		return this.tabBorderColor;
	}
	
	public void setTabBorder(Color color) {
		this.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, new CornerRadii(0, 0, 15, 15, false), new BorderWidths(0, 4, 4, 4))));
	}

	public void setTabAreaBG(Color color) {
		this.tabColor = color;
		//this.setBorder(new Border(new BorderStroke(color.brighter(), BorderStrokeStyle.SOLID, new CornerRadii(0, 0, 15, 15, false), new BorderWidths(5))));
		this.setBackground(new Background(new BackgroundFill(color, new CornerRadii(0, 0, 20, 20, false), Insets.EMPTY)));
	}
}
