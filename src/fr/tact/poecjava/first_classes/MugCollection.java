
package fr.tact.poecjava.first_classes;

public class MugCollection {

    private Mug[] mugs = new Mug[100];

    private int nb = 0;

    public void addMug(Mug mug) {
        mugs[this.nb] = mug;
        this.nb++;
    }

    public void printStore() {
        System.out.println("Avalable mugs:");
        Mug mug;

        for (int i = 0; i < this.nb; ++ i) {
            mug = this.mugs[i];
            String msg = String.format(" - %03d x %s", mug.getStock(), mug.getName());
            System.out.println(msg);

            if (mug.getDescription() != null && !"".equals(mug.getDescription())) {
                System.out.println("   " + mug.getDescription());
            }
        }
    }
}
