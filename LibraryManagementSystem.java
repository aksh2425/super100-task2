import java.util.Arrays;

class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

class Library {
    private Book[] books;
    private int maxBooks;

    public Library(int maxBooks) {
        this.maxBooks = maxBooks;
        this.books = new Book[maxBooks];
    }

    public void addBook(Book book) {
        for (int i = 0; i < maxBooks; i++) {
            if (books[i] == null) {
                books[i] = book;
                return;
            }
        }
        System.out.println("Library is full, cannot add more books.");
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book != null && book.isAvailable()) {
                System.out.println(book);
            }
        }
        System.out.println();
    }

    public void borrowBook(int bookIndex) {
        if (bookIndex >= 0 && bookIndex < maxBooks && books[bookIndex] != null && books[bookIndex].isAvailable()) {
            books[bookIndex].setAvailable(false);
            System.out.println("Book borrowed successfully: " + books[bookIndex]);
        } else {
            System.out.println("Invalid book index or book is not available.");
        }
    }

    public void returnBook(int bookIndex) {
        if (bookIndex >= 0 && bookIndex < maxBooks && books[bookIndex] != null && !books[bookIndex].isAvailable()) {
            books[bookIndex].setAvailable(true);
            System.out.println("Book returned successfully: " + books[bookIndex]);
        } else {
            System.out.println("Invalid book index or book is already available.");
        }
    }
}

class Member {
    private String name;
    private int memberId;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library(5);

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1984", "George Orwell");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayAvailableBooks();

        library.borrowBook(0);

        library.displayAvailableBooks();

        library.returnBook(0);

        library.displayAvailableBooks();
    }
}
