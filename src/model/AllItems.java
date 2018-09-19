package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class AllItems {
	private LinkedList<Item> allItems = new LinkedList<Item>();
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
                Item newItem = new Item(fields[0], Double.parseDouble(fields[1]), fields[2], Boolean.parseBoolean(fields[3]));
                //System.out.println(Boolean.toString(newItem.validatePath()));
                //System.out.println(newItem.toString());
                this.allItems.add(newItem);

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
