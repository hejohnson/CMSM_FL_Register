package views;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class TabbedArea extends StackPane {
	private ArrayList<RegisterTab> tabs;
	int w;
	int h;

	public TabbedArea(int tw, int th) {
		super();
		this.tabs = new ArrayList<RegisterTab>();
		this.w = tw;
		this.h = th;
	}
	
	public RegisterTab add(String string, String imgPath, Color color) {
		RegisterTab rt = new RegisterTab(this.tabs.size(), this.h, this.w);
		rt.setTabImage(new Image(getClass().getResourceAsStream(imgPath)));
		rt.setTabAreaBG(color);
		rt.setContentAreaBG(color);
		rt.setTabName(string);
		this.getChildren().add(rt);
		this.tabs.add(rt);
		return rt;
	}
	
	public RegisterTab get(int idx) {
		return this.tabs.get(idx);
	}
	
	public ArrayList<RegisterTab> getTabs() {
		return this.tabs;
	}
}
