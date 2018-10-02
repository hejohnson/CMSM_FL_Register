package controllers;

import java.util.TimerTask;

import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import views.PurchasableItemView;

public class ResetBackground extends TimerTask {
	private PurchasableItemView piv;
	private BorderPane bp;

	public ResetBackground (PurchasableItemView _piv, BorderPane _bp) {
		this.piv = _piv;
		this.bp = _bp;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		this.bp.setBackground(Background.EMPTY);
		this.piv.setBackground(Background.EMPTY);
	}

}
