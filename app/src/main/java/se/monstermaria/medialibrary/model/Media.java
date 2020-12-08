package se.monstermaria.medialibrary.model;

public abstract class Media {
    protected MediaType type;
    private int id;
    private String title;
    private int year;
    private Patron borrower = null;

    public enum MediaType {
        BOOK,
        DVD
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected Media(String title) {
        this.title = title;
    }

    public Media(int id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public String getTitel() {
        return title;
    }

    public boolean isBorrowed() {
        return borrower != null;
    }

    public void setBorrower(Patron patron) {
        borrower = patron;
    }

    public abstract String getPersonList();
}
