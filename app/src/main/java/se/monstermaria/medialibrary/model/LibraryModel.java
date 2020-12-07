package se.monstermaria.medialibrary.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryModel {
    private List<Media> media;
    private List<Patron> patrons;
    private Patron loggedInPatron;

    public LibraryModel() {
        setupLibraryModel();
    }

    private void setupLibraryModel() {
        media = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public List<Media> getMedia() {
        ArrayList<Media> copy = new ArrayList<>();
        Collections.copy(copy, media);
        return copy;
    }

    public boolean loginPatron(String patronId, String password) {
        for (Patron p : patrons) {
            if (p.getId() == patronId && p.getPassword() == password) {
                loggedInPatron = p;
                return true;
            }
        }
        return false;
    }

    public void logoutPatron() {
        loggedInPatron = null;
    }
}
