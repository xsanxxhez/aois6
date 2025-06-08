package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    @Test
    public void testPutAndGet() {
        HashTable table = new HashTable(10);
        table.put("key1", "value1");
        table.put("key2", "value2");

        assertEquals("value1", table.get("key1"));
        assertEquals("value2", table.get("key2"));
        assertNull(table.get("nonexistent"));
    }

    @Test
    public void testPutUpdate() {
        HashTable table = new HashTable(10);
        table.put("key", "oldValue");
        table.put("key", "newValue");

        assertEquals("newValue", table.get("key"));
    }

    @Test
    public void testRemove() {
        HashTable table = new HashTable(10);
        table.put("toRemove", "value");

        assertNotNull(table.get("toRemove"));
        table.remove("toRemove");
        assertNull(table.get("toRemove"));
    }

    @Test
    public void testHashCollision() {
        HashTable table = new HashTable(1); // Force collisions
        table.put("key1", "value1");
        table.put("key2", "value2");

        assertEquals("value1", table.get("key1"));
        assertEquals("value2", table.get("key2"));
    }

    @Test
    public void testDisplayEmptyTable() {
        HashTable table = new HashTable(10);
        table.display(); // Just verify no exceptions
    }
}