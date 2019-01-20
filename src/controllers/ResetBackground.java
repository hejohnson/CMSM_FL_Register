package controllers;

import java.util.TimerTask;

import views.ReceiptView;

public class ResetBackground extends TimerTask {
	private ReceiptView rv;

	public ResetBackground (ReceiptView _rv) {
		this.rv = _rv;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		this.rv.clearTotalBG();
		this.rv.clearActiveBG();
	}

}
