
package fr.tact.poecjava.courses.objects;

public class Main {

    public static void main(String[] args) {
        Person persons[] = new Person[] {
            new Person(/* name */ "toto", /* age */ 106),
            new Person("jo", 29),
            new Customer("Crésus", 1000000042)
        };

        System.out.println("Liste des personnes enregistrées :");

        for (Person p : persons) {
            // if (p.getClass().getName().equals(Customer.class.getName())) {
            if (p instanceof Customer) {
                Customer c = (Customer) p;
                c.register();
            }

            System.out.println(" - " + p);
        }
    }

    @SuppressWarnings("all")
    private static void possibilityWithoutObjects() {
        String names[] = new String[] {"Toto", "Jo"};
        int ages[] = new int[] {106, 29};
        short toto = 0, jo = 1;

        System.out.println(names[toto] + " a " + ages[toto] + " ans");
    }
}
