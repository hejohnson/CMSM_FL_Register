package controllers;

import java.util.TimerTask;

public class RestartExitSequence extends TimerTask {

	private ApplicationExitController aec;
	
	public RestartExitSequence (ApplicationExitController _aec) {
		this.aec = _aec;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.aec.resetCounter();
	}

}
