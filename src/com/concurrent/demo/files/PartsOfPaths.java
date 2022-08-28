package com.concurrent.demo.files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("PartsOfPaths.java").toAbsolutePath();
        System.out.println(p.toString());
        for (int i = 0; i < p.getNameCount(); i++) {
            System.out.println(p.getName(i));
            System.out.println("endsWith .java: " + p.endsWith("java"));
        }

    }
}
