package Task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Item");
            System.out.println("2. Checkout Item");
            System.out.println("3. Return Item");
            System.out.println("4. Search Item");
            System.out.println("5. View Fines");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter item type (book/magazine/dvd): ");
                    String type = scanner.nextLine();
                    System.out.println("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter category: ");
                    String category = scanner.nextLine();

                    if (type.equalsIgnoreCase("book")) {
                        System.out.println("Enter number of pages: ");
                        int pages = scanner.nextInt();
                        library.addItem(new Book(title, author, category, pages));
                    } else if (type.equalsIgnoreCase("magazine")) {
                        System.out.println("Enter issue: ");
                        String issue = scanner.nextLine();
                        library.addItem(new Magazine(title, author, category, issue));
                    } else if (type.equalsIgnoreCase("dvd")) {
                        System.out.println("Enter duration in minutes: ");
                        int duration = scanner.nextInt();
                        library.addItem(new DVD(title, author, category, duration));
                    } else {
                        System.out.println("Invalid type.");
                    }
                    break;
                case 2:
                    System.out.println("Enter item title to checkout: ");
                    String checkoutTitle = scanner.nextLine();
                    System.out.println("Enter your name: ");
                    String user = scanner.nextLine();
                    library.checkoutItem(checkoutTitle, user);
                    break;
                case 3:
                    System.out.println("Enter item title to return: ");
                    String returnTitle = scanner.nextLine();
                    System.out.println("Enter your name: ");
                    String returnUser = scanner.nextLine();
                    System.out.println("Enter number of days late (0 if on time): ");
                    int daysLate = scanner.nextInt();
                    library.returnItem(returnTitle, returnUser, daysLate);
                    break;
                case 4:
                    System.out.println("Search by (title/author/category): ");
                    String searchType = scanner.nextLine();
                    System.out.println("Enter search query: ");
                    String query = scanner.nextLine();
                    library.searchItems(query, searchType);
                    break;
                case 5:
                    System.out.println("Enter your name: ");
                    String fineUser = scanner.nextLine();
                    library.viewFines(fineUser);
                    break;
                case 6:
                    System.out.println("Exiting system.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

