import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public ArrayList<Book> searchBooksByTitle(String title) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }
}

public class MainL {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. Display all Books");
            System.out.println("3. Search for a Book by Title");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the book: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();
                    Book book = new Book(title, author);
                    library.addBook(book);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.println("List of Books:");
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter the title to search for: ");
                    String searchTitle = scanner.nextLine();
                    ArrayList<Book> searchResult = library.searchBooksByTitle(searchTitle);
                    if (searchResult.isEmpty()) {
                        System.out.println("No books found with that title.");
                    } else {
                        System.out.println("Search results:");
                        for (Book resultBook : searchResult) {
                            System.out.println(resultBook);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
