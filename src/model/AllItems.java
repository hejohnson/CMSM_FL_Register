package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;

import javafx.scene.paint.Color;

public class AllItems {
	private LinkedList<Item> allItems = new LinkedList<Item>();
	private LinkedList<Category> categories = new LinkedList<Category>();
	String itemsFile = "resources/items.csv";
	String categoriesFile = "resources/cats.csv";
	
	public AllItems () {
		loadItems();
	}
	
	public boolean loadItems() {
		
        String line = "";
        String cvsSplitBy = ",";
		
		try (BufferedReader br = new BufferedReader(new FileReader(itemsFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
            	//System.out.println(line);
                String[] fields = line.split(cvsSplitBy);
                Item newItem = new Item(fields[0], fields[1], Double.parseDouble(fields[2]), fields[3], Boolean.parseBoolean(fields[4]));
                //System.out.println(Boolean.toString(newItem.validatePath()));
                //System.out.println(newItem.toString());
                this.allItems.add(newItem);

            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
		
		try (BufferedReader br = new BufferedReader(new FileReader(categoriesFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
            	//System.out.println(line);
                String[] fields = line.split(cvsSplitBy);
                String[] rgbs = fields[1].split(";");
                Category newCat = new Category(fields[0], Color.rgb(Integer.parseInt(rgbs[0]),Integer.parseInt(rgbs[1]),Integer.parseInt(rgbs[2])), fields[2], fields[3]);
                //System.out.println(Boolean.toString(newItem.validatePath()));
                //System.out.println(newItem.toString());
                this.categories.add(newCat);

            }

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
		
		return true;
	}
	
	public LinkedList<Item> getItems() {
		return allItems;
	}
	
	public String toString() {
		String returnString = "";
		
		for (Item itm : allItems) {
			returnString = returnString.concat(itm.toString());
		}
		return returnString;
	}
	
	public boolean saveItems() {
		try (BufferedWriter br = new BufferedWriter(new FileWriter(itemsFile))) {

			for (Item itm:allItems) {
				br.write(itm.toString());
			}

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
		return true;
	}
	
	public LinkedList<Category> getCategories() {
		return this.categories;
	}

	public Item addItem() {
		Item tmp = new Item();
		this.allItems.add(tmp);
		return tmp;
	}
}
