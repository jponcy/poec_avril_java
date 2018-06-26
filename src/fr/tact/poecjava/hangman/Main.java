package fr.tact.poecjava.hangman;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String words[] = new String[] {"bottle", "cartridge", "ink", "dog", "cat", "pig"};
        String mystery = words[new Random().nextInt(words.length)];
        Scanner scanner = new Scanner(System.in);
        boolean notFound = true;
        int lives = 5;

        printWelcomMessage(words);

        do {
            System.out.println("\nYou have " + lives + " lives. Do your try:");
            String input = scanner.nextLine();

            if (mystery.equals(input.toLowerCase())) {
                notFound = false;
            } else {
                System.out.println("Not correct response");
            }
        } while (notFound && -- lives > 0);

        if (notFound) {
            System.out.println("Too bad.");
        } else {
            System.out.println("You won");
        }

        // Close external resources.
        scanner.close();
    }

    private static void printWelcomMessage(String[] words) {
        StringBuilder builder = new StringBuilder();

        builder.append("Write a word (among: ");

        for (int i = 0; i < words.length; ++ i) {
            if (i > 0) {
                builder.append(", ");
            }

            builder.append(words[i]);
        }

        builder.append(")");

        System.out.println(builder.toString());
    }
}
