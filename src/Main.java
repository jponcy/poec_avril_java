
public class Main {
    public static void main(String[] args) {
        short i = 2, j = 4;
        i = 2;
        i = j = 3;

        boolean test = (i == 3);

        if (test) {
            System.out.println("J'avais 3 pommes");
        } else if (i == 2) {
            System.out.println("Pas si mal !");
        } else {
            System.out.println(":'(");
        }
    }
}
