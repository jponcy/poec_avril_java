package fr.tact.poecjava.hangman;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String words[] = new String[] {"bottle", "cartridge", "ink", "dog", "cat", "pig"};
        String mystery = words[new Random().nextInt(words.length)];
        Scanner scanner = new Scanner(System.in);

        printWelcomMessage(words);

        String input = scanner.nextLine();

        if (mystery.equals(input.toLowerCase())) {
            System.out.println("You won");
        } else {
            System.out.println("You are a big looser!");
        }

        // Close external resources.
        scanner.close();
    }

    private static void printWelcomMessage(String[] words) {
        String message = "Write a word (among: ";

        for (String word : words) {
            message += ", " + word;
        }

        System.out.println(message.replaceFirst(", ", "") + ")");
    }
}
