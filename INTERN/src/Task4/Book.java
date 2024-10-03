package Task4;

public class Book extends LibraryItem {
    private int pages;

    public Book(String title, String author, String category, int pages) {
        super(title, author, category);
        this.pages = pages;
    }

    @Override
    public void displayDetails() {
        System.out.println("Book Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Category: " + getCategory());
        System.out.println("Pages: " + pages);
        System.out.println("Available: " + !isBorrowed());
    }
}

