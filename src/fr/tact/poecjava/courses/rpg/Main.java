
package fr.tact.poecjava.courses.rpg;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Player> players = Arrays.asList(
                new Player("darkkillerdu35", "sesame")
                    .addHero(new Hero("TheBestBeast", "gladiateur")),
                new Player("dez", "dez")
                    .addHero(new Hero("thedezman", "paladin"))
                    .addHero(new Hero("thedezvision", "oracle"))
                    .addHero(new Hero("dezdeztheheal", "redempteur")),
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
        Player player;

        do {
            player = players.get(i);
            correctLogin = player.checkLogin(username, password);
            ++ i;
        } while (!correctLogin && i < players.size());

        if (correctLogin) {
            System.out.println("Vous êtes désormais connecté");

            switch (player.getHeroes().size()) {
            case 0:
                System.err.println("Vous n'avez pas encore de personnage");
                break;
            default:
                System.out.println("Avec quel personnage voulez-vous vous connecter ?");

                for (int heroIndex = 1; heroIndex <= player.getHeroes().size(); ++ heroIndex) {
                    Hero hero = player.getHeroes().get(heroIndex - 1);
                    System.out.println(heroIndex + ") " + hero);
                }

                System.out.println();
                Hero selectedHero = null;

                do {
                    System.out.print("Votre choix (saisir le chiffre entre 1 et "
                                + player.getHeroes().size() + ") : ");
                    String line = null;

                    try {
                        line = scanner.nextLine();
                        int heroIndex = Integer.parseInt(line);

                        if (heroIndex > 0 && heroIndex <= player.getHeroes().size()) {
                            selectedHero = player.getHeroes().get(heroIndex - 1);
                            System.out.println("Connexion en cours, avec le héro " + selectedHero);
                        } else {
                            System.out.println("Le nombre saisie est trop petit ou trop grand");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(line + " n'est pas un nombre");
                    }/* catch (IndexOutOfBoundsException e) {
                        System.out.println("Le nombre saisie est trop petit ou trop grand");
                    }*/ // Commented due to managed before: if (heroIndex > 0 && heroIndex <= player.getHeroes().size()).
                } while (selectedHero == null);

                break;
            }
        } else {
            System.out.println("Echec de connexion");
        }


        scanner.close();
    }
}
