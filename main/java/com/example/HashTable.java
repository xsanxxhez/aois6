package com.example;

import java.util.LinkedList;

public class HashTable {
    private final LinkedList<HashNode>[] table;
    private final int size;
    private int entries;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
        this.entries = 0;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode() % size);
    }

    public void put(String key, String value) {
        int index = hash(key);
        for (HashNode node : table[index]) {
            if (node.key.equals(key)) {
                System.out.println("Ключ \"" + key + "\" уже существует. Обновление значения.");
                node.value = value; // Обновление существующего значения
                return;
            }
        }
        table[index].add(new HashNode(key, value)); // Добавление нового узла
        entries++;
    }

    public String get(String key) {
        int index = hash(key);
        for (HashNode node : table[index]) {
            if (node.key.equals(key)) {
                return node.value; // Возврат значения по ключу
            }
        }
        return null; // Если ключ не найден
    }

    public void remove(String key) {
        int index = hash(key);
        boolean removed = table[index].removeIf(node -> node.key.equals(key));
        if (removed) {
            entries--;
            System.out.println("Запись с ключом \"" + key + "\" удалена.");
        } else {
            System.out.println("Ключ \"" + key + "\" не найден.");
        }
    }

    public void display() {
        System.out.println("Содержимое хеш-таблицы:");
        for (int i = 0; i < size; i++) {
            if (!table[i].isEmpty()) {
                for (HashNode node : table[i]) {
                    System.out.println("Ключ: " + node.key + ", Значение: " + node.value + ", Хеш: " + node.hashValue);
                }
            }
        }
        System.out.printf("Коэффициент заполнения: %.2f%%\n", (double) entries / size * 100);
    }
}