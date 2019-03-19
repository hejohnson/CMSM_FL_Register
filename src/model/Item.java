/**
 * 
 */
package model;

import java.io.File;

/**
 * @author hejoh
 *
 */
public class Item {
	private boolean purchasable;
	private double price;
	private String imagePath;
	private String buttonImgPath;
	private String name;
	private String category;
	
	public Item(String _name, String _category, double _price, String _imagePath, String _buttonImgPath, boolean _purchasable) {
		this.name = _name;
		this.price = _price;
		this.imagePath = _imagePath;
		this.buttonImgPath = _buttonImgPath;
		this.purchasable = _purchasable;
		this.category = _category;
	}

	public Item() {
		this.name = "";
		this.price = 0.0;
		this.imagePath = "./resources/core/noimage.png";
		this.buttonImgPath = "./resources/core/noimage.png";
		this.purchasable = true;
	}

	public boolean isPurchasable() {
		return purchasable;
	}

	public void setPurchasable(boolean purchasable) {
		this.purchasable = purchasable;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean validatePath() {
		File f = new File (imagePath);
		return f.exists();
	}
	
	public String getButtonImgPath() {
		return buttonImgPath;
	}

	public String getImagePath() {
		return imagePath;
	}
	
	public void setButtonImgPath(String imgPath) {
		this.buttonImgPath = imgPath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public void setCategory(String _cat) {
		this.category = _cat;
	}
	
	public String toString() {
		String returnString = this.name;
		returnString = returnString.concat(",");
		returnString = returnString.concat(this.category);
		returnString = returnString.concat(",");
		returnString = returnString.concat(Double.toString(this.price));
		returnString = returnString.concat(",");
		returnString = returnString.concat(this.imagePath);
		returnString = returnString.concat(",");
		returnString = returnString.concat(this.buttonImgPath);
		returnString = returnString.concat(",");
		returnString = returnString.concat(Boolean.toString(this.purchasable));
		returnString = returnString.concat("\n");
		return returnString;
	}
	
}
