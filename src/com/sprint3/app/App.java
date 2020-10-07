package com.sprint3.app;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        MyList itemList = new MyList();
        Scanner myScanner = new Scanner(System.in);

        try { // create file
            new File("items.csv");
        } catch (Exception e) {
            System.out.println("Error processing files. (" + e + ")");
        }

        System.out.println("1. Add item.");
        System.out.println("2. Remove item.");
        System.out.println("3. Print unsorted list.");
        System.out.println("  3a. Sorted by name ascending.");
        System.out.println("  3b. Sorted by name descending.");
        System.out.println("  3c. Sorted by price ascending.");
        System.out.println("  3d. Sorted by price descending.");
        System.out.println("0. Exit.");

        while(true) {
            itemList.reworkList(0);
            System.out.println("Enter menu number:");
            String menu = myScanner.nextLine();

            try { // menu select
                switch (menu) {
                    case "1" -> { // add item
                        System.out.println("Enter item name:");
                        String name = myScanner.nextLine();
                        System.out.println("Enter \"" + name + "\" price:");
                        if (myScanner.hasNextDouble()) {
                            Item newItem = new Item(name, myScanner.nextDouble());
                            newItem.addToFile();
                        } else {
                            System.out.println("Error! price must be numeric type.");
                        }
                        myScanner.nextLine();
                    }

                    case "2" -> { // remove item
                        itemList.printList();
                        System.out.println("Enter item number you wish to remove:");
                        if (myScanner.hasNextInt()) {
                            itemList.reworkList(myScanner.nextInt());
                            itemList.addToFile();
                        } else {
                            System.out.println("Error! price must be numeric type.");
                        }
                        myScanner.nextLine();
                    }

                    case "3" -> itemList.printList(); // print unsorted

                    case "3a" -> { // sort by name asc
                        itemList.sortByNameASC();
                        itemList.printList();
                    }

                    case "3b" -> { // sort by name desc
                        itemList.sortByNameDESC();
                        itemList.printList();
                    }

                    case "3c" -> { // sort by price asc
                        itemList.sortByPriceASC();
                        itemList.printList();
                    }

                    case "3d" -> { // sort by price desc
                        itemList.sortByPriceDESC();
                        itemList.printList();
                    }

                    case "0" -> System.exit(0); // exit
                    default -> throw new Exception("Error! Invalid selection.");
                }
            }
            catch(Exception e) { // error handling
                System.out.println(e.getMessage());
            }
        } // while
    } // main
} // App
