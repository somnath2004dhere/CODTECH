package Task4;

public class Magazine extends LibraryItem {
    private String issue;

    public Magazine(String title, String author, String category, String issue) {
        super(title, author, category);
        this.issue = issue;
    }

    @Override
    public void displayDetails() {
        System.out.println("Magazine Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Category: " + getCategory());
        System.out.println("Issue: " + issue);
        System.out.println("Available: " + !isBorrowed());
    }
}
