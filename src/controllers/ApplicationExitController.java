package controllers;

import java.util.ArrayList;
import java.util.Timer;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ApplicationExitController implements EventHandler<MouseEvent> {
	private Stage s1;

	private ArrayList<Rectangle> boxes;
	private int i;
	private Timer timer;
	private RestartExitSequence res;
	
	public ApplicationExitController(Stage _s1, ArrayList<Rectangle> _boxes) {
		this.s1 = _s1;
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
					Platform.exit();
					this.s1.fireEvent(new WindowEvent(this.s1, WindowEvent.WINDOW_CLOSE_REQUEST));
				}
				this.res.cancel();
				this.res = new RestartExitSequence(this);
				this.timer.schedule(this.res, 5000);
			}
		}
	}
	
	public void resetCounter() {
		this.i = 0;
	}

}
