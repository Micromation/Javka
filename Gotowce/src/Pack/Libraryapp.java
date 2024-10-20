package Pack;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Libraryapp {
	 public static void main(String[] args) {
	        Library library = new Library();
	        Scanner scanner = new Scanner(System.in);

	        // Dodaj przykładowe książki i użytkowników
	        library.addBook(new Book("Wiedźmin", "Andrzej Sapkowski"));
	        library.addBook(new Book("Pan Tadeusz", "Adam Mickiewicz"));
	        library.addBook(new Book("Lalka", "Bolesław Prus"));

	        library.addUser(new User("Jan Kowalski"));
	        library.addUser(new User("Anna Nowak"));

	        while (true) {
	            System.out.println("\nWybierz opcję:");
	            System.out.println("1. Wypożycz książkę");
	            System.out.println("2. Zwróć książkę");
	            System.out.println("3. Pokaż dostępne książki");
	            System.out.println("4. Pokaż wypożyczone książki użytkownika");
	            System.out.println("5. Wyjdź");

	            int choice = scanner.nextInt();
	            scanner.nextLine();  // Oczyszczenie bufora

	            switch (choice) {
	                case 1:
	                    System.out.println("Podaj nazwę użytkownika:");
	                    String userName = scanner.nextLine();
	                    User user = library.findUser(userName);

	                    if (user == null) {
	                        System.out.println("Nie znaleziono użytkownika.");
	                        break;
	                    }

	                    System.out.println("Podaj tytuł książki:");
	                    String bookTitle = scanner.nextLine();
	                    Book book = library.findBook(bookTitle);

	                    if (book == null) {
	                        System.out.println("Nie znaleziono książki.");
	                        break;
	                    }

	                    user.borrowBook(book);
	                    break;

	                case 2:
	                    System.out.println("Podaj nazwę użytkownika:");
	                    userName = scanner.nextLine();
	                    user = library.findUser(userName);

	                    if (user == null) {
	                        System.out.println("Nie znaleziono użytkownika.");
	                        break;
	                    }

	                    System.out.println("Podaj tytuł książki do zwrotu:");
	                    bookTitle = scanner.nextLine();
	                    book = library.findBook(bookTitle);

	                    if (book == null) {
	                        System.out.println("Nie znaleziono książki.");
	                        break;
	                    }

	                    user.returnBook(book);
	                    break;

	                case 3:
	                    library.listAvailableBooks();
	                    break;

	                case 4:
	                    System.out.println("Podaj nazwę użytkownika:");
	                    userName = scanner.nextLine();
	                    user = library.findUser(userName);

	                    if (user == null) {
	                        System.out.println("Nie znaleziono użytkownika.");
	                        break;
	                    }

	                    user.listBorrowedBooks();
	                    break;

	                case 5:
	                    System.out.println("Koniec programu.");
	                    scanner.close();
	                    return;

	                default:
	                    System.out.println("Nieprawidłowy wybór.");
	                    break;
	            }
	        }
	    }
	 
	}

