package com.sprint3.app;

import java.io.FileWriter;
import java.text.DecimalFormat;

class Item {
    String name;
    String price;

    DecimalFormat df = new DecimalFormat("######0.00");

    public Item(String data) {
        String[] arrOfStr = data.split(" ");
        this.name = arrOfStr[0];
        this.price = arrOfStr[1];
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = df.format(price);
    }

    public void addToFile() {
        try {
            FileWriter myWriter = new FileWriter("items.csv", true);
            myWriter.write(name + " " + price + "\n");
            myWriter.close();
            System.out.println("Item was added to the list successfully!");
        } catch (Exception e) {
            System.out.println("Error processing files. (" + e + ")");
        }
    }

    @Override
    public String toString() {
        return name + " " + price + " EUR";
    }
}
