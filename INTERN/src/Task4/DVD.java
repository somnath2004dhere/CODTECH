package Task4;

public class DVD extends LibraryItem {
    private int duration;  // Duration in minutes

    public DVD(String title, String author, String category, int duration) {
        super(title, author, category);
        this.duration = duration;
    }

    @Override
    public void displayDetails() {
        System.out.println("DVD Title: " + getTitle());
        System.out.println("Director: " + getAuthor());
        System.out.println("Category: " + getCategory());
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Available: " + !isBorrowed());
    }
}

