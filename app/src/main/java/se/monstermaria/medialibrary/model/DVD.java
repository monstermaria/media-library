package se.monstermaria.medialibrary.model;

public class DVD extends Media {
    public DVD(String title) {
        super(title);
        type = MediaType.DVD;
    }
}
