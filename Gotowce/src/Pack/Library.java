package Pack;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Dodano książkę: " + book);
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("Dodano użytkownika: " + user.getName());
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public User findUser(String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public List<Book> listAvailableBooks() {
        System.out.println("Dostępne książki w bibliotece:");
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book);
            }
        }
		return books;
    }
    
}
