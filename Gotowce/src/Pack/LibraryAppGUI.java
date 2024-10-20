package Pack;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LibraryAppGUI {
	    private Library library;

	    public LibraryAppGUI() {
	        library = new Library();
	        // Przykładowe dane
	        library.addBook(new Book("Wiedźmin", "Andrzej Sapkowski"));
	        library.addBook(new Book("Pan Tadeusz", "Adam Mickiewicz"));
	        library.addUser(new User("Jan Kowalski"));
	        library.addUser(new User("Anna Nowak"));

	        initGUI();
	    }

	    private void initGUI() {
	        JFrame frame = new JFrame("System Zarządzania Biblioteką");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(500, 400);
	        frame.setLayout(new BorderLayout());

	        // Panel opcji
	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(5, 1));

	        JButton borrowBookButton = new JButton("Wypożycz książkę");
	        JButton returnBookButton = new JButton("Zwróć książkę");
	        JButton showAvailableBooksButton = new JButton("Pokaż dostępne książki");
	        JButton showUserBooksButton = new JButton("Pokaż książki użytkownika");

	        panel.add(borrowBookButton);
	        panel.add(returnBookButton);
	        panel.add(showAvailableBooksButton);
	        panel.add(showUserBooksButton);

	        frame.add(panel, BorderLayout.CENTER);

	        // Obsługa przycisku wypożyczenia książki
	        borrowBookButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String userName = JOptionPane.showInputDialog(frame, "Podaj nazwę użytkownika:");
	                String bookTitle = JOptionPane.showInputDialog(frame, "Podaj tytuł książki:");

	                User user = library.findUser(userName);
	                if (user == null) {
	                    JOptionPane.showMessageDialog(frame, "Nie znaleziono użytkownika.", "Błąd", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }

	                Book book = library.findBook(bookTitle);
	                if (book == null) {
	                    JOptionPane.showMessageDialog(frame, "Nie znaleziono książki.", "Błąd", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }

	                user.borrowBook(book);
	                JOptionPane.showMessageDialog(frame, "Książka wypożyczona pomyślnie.");
	            }
	        });

	        // Obsługa przycisku zwrotu książki
	        returnBookButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String userName = JOptionPane.showInputDialog(frame, "Podaj nazwę użytkownika:");
	                String bookTitle = JOptionPane.showInputDialog(frame, "Podaj tytuł książki:");

	                User user = library.findUser(userName);
	                if (user == null) {
	                    JOptionPane.showMessageDialog(frame, "Nie znaleziono użytkownika.", "Błąd", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }

	                Book book = library.findBook(bookTitle);
	                if (book == null) {
	                    JOptionPane.showMessageDialog(frame, "Nie znaleziono książki.", "Błąd", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }

	                user.returnBook(book);
	                JOptionPane.showMessageDialog(frame, "Książka zwrócona pomyślnie.");
	            }
	        });

	        // Obsługa przycisku pokazania dostępnych książek
	        showAvailableBooksButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                List<Book> availableBooks = library.listAvailableBooks();
	                StringBuilder sb = new StringBuilder("Dostępne książki:\n");
	                for (Book book : availableBooks) {
	                    sb.append(book.toString()).append("\n");
	                }
	                JOptionPane.showMessageDialog(frame, sb.toString());
	            }
	        });

	        // Obsługa przycisku pokazania książek użytkownika
	        showUserBooksButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String userName = JOptionPane.showInputDialog(frame, "Podaj nazwę użytkownika:");

	                User user = library.findUser(userName);
	                if (user == null) {
	                    JOptionPane.showMessageDialog(frame, "Nie znaleziono użytkownika.", "Błąd", JOptionPane.ERROR_MESSAGE);
	                    return;
	                }

	                List<Book> borrowedBooks = user.listBorrowedBooks();
	                StringBuilder sb = new StringBuilder("Książki wypożyczone przez użytkownika:\n");
	                for (Book book : borrowedBooks) {
	                    sb.append(book.toString()).append("\n");
	                }

	                JOptionPane.showMessageDialog(frame, sb.toString());
	            }
	        });

	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        new LibraryAppGUI();
	    }
	
}
