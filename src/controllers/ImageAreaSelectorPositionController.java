package controllers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class ImageAreaSelectorPositionController implements EventHandler<MouseEvent> {
	
	private Pane pane;
	private Rectangle r;
	
	public ImageAreaSelectorPositionController (Pane _pane, Rectangle _r) {
		this.pane = _pane;
		this.r = _r;
	}

	@Override
	public void handle(MouseEvent event) {
		r.setX(event.getX()-r.getWidth()/2);
		r.setY(event.getY()-r.getHeight()/2);
	
	}

}
