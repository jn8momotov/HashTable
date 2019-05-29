package ru.momotov;

public class ArrayList {

    private HashPair[] array;

    ArrayList(String key, String value) {
        array = new HashPair[1];
        array[0] = new HashPair(key, value);
        System.out.println("Pair success added!");
    }

    public void addPair(String key, String value) {
        for (int index = 0; index < array.length; index++) {
            if (array[index].getKey().compareTo(key) == 0) {
                array[index].setValue(value);
                System.out.println("Value for this key was updated!");
                return;
            }
        }
        increaseSizeArray();
        array[array.length - 1] = new HashPair(key, value);
        System.out.println("Pair success added!");
    }

    public String getSearhedValue(String key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index].getKey().compareTo(key) == 0) {
                return array[index].getValue();
            }
        }
        return null;
    }

    public void removePair(String key) {
        HashPair[] newArray = new HashPair[array.length - 1];
        boolean isRemovePair = false;
        int indexNewArray = 0;
        for (int index = 0; index < array.length; index++) {
            if (array[index].getKey().compareTo(key) == 0) {
                isRemovePair = true;
                continue;
            }
            newArray[indexNewArray] = array[index];
            indexNewArray++;
        }
        if (isRemovePair) {
            System.out.println("Pair is remove!");
            array = newArray;
        }
    }

    public void printArrayList() {
        for (int index = 0; index < array.length; index++) {
            System.out.println(array[index].getKey() + ": " + array[index].getValue());
        }
    }

    public void increaseSizeArray() {
        HashPair[] newArray = new HashPair[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

}