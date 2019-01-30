package views;

import java.util.ArrayList;

import controllers.TabClickController;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class TabbedArea extends AnchorPane {
	//private ArrayList<RegisterTab> tabs;
	int w;
	int h;
	
	private HBox tabs;
	private StackPane tabContents;
	private RegisterTab selectedTab;
	private RegisterTab firstTab;
	

	public TabbedArea(int tw, int th) {
		this.tabs = new HBox();
		this.w = tw;
		this.h = th;
		this.tabs = new HBox();
		this.tabContents = new StackPane();
		this.getChildren().addAll(tabContents, tabs);
		
		this.setTopAnchor(this.tabs, 0.0);
		this.setLeftAnchor(this.tabs, 0.0);
		//this.setRightAnchor(this.tabs, 0.0);
		
		this.setBottomAnchor(this.tabContents, 0.0);
		this.setTopAnchor(this.tabContents, 0.0);
		this.setLeftAnchor(this.tabContents, 0.0);
		this.setRightAnchor(this.tabContents, 0.0);
		
	}
	
	public void addTab(String name, String tabImgPath, String bgImgPath, Color color) {
		RegisterTabContent rtc = new RegisterTabContent(name, this.h, this.w);
		RegisterTab rt = new RegisterTab(this.h, this.w, rtc);
		
		rt.setTabImage(new Image(getClass().getResourceAsStream(tabImgPath)));
		rtc.setBGImage(new Image(getClass().getResourceAsStream(bgImgPath)));
		rt.setTabAreaBG(color);
		rt.setTabName(name);
		rt.setOnMouseClicked(new TabClickController(rt, this));
		this.tabs.getChildren().add(rt);
		this.tabContents.getChildren().add(rtc);
		
		rt.clearSelected();
		
		if (this.selectedTab == null) {
			this.selectedTab = rt;
			this.firstTab = rt;
		}
	}
	
	public void addContent(String name, PurchasableItemView piv) {
		for (Object n:this.tabContents.getChildren().toArray()) {
			RegisterTabContent rtc = (RegisterTabContent)n;
			if (rtc.getTabName().equals(name)) {
				((RegisterTabContent)n).getContentArea().getChildren().add(piv);
			}
		}
	}
	
	public RegisterTab getFirstTab() {
		return this.firstTab;
	}
	
	public RegisterTab getSelectedTab() {
		return this.selectedTab;
	}
	
	public void setSelectedTab(RegisterTab rt) {
		this.selectedTab = rt;
	}
}
