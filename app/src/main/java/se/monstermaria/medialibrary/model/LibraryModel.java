package se.monstermaria.medialibrary.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryModel {
    private List<Media> media = new ArrayList<>();
    private List<Patron> patrons = new ArrayList<>();
    private Patron loggedInPatron;

    public LibraryModel() {
        parseMedia();
        parsePatrons();
        parseBorrowed();
    }

    private void parseMedia() {
        String pathToFile = LibraryModel.class
                .getClassLoader().getResource("Media.txt").getPath();
        ArrayList<String> input = FileUtilities.readInputFromFile(pathToFile);
        Media parsedMedia;

        for (String m : input) {
            String[] data = m.split(";");

            if (data[0].equals("Bok")) {
                parsedMedia = parseBook(data);
            } else if (data[0].equals("Dvd")) {
                parsedMedia = parseDvd(data);
            } else {
                System.out.println("Could not parse media: " + m);
                continue;
            }

            media.add(parsedMedia);
        }
    }

    private Media parseBook(String[] data) {
        int id = parseInt(data[1]);
        String author = data[2];
        String title = data[3];
        int year = parseInt(data[4]);
        return new Book(id, title, year, author);
    }

    private Media parseDvd(String[] data) {
        int id = parseInt(data[1]);
        String title = data[2];
        int year = parseInt(data[3]);
        String actors = parseActors(data);
        return new DVD(id, title, year, actors);
    }

    private String parseActors(String[] data) {
        StringBuilder actors = new StringBuilder(data[4]);

        for (int i = 5; i < data.length; i++) {
            actors.append(", ");
            actors.append(data[i]);
        }

        return actors.toString();
    }

    private int parseInt(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void parsePatrons() {
        String pathToFile = LibraryModel.class
                .getClassLoader().getResource("Lantagare.txt").getPath();
        ArrayList<String> input = FileUtilities.readInputFromFile(pathToFile);

        for (String p : input) {
            String[] data = p.split(";");

            patrons.add(new Patron(data[0], data[1], data[2]));
        }
    }

    private void parseBorrowed() {
        String pathToFile = LibraryModel.class
                .getClassLoader().getResource("Utlanade.txt").getPath();
        ArrayList<String> input = FileUtilities.readInputFromFile(pathToFile);

        for (String entry : input) {
            String[] data = entry.split(";");
            Patron patron = null;

            for (Patron p : patrons) {
                if (p.getId().equals(data[0])) {
                    patron = p;
                    break;
                }
            }

            for (Media m : media) {
                if (m.getId() == parseInt(data[1])) {
                    m.setBorrower(patron);
                    break;
                }
            }
        }
    }

    public List<Media> getMedia() {
        return media;
    }

    public boolean loginPatron(String patronId) {
        for (Patron p : patrons) {
            if (p.getId().equals(patronId)) {
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
