package se.monstermaria.medialibrary.model;

public class Book extends Media {
    private String author;
    public Book(int id, String title, int year, String author) {
        super(id, title, year);
        type = MediaType.BOOK;
        this.author = author;
    }

    @Override
    public String getPersonList() {
        return author;
    }
}
