package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class CrosshairsController implements EventHandler<MouseEvent> {

	private Line hl;
	private Line vl;
	private Rectangle r;
	
	public CrosshairsController (Line _hl, Line _vl, Rectangle _r) {
		this.hl = _hl;
		this.vl = _vl;
		this.r = _r;
	}
	
	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.hl.setStartX(arg0.getX());
		this.hl.setStartY(arg0.getY());
		this.hl.setEndX(r.getWidth());
		this.hl.setEndY(arg0.getY());
		
//		System.out.println(r);
		
		this.vl.setStartX(arg0.getX());
		this.vl.setStartY(arg0.getY());
		this.vl.setEndX(arg0.getX());
		this.vl.setEndY(r.getHeight());
	}

}
