package com.javaIo;

import java.io.*;
import java.util.Scanner;

public class ApplicationJavaIo {

    static Scanner scanner;

    public static void main(String[] args) throws IOException {

//        writeOnFile();

//        readFileWithFileReader();

        readFromFileWithScanner();

    }

    private static void readFromFileWithScanner() throws FileNotFoundException {
        File file = new File("test-ch.txt");
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    private static void readFileWithFileReader() throws IOException {
        FileReader fileReader = new FileReader("test-ch.txt");

        int ch;
//        int read = fileReader.read();

        while (-1 != (ch = fileReader.read())) {
            System.out.println((char) ch);
        }
        fileReader.close();
    }

    private static void writeOnFile() throws IOException {
        File file = new File("test-ch.txt");

        System.out.println("file.length : " + file.length());

//        System.out.println(file.createNewFile());

        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write("\nvahid\n");
        fileWriter.write("aliani");
//        fileWriter.flush();
        fileWriter.close();
        System.out.println("file.length : " + file.length());

        /*System.out.println("isFile : "+file.isFile());
        System.out.println("isFile : "+file.isDirectory());
        System.out.println("isFile : "+file.isHidden());
        System.out.println("isFile : "+file.getName());
        System.out.println("isFile : "+file.getAbsolutePath());*/
    }
}
