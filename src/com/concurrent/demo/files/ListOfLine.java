package com.concurrent.demo.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListOfLine {
    public static void main(String[] args) throws IOException {
        Files.readAllLines(Paths.get("src/com/concurrent/demo/stream/Cheese.dat"))
                .stream()
                .filter(line -> !line.startsWith("//"))
                .map(line -> line.substring(0, line.length()/2))
                .forEach(System.out::println);
    }
}
