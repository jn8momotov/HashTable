package ru.momotov;

public class HashPair {

    private String key;
    private String value;

    HashPair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getKey() { return key; }

    public void setValue(String value) {
        this.value = value;
    }

}
