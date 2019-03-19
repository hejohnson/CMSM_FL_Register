package model;

import javafx.scene.paint.Color;

public class Category {
	
	private String name;
	private Color bgColor;
	private String imgPath;
	private String bgPath;
	private Color borderColor;
	
	public Category (String _n, Color _bg, Color _borderColor, String _img, String _bgImg) {
		this.name = _n;
		this.bgColor = _bg;
		this.imgPath = _img;
		this.bgPath = _bgImg;
		this.borderColor = _borderColor;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Color getColor() {
		return this.bgColor;
	}

	public String getImg() {
		return "resources"+this.imgPath;
	}
	
	public String getBGImg() {
		return "resources"+this.bgPath;
	}
	
	public Color getBorderColor() {
		return this.borderColor;
	}
}
