package com.example;

public class HashNode {
    String key;
    String value;
    int hashValue;

    public HashNode(String key, String value) {
        this.key = key;
        this.value = value;
        this.hashValue = computeHash(key);
    }

    private int computeHash(String key) {
        return Math.abs(key.hashCode());
    }
}