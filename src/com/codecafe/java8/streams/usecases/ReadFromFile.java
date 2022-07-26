package com.codecafe.java8.streams.usecases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Read a file and count the occurrence of a word in it
public class ReadFromFile {

  public static void main(String[] args) throws IOException {
    String path = "src/com/codecafe/java8/streams/usecases/hosts";
    String searchWord = "localhost";
    long count = 0;

    try (Stream<String> lines = Files.lines(Paths.get(path))) {
      count = lines.filter(line -> line.contains(searchWord))
                   .count();
    }

    System.out.printf("occurrence of word [%s] = %d", searchWord, count);
  }

}