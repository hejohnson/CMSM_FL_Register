package controllers;

import java.awt.Point;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class ImageAreaSelectorRectangleDragController implements EventHandler<MouseEvent> {

	private Rectangle r;
	private Point p;
	private Rectangle i;

	public ImageAreaSelectorRectangleDragController (Rectangle _r, Point _p, Rectangle _i) {
		this.r = _r;
		this.p = _p;
		this.i = _i;
	}

	@Override
	public void handle(MouseEvent event) {

		double size = 0;


		if (Math.abs(event.getX()) > Math.abs(event.getY())) {
			size = Math.abs(event.getX()-p.getX());
		} else {
			size = Math.abs(event.getY()-p.getY());
		}

		if (p.getX() < event.getX()) {
			r.setX(p.getX());
		} else {
			r.setX(p.getX()-size);
		}

		if (p.getY() < event.getY()) {
			r.setY(p.getY());
		} else {
			r.setY(p.getY()-size);
		}

		if ((Math.abs(r.getX()+r.getWidth()) < this.i.getWidth()) && (Math.abs(r.getY()+r.getHeight()) < this.i.getHeight())) {
			r.setWidth(size);
			r.setHeight(size);
		}

	}

}
