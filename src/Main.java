
public class Main {
    public static void main(String[] args) {
        short i = 2, j = 4;
        i = 2;
        i = j = 3;

        switch (i) {
            case 3:
                System.out.println("J'avais 3 pommes");
                break;
            case 2:
                System.out.println("Pas si mal !");
                break;
            default:
                System.out.println(":'(");
                break;
        }
    }
}
