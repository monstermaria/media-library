package se.monstermaria.medialibrary.model;

public class Patron {
    private final String id;
    private final String password;

    public Patron(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
