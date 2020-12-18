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

    public String getType() {
        return type.name();
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

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean isBorrowed() {
        return borrower != null;
    }

    public void setBorrower(Patron patron) {
        borrower = patron;
    }

    public abstract String getPersonList();

    public String getAvailability() {
        return isBorrowed() ? "No" : "Yes";
    }
}
