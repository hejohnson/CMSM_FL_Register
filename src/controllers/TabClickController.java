package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import views.RegisterTab;
import views.TabbedArea;

public class TabClickController implements EventHandler<MouseEvent> {
	
	private RegisterTab rt;
	private TabbedArea ta;

	public TabClickController(RegisterTab _rt, TabbedArea _ta) {
		// TODO Auto-generated constructor stub
		this.rt = _rt;
		this.ta = _ta;
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		this.rt.setSelected();
		this.ta.getSelectedTab().clearSelected();
		this.ta.setSelectedTab(rt);
		this.ta.setUnselectedBorders();
	}
	
	

}
