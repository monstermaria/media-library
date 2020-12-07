package se.monstermaria.medialibrary.model;

public class Media {
    protected MediaType type;
    protected String title;
    private Patron borrower = null;

    public enum MediaType {
        BOOK,
        DVD
    }

    protected Media(String title) {
        this.title = title;
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
}
