package com.concurrent.demo.files;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

public class PathWatcher {
    static final Path test = Paths.get("test");
    public static void delTxtFiles() {
        try {
            Files.walk(test)
                    .filter(f -> f.toString().endsWith(".txt"))
                    .forEach(f -> {
                        try {
                            System.out.println("delete: " + f);
                            Files.delete(f);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Files.createFile(test.resolve("test.txt"));
        WatchService watchService = FileSystems.getDefault().newWatchService();
        test.register(watchService, ENTRY_DELETE);
        Executors.newSingleThreadScheduledExecutor()
                .schedule(
                        PathWatcher::delTxtFiles,250, TimeUnit.MILLISECONDS
                );
        WatchKey key = watchService.take();
        for(WatchEvent<?> event : key.pollEvents()) {
            System.out.println("event.context: " + event.context() + "event.count: " + event.count() + " event.kind " + event.kind());
        }
    }
}
