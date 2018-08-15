package com.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by 12038 on 2018/8/13.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try (PrintStream ps = new PrintStream(new FileOutputStream("a.txt")))
        {
            System.out.println("a");
            ps.println("jiang");
        }

    }
}
