
package fr.tact.poecjava.first_classes;

public class Main {
    public static void main(String[] args) {
        MugCollection store = new MugCollection();

        store.addMug(new Mug().setName("TACT"));
        store.addMug(new Mug()
                .setName("Meilleur maman du monde")
                .setStock(32)
                .setDescription("Un classique"));
        store.addMug(new Mug().setName("C'est MON mug!").setStock(3));
        store.addMug(new Mug().setName("Meillleur papa du monde").setStock(2));

        store.printStore();
    }
}