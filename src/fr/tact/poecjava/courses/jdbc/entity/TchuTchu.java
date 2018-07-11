
package fr.tact.poecjava.courses.jdbc.entity;

public class TchuTchu {
    private Integer id;
    private String nom;
    /** The initial -max- speed (could be reduced by weight). */
    private int vitesse;
    /** The real weight. */
    private int poids;
    // TODO: Add machineDeTete
    // TODO: Add typeDeRail
    // TODO: Add trajet

    public TchuTchu() {
    }

    public TchuTchu(Integer id, String nom, int vitesse, int poids) {
        this.setId(id);
        this.setNom(nom);
        this.setVitesse(vitesse);
        this.setPoids(poids);
    }

    @Override
    public String toString() {
        String result = "";

        if (this.getId() != null) {
            result += "(" + this.getId() + ") ";
        }

        result += this.getNom();

        return result;
    }

    /** @return Returns the id. */
    public final Integer getId() {
        return this.id;
    }

    /**
     * Sets the id.
     * @param id The id to set.
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /** @return Returns the nom. */
    public final String getNom() {
        return this.nom;
    }

    /**
     * Sets the nom.
     * @param nom The nom to set.
     */
    public final void setNom(String nom) {
        this.nom = nom;
    }

    /** @return Returns the vitesse. */
    public final int getVitesse() {
        return this.vitesse;
    }

    /**
     * Sets the vitesse.
     * @param vitesse The vitesse to set.
     */
    public final void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    /** @return Returns the poids. */
    public final int getPoids() {
        return this.poids;
    }

    /**
     * Sets the poids.
     * @param poids The poids to set.
     */
    public final void setPoids(int poids) {
        this.poids = poids;
    }
}
