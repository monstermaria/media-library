package se.monstermaria.medialibrary.model;

public class DVD extends Media {
    private String actors;

    public DVD(int id, String title, int year, String actors) {
        super(id, title, year);
        type = MediaType.DVD;
        this.actors = actors;
    }

    @Override
    public String getPersonList() {
        return actors;
    }
}
