package se.monstermaria.medialibrary.model;

public class Book extends Media {
    public Book(String title) {
        super(title);
        type = MediaType.BOOK;
    }
}
