
public class Main {
    public static void main(String[] args) {
        boolean finished = false;
        short i = 3;
        int j;

        do {
            j = i % 10;
            i ++;
            finished = j == 3;
        } while (!finished);

        System.out.println(j);
    }
}
