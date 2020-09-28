package com.foxminded.anagram;

import java.util.Scanner;

public class AnagramApp {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String string = scanner.nextLine();
            Anagram anagram = new Anagram();
            System.out.println(anagram.process(string));
        }
    }
}
