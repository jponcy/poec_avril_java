
package fr.tact.poecjava.courses.rpg;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Player> players = Arrays.asList(
                new Player("darkkillerdu35", "sesame"),
                new Player("dez", "dez"),
                new Player("thebest", "2log"));

        Scanner scanner = new Scanner(System.in);
        String username, password;

        System.out.println("Bienvenue sur JavaOnline, on va bien s'amuser !");
        System.out.println("Saisir votre login :");
        username = scanner.nextLine();
        System.out.println("Saisir votre mot de passe:");
        password = scanner.nextLine();

        /* Check login
        // ----- solution 1
        boolean correctLogin = false;

        for (Player player : players) {
            if (player.checkLogin(username, password)) {
                correctLogin = true;
                break;
            }
        }

        if (correctLogin) {
            System.out.println("Vous êtes désormais connecté");
        } else {
            System.out.println("Echec de connexion");
        }

        // ----- solution 2
        int i = 0;
        while (!players.get(i).checkLogin(username, password) && ++ i < players.size());

        if (i == players.size()) {
            System.out.println("Echec de connexion");
        } else {
            System.out.println("Vous êtes désormais connecté");
        }
        // ----- solution 3
        boolean found = false;
        Iterator<Player> it = players.iterator();

        while (it.hasNext() && !found) {
            Player player = it.next();

            if (player.checkLogin(username, password)) {
                found = true;
            }
        }
        // OR
//        Player player;
//        while (it.hasNext() && (player = it.next()) != null);

        if (found) {
            System.out.println("Vous êtes désormais connecté");
        } else {
            System.out.println("Echec de connexion");
        }
        */

        boolean correctLogin = false;
        int i = 0;

        do {
            correctLogin = players.get(i).checkLogin(username, password);
            ++ i;
        } while (!correctLogin && i < players.size());

        if (correctLogin) {
            System.out.println("Vous êtes désormais connecté");
        } else {
            System.out.println("Echec de connexion");
        }


        scanner.close();
    }
}
