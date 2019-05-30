package ru.momotov;

public class ArrayList {

    private HashPair[] array;
    public int pointer = 0;

    ArrayList(String key, String value) {
        array = new HashPair[10];
        array[0] = new HashPair(key, value);
        pointer++;
        System.out.println("Pair success added!");
    }

    public void addPair(String key, String value) {
        for (int index = 0; index < pointer; index++) {
            if (array[index].getKey().equals(key)) {
                array[index].setValue(value);
                System.out.println("Value for this key was updated!");
                return;
            }
        }
        if (pointer == array.length) {
            increaseSizeArray();
        }
        array[pointer] = new HashPair(key, value);
        pointer++;
        System.out.println("Pair success added!");
    }

    public String getSearhedValue(String key) {
        for (int index = 0; index < pointer; index++) {
            if (array[index].getKey().equals(key)) {
                return array[index].getValue();
            }
        }
        return null;
    }

    public void removePair(String key) {
        for (int index = 0; index < pointer; index++) {
            if (array[index].getKey().equals(key)) {
                System.arraycopy(array, index + 1, array, index, pointer - (index + 1));
                pointer--;
                array[pointer] = null;
                System.out.println("Pair is remove!");
            }
        }
    }

    public void printArrayList() {
        for (int index = 0; index < pointer; index++) {
            System.out.println(array[index].getKey() + ": " + array[index].getValue());
        }
    }

    public void increaseSizeArray() {
        HashPair[] newArray = new HashPair[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

}