package Pack;

public class Book {
	private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrow() throws BookUnavailableException {
        if (isBorrowed) {
            throw new BookUnavailableException("Książka '" + title + "' jest już wypożyczona!");
        } else {
            isBorrowed = true;
            System.out.println("Książka '" + title + "' została wypożyczona.");
        }
    }

    public void returnBook() {
        isBorrowed = false;
        System.out.println("Książka '" + title + "' została zwrócona.");
    }

    @Override
    public String toString() {
        return title + " by " + author + (isBorrowed ? " (wypożyczona)" : " (dostępna)");
    }
    class BookUnavailableException extends Exception {
        public BookUnavailableException(String message) {
            super(message);
        }
    }
}
