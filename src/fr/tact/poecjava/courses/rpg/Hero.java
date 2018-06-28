
package fr.tact.poecjava.courses.rpg;

public class Hero {
    private String name;
    private String heroClass;

    public Hero() {
    }

    public Hero(String name, String heroClass) {
        this.setName(name);
        this.setHeroClass(heroClass);
    }

    @Override
    public String toString() {
        return this.getName() + " (" + this.getHeroClass() + ")";
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public final void setName(String name) {
        this.name = name.trim();
    }

    /**
     * @return the heroClass
     */
    public final String getHeroClass() {
        return heroClass;
    }

    /**
     * @param heroClass The heroClass to set.
     */
    public final void setHeroClass(String heroClass) {
        this.heroClass = heroClass.toLowerCase().trim();
    }
}
