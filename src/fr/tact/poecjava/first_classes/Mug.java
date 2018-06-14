
package fr.tact.poecjava.first_classes;

public class Mug {

    private String name;

    private float price;

    private int stock = 0;

    private String description;

    /** @return the name */
    public String getName() {
        return name;
    }

    /** @param name The name to set.
     * @return */
    public Mug setName(String name) {
        this.name = name.toLowerCase();
        return this;
    }

    /** @return the price */
    public float getPrice() {
        return price;
    }

    /** @param price The price to set. */
    public void setPrice(float price) {
        this.price = price;
    }

    /** @return the stock */
    public int getStock() {
        return stock;
    }

    /** @param stock The stock to set.
     * @return */
    public Mug setStock(int stock) {
        this.stock = stock;
        return this;
    }

    /** @return the description */
    public String getDescription() {
        return description;
    }

    /** @param description The description to set.
     * @return */
    public Mug setDescription(String description) {
        this.description = description == null ? null : description.trim();
        return this;
    }
}
