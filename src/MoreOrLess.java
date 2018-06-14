import java.util.Random;
import java.util.Scanner;

public class MoreOrLess {

    public static void main(String[] args) {
        String line;
        int input;
        int mistery = new Random().nextInt(Integer.MAX_VALUE);
        boolean notFound;
        Integer lastInput = null;

        System.out.println("Essayez de trouver le chiffre mistère ({0, " + Integer.MAX_VALUE + "})");
        // System.out.println("Indice, c'est " + mistery);
        Scanner scan = new Scanner(System.in);

        do {
            line = scan.nextLine();
            input = Integer.parseInt(line);

            if ((notFound = mistery != input)) {
                if (lastInput != null && lastInput == input) {
                    System.out.println("Sérieux ? Vraiment, sérieux, t'es vraiment aussi bête ?");
                } else {
                    lastInput = input;
                }

                if (input < mistery) {
                    System.out.println("Le nombre à trouver est plus grand");
                } else { // Greater.
                    System.out.println("Le nombre à trouver est plus petit");
                }
            }
        } while(notFound);

        System.out.println("Bravo");

        scan.close();
    } // !main.
}
