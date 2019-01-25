package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import views.TabbedArea;

public class TabClickController implements EventHandler<MouseEvent> {
	
	private TabbedArea ta;
	private int tabW;
	private int tabH;

	public TabClickController(TabbedArea _ta, int _tabW, int _tabH) {
		// TODO Auto-generated constructor stub
		this.ta = _ta;
		this.tabW = _tabW;
		this.tabH = _tabH;
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		int idx = (int)((event.getX()-30)/(tabW+30));
		if (idx < this.ta.getTabs().size()) {
			this.ta.get(idx).toFront();
		}
	}
	
	

}
