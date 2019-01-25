package model;

import javafx.scene.paint.Color;

public class Category {
	
	private String name;
	private Color bgColor;
	private String imgPath;
	
	public Category (String _n, Color _bg, String _img) {
		this.name = _n;
		this.bgColor = _bg;
		this.imgPath = _img;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Color getColor() {
		return this.bgColor;
	}

	public String getImg() {
		return this.imgPath;
	}
}
