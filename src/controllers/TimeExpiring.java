package controllers;

import java.util.TimerTask;

import javafx.application.Platform;

public class TimeExpiring extends TimerTask {
	
	private Cancelable tt;

	public TimeExpiring (Cancelable _tt) {
		this.tt = _tt;
	}
	
	@Override
	public void run() {
		Platform.runLater(this.tt);	
	}
	
	@Override
	public boolean cancel() {
		tt.cancel();
		//System.out.println("Canceled tea");
		return true;
	}

}
