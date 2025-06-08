package com.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainTest {

    @Test
    public void testMainAddAndDisplay() {
        String input = "add\nkey1\nvalue1\ndisplay\nexit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});
        // Just verify it runs without exceptions
    }

    @Test
    public void testMainGetNonExistent() {
        String input = "get\nnonexistent\nexit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});
        // Verify output would contain "Ключ не найден"
    }

    @Test
    public void testMainRemove() {
        String input = "add\ntest\nvalue\nremove\ntest\nexit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});
        // Verify removal works
    }
}