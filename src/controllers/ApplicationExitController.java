package controllers;

import java.util.ArrayList;
import java.util.Timer;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ApplicationExitController implements EventHandler<MouseEvent> {
	private Stage s1;
	private Stage s2;
	private ArrayList<Rectangle> boxes;
	private int i;
	private Timer timer;
	private RestartExitSequence res;
	
	public ApplicationExitController(Stage _s1, Stage _s2, ArrayList<Rectangle> _boxes) {
		this.s1 = _s1;
		this.s2 = _s2;
		this.boxes = _boxes;
		this.i = 0;
		this.timer = new Timer();
		this.res = new RestartExitSequence(this);
	}
	
	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Mouse Event");
		if ((arg0.getScreenX() < (this.boxes.get(i).getX()+this.boxes.get(i).getWidth())) && (arg0.getScreenX() > this.boxes.get(i).getX())){
			if ((arg0.getScreenY() < (this.boxes.get(i).getY()+this.boxes.get(i).getHeight())) && (arg0.getScreenY() > this.boxes.get(i).getY())){
				this.i++;
				if (this.boxes.size()==i) {
					this.s1.close();
					this.s2.close();
				}
				this.res.cancel();
				this.res = new RestartExitSequence(this);
				this.timer.schedule(this.res, 2000);
			}
		}
	}
	
	public void resetCounter() {
		this.i = 0;
	}

}
