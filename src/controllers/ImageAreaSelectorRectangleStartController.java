package controllers;

import java.awt.Point;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class ImageAreaSelectorRectangleStartController implements EventHandler<MouseEvent> {
	
	private Rectangle r;
	private Point p;
	
	public ImageAreaSelectorRectangleStartController (Rectangle _r, Point _p) {
		this.r = _r;
		this.p = _p;
	}

	@Override
	public void handle(MouseEvent event) {
		r.setX(event.getX());
		r.setY(event.getY());
		r.setWidth(0);
		r.setHeight(0);
		p.setLocation(event.getX(), event.getY());
	
	}

}
