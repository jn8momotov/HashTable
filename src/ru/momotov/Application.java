package ru.momotov;

import java.util.Scanner;

public class Application {

    private HashTable hashTable;

    public void run() {
        int sizeHashTable = enterHashTableSize();
        hashTable = new HashTable(sizeHashTable);
        String num = userChoice();
        while (!num.equals("0")) {
            switch (num) {
                case "1":
                    addNewValue();
                    break;
                case "2":
                    getValue();
                    break;
                case "3":
                    removeValue();
                    break;
                case "4":
                    showAll();
                    break;
            }
            num = userChoice();
        }
    }

    private void addNewValue() {
        Scanner in = new Scanner(System.in);
        System.out.print("Key: ");
        String key = in.nextLine();
        System.out.print("Value: ");
        String value = in.nextLine();
        hashTable.put(key, value);
    }

    private void getValue() {
        Scanner in = new Scanner(System.in);
        System.out.print("Key: ");
        String key = in.nextLine();
        String value = hashTable.get(key);
        if (value == null) {
            System.out.println("Value not found!");
        } else {
            System.out.println("Value: " + value);
        }
    }

    private void removeValue() {
        Scanner in = new Scanner(System.in);
        System.out.print("Key: ");
        String key = in.nextLine();
        hashTable.remove(key);
    }

    private void showAll() {
        hashTable.print();
    }

    private String userChoice() {
        showMenu();
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    private int enterHashTableSize() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter hashtable size: ");
        int size = in.nextInt();
        return size;
    }

    private void showMenu() {
        System.out.println("-----------------");
        System.out.println("MENU:");
        System.out.println("-----------------");
        System.out.println("1. Add value");
        System.out.println("2. Get value");
        System.out.println("3. Remove value");
        System.out.println("4. Show all values");
        System.out.println("0. Exit");
        System.out.println("-----------------");
        System.out.print("YOU SELECT: ");
    }

}
