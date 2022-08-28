package com.concurrent.demo.files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Writing {
    static Random random = new Random(47);
    static final int size = 1_000;
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[size];
        random.nextBytes(bytes);
        Files.write(Paths.get("bytes.dat"), bytes);
        System.out.println("bytes.dat: " + Files.size(Paths.get("bytes.dat")));
        List<String> lines = Files.readAllLines(Paths.get("bytes.dat"));
        Files.write(Paths.get("Cheese.txt"), lines);
        System.out.println("Cheese.txt: " + Files.size(Paths.get("Cheese.txt")));
    }
}
