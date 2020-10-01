package com.sprint3.app;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

class myList extends ArrayList<Item> {
    List<Item> itemList = new ArrayList<>();

    public void reworkList(int delItem) {
        itemList.clear();
        try {
            File myFile = new File("items.csv");
            Scanner myReader = new Scanner(myFile);

            int counter = 1;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(delItem != counter) {
                    itemList.add(new Item(data));
                }
                counter++;
            }
            myReader.close();

        } catch (Exception e) {
            System.out.println("Error processing files. (" + e + ")");
        }
    }
    public void printList() {
        for(int i = 0; i < itemList.size(); i++) {
            System.out.println((i+1) + ". " + itemList.get(i));
        }
    }
    public void addToFile() {
        try {
            FileWriter myWriter = new FileWriter("items.csv", false);
            for (Item item : itemList) {
                myWriter.write(item + "\n");
            }
            myWriter.close();
            System.out.println("Item removed successfully!");
        } catch (Exception e) {
            System.out.println("Error processing files. (" + e + ")");
        }
    }
    public void sortByNameASC() {
        itemList.sort(Comparator.comparing(a -> a.name));
    }
    public void sortByNameDESC() {
        itemList.sort(Comparator.comparing(a -> a.name));
        Collections.reverse(itemList);
    }
    public void sortByPriceASC() {
        itemList.sort(Comparator.comparing(a -> a.price));
    }
    public void sortByPriceDESC() {
        itemList.sort(Comparator.comparing(a -> a.price));
        Collections.reverse(itemList);
    }
}