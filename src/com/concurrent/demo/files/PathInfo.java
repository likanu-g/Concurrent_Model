package com.concurrent.demo.files;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.awt.SystemColor.info;

public class PathInfo {
    public static void show(String id, Object path) {
        System.out.println(id + " -> " + path);
    }
    static void info(Path p) {
        show("toString:\n ", p);
        show("Exists: " , Files.exists(p));
        show("RegularFile:", Files.isRegularFile(p));
        show("IsDirectory: " , Files.isDirectory(p));
        show("AbsolutePath: " , p.isAbsolute());
        show("FilesName: " , p.getFileName());
        show("Parent: " , p.getParent());
        show("Root: " , p.getRoot());
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        info(Paths.get("home","likanug", "Documents", "test.txt"));
        Path path = Paths.get("PathInfo.java");
        info(path);
        Path ap = path.toAbsolutePath();
        info(ap);
        info(ap.getParent());
        try {
            info(path.toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        URI u = path.toUri();
        System.out.println("Uri: \n" + u);
        Path puri = Paths.get(u);
        System.out.println(Files.exists(puri));
        File f = ap.toFile();
    }
}
