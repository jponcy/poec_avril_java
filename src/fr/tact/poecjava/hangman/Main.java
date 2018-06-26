package fr.tact.poecjava.hangman;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String words[] = new String[] {"bottle", "cartridge", "ink", "dog", "cat", "pig"};
        String mystery = words[new Random().nextInt(words.length)];
        Scanner scanner = new Scanner(System.in);
        boolean notFound = true;

        printWelcomMessage(words);

        do {
            String input = scanner.nextLine();

            if (mystery.equals(input.toLowerCase())) {
                System.out.println("You won");
                notFound = false;
            } else {
                System.out.println("Game over. Insert a coin.");
            }
        } while (notFound);

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
