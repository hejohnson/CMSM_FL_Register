package model;

import javafx.scene.paint.Color;

public class Category {
	
	private String name;
	private Color bgColor;
	private String imgPath;
	private String bgPath;
	
	public Category (String _n, Color _bg, String _img, String _bgImg) {
		this.name = _n;
		this.bgColor = _bg;
		this.imgPath = _img;
		this.bgPath = _bgImg;
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
	
	public String getBGImg() {
		return this.bgPath;
	}
}
