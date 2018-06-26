package fr.tact.poecjava.hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String mystery = "mystere";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inscrire un mot");
        String input = scanner.nextLine();

        if (mystery.equals(input.toLowerCase())) {
            System.out.println("You won");
        } else {
            System.out.println("You are a big looser!");
        }

        // Close external resources.
        scanner.close();
    }
}
