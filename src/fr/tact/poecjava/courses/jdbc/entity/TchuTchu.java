
package fr.tact.poecjava.courses.jdbc.entity;

public class TchuTchu {
    private Integer id;
    private String name;
    private Integer mapPeopleNb;


    public TchuTchu() {
    }

    public TchuTchu(Integer id, String name, Integer mapPeopleNb) {
        this.setId(id);
        this.setName(name);
        this.setMapPeopleNb(mapPeopleNb);
    }


    /**
     * @return the id
     */
    public final Integer getId() {
        return id;
    }

    /**
     * @param id The id to set.
     *
     */
    public final void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     *
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mapPeopleNb
     */
    public final Integer getMapPeopleNb() {
        return mapPeopleNb;
    }

    /**
     * @param mapPeopleNb The mapPeopleNb to set.
     *
     */
    public final void setMapPeopleNb(Integer mapPeopleNb) {
        this.mapPeopleNb = mapPeopleNb;
    }
}
