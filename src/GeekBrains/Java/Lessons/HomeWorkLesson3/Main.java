package GeekBrains.Java.Lessons.HomeWorkLesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
//            readFile();
//            mergeFiveFilesIntoOne();
            textReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // метод для чтения файла в байтовый массив
    public static void readFile() throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("directory1/readFile.txt"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();

         int x;
         while ((x = in.read()) != -1) {
            out.write(x);
         }
         byte [] bytes = out.toByteArray();
        System.out.println(Arrays.toString(bytes));
        in.close();
        out.close();
    }

    public static void mergeFiveFilesIntoOne() throws IOException {
        ArrayList<InputStream> arrayList =new ArrayList<>();
        arrayList.add(new FileInputStream("directory1/file1.txt"));
        arrayList.add(new FileInputStream("directory1/file2.txt"));
        arrayList.add(new FileInputStream("directory1/file3.txt"));
        arrayList.add(new FileInputStream("directory1/file4.txt"));
        arrayList.add(new FileInputStream("directory1/file5.txt"));

        BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(arrayList)));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("out.txt"));

        int x;
        while ((x = in.read()) != -1) {
            out.write(x);
            System.out.println((char) x);
        }
        in.close();
        out.close();
    }

    // метод чтения текстовых файлов
    public static void textReader() throws IOException {
        final int PAGE_SIZE = 1800;
        RandomAccessFile randomAccessFile =new RandomAccessFile("directory1/readFile.txt", "r");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите страницу: ");
        int p = scanner.nextInt() - 1;
        randomAccessFile.seek(p * PAGE_SIZE);
        byte [] barr = new byte[1800];
        randomAccessFile.read(barr);
        System.out.println(new String(barr));
        randomAccessFile.close();
    }
}

