package Pack;

import java.util.ArrayList;
import java.util.List;

import Pack.Book.BookUnavailableException;

public class User {
	 private String name;
	    private List<Book> borrowedBooks;

	    public User(String name) {
	        this.name = name;
	        this.borrowedBooks = new ArrayList<>();
	    }

	    public String getName() {
	        return name;
	    }

	    public void borrowBook(Book book) {
	        try {
	            book.borrow();
	            borrowedBooks.add(book);
	        } catch (BookUnavailableException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    public void returnBook(Book book) {
	        if (borrowedBooks.contains(book)) {
	            book.returnBook();
	            borrowedBooks.remove(book);
	        } else {
	            System.out.println("Użytkownik " + name + " nie wypożyczył tej książki.");
	        }
	    }

	    public List<Book> listBorrowedBooks() {
	        if (borrowedBooks.isEmpty()) {
	            System.out.println(name + " nie wypożyczył(a) żadnych książek.");
	        } else {
	            System.out.println("Wypożyczone książki przez " + name + ":");
	            for (Book book : borrowedBooks) {
	                System.out.println(book);
	            }
	        }
			return borrowedBooks;
	    }
}
