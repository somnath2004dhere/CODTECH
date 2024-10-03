package Task4;

import java.io.Serializable;

public abstract class LibraryItem implements Serializable {
    private String title;
    private String author;
    private String category;
    private boolean isBorrowed;

    public LibraryItem(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowItem() {
        this.isBorrowed = true;
    }

    public void returnItem() {
        this.isBorrowed = false;
    }

    public abstract void displayDetails();
}
