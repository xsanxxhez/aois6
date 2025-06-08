package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Введите команду (add, get, remove, display, exit): ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "add":
                    System.out.print("Введите ключ: ");
                    String keyToAdd = scanner.nextLine();
                    System.out.print("Введите значение: ");
                    String valueToAdd = scanner.nextLine();
                    hashTable.put(keyToAdd, valueToAdd);
                    break;

                case "get":
                    System.out.print("Введите ключ: ");
                    String keyToGet = scanner.nextLine();
                    String value = hashTable.get(keyToGet);
                    if (value != null) {
                        System.out.println("Значение: " + value);
                    } else {
                        System.out.println("Ключ не найден.");
                    }
                    break;

                case "remove":
                    System.out.print("Введите ключ: ");
                    String keyToRemove = scanner.nextLine();
                    hashTable.remove(keyToRemove);
                    break;

                case "display":
                    hashTable.display();
                    break;

                case "exit":
                    System.out.println("Выход...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неизвестная команда.");
                    break;
            }
        }
    }
}