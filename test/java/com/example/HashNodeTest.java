package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashNodeTest {

    @Test
    public void testHashNodeCreation() {
        String key = "testKey";
        String value = "testValue";
        HashNode node = new HashNode(key, value);

        assertEquals(key, node.key);
        assertEquals(value, node.value);
        assertEquals(Math.abs(key.hashCode()), node.hashValue);
    }

    @Test
    public void testComputeHash() {
        String key = "anotherKey";
        HashNode node = new HashNode(key, "someValue");

        int expectedHash = Math.abs(key.hashCode());
        assertEquals(expectedHash, node.hashValue);
    }
}