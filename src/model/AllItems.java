package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;

public class AllItems {
	private LinkedList<Item> allItems = new LinkedList<Item>();
	private HashSet<String> categories = new HashSet<String>();
	String csvFile = "items.csv";
	
	public AllItems () {
		loadItems();
	}
	
	public boolean loadItems() {
		
        String line = "";
        String cvsSplitBy = ",";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
            	//System.out.println(line);
                String[] fields = line.split(cvsSplitBy);
                Item newItem = new Item(fields[0], fields[1], Double.parseDouble(fields[2]), fields[3], Boolean.parseBoolean(fields[4]));
                //System.out.println(Boolean.toString(newItem.validatePath()));
                //System.out.println(newItem.toString());
                this.allItems.add(newItem);
                this.categories.add(newItem.getCategory());

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
	
	public LinkedList<String> getCategories() {
		LinkedList<String> ll = new LinkedList<>(this.categories);
		return ll;
	}
	
	public boolean saveItems() {
		try (BufferedWriter br = new BufferedWriter(new FileWriter(csvFile))) {

			for (Item itm:allItems) {
				br.write(itm.toString());
			}

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
		return true;
	}

	public Item addItem() {
		Item tmp = new Item();
		this.allItems.add(tmp);
		return tmp;
	}
}
