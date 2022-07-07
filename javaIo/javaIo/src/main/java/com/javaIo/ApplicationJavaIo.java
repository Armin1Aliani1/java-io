package com.javaIo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationJavaIo {

    static Scanner scanner;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        writeOnFile();

//        readFileWithFileReader();

//        readFromFileWithScanner();

//        fileOutputAndInputStream();

//        writeOnFileWithDif();

//        wrightObject();

        readObject();

    }

    private static void readObject() throws IOException, ClassNotFoundException {
        File file = new File("userFile.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User user = (User) objectInputStream.readObject();
        System.out.println("After reading from file : " + user);
        objectInputStream.close();
        fileInputStream.close();
    }

    private static void wrightObject() throws IOException {
        File file = new File("userFile.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        User user = new User("MAT", "123456");
        System.out.println(user);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
        outputStream.close();
    }

    private static void writeOnFileWithDif() throws IOException {
        File file = new File("char-text.txt");
        System.out.println("char-text.txt length : " + file.length());
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("1234567890");
        fileWriter.write("1234567890");
        fileWriter.write("1234567890");
        fileWriter.write("1234567890");
        fileWriter.close();
        System.out.println("char-text.txt length : " + file.length());

        File noCharFile = new File("no-char");
        System.out.println("no-char length : " + noCharFile.length());

        FileOutputStream fileOutputStream = new FileOutputStream(noCharFile);
        fileOutputStream.write(1234567890);
        fileOutputStream.write(1234567890);
        fileOutputStream.write(1234567890);
        fileOutputStream.write(1234567890);
        fileOutputStream.close();
        System.out.println("noCharFile length: " + noCharFile.length());
    }

    private static void fileOutputAndInputStream() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("file");
        fileOutputStream.write(123456789);
        fileOutputStream.close();

        List<Byte> byteList = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream("file");
        int byteCode;
        while (-1 != (byteCode = fileInputStream.read())) {
            byteList.add((byte) byteCode);
        }
    }

    private static void readFromFileWithScanner() throws FileNotFoundException {

        File file = new File("test-ch.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }

        /*scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();*/

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
