
package fr.tact.poecjava.courses.rpg;

public class Player {

    private String username;

    private String password;

    /** Constructor. */
    public Player(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /** Tells if given parameters corresponding to current object. */
    public boolean checkLogin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
