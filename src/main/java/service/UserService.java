package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.UserDAO;
import dao.UserDAOImpl;
import entities.Book;
import entities.User;

public class UserService {
	static UserDAO userDAO = new UserDAOImpl();
	static Scanner sc = new Scanner(System.in);
	static User user = null;
	static List<Book> books = new ArrayList<>();
	static Book book = null;
	
	public static User login() {
		User user1 = new User();
		try {
			do {
				System.out.print("User name : ");
				String username = sc.nextLine();
				System.out.print("Password : ");
				String password = sc.nextLine();
				user = new User(username, password);
			} while (!userDAO.loginUser(user));
			user1 = userDAO.getUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}	 
		return user1;
	}
	
	
	public static void viewListBook() {
		try {
			books = userDAO.viewListBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (books.isEmpty()) {
			System.out.println("There is not any book in application");
		} else {
			System.out.printf("| %-6s| %-9s| %-35s| %-20s| %-25s| %-20s| %-30s| %-18s|\n", "STT", "id", "Name", "Author", "Category", "Brief", "Title"," Publisher");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			int i = 1;
			
			for(Book x : books) {				
				System.out.printf("| %-6d| %-9d| %-35.35s| %-20.20s| %-25.25s|%-21.21s| %-30.30s| %-18.18s|\n",
						i++, x.getBookID(), x.getBookName(), x.getAuthor(), x.getCategory(), x.getBrief(), x.getBookTitle(), x.getPublisher());
			}
		}
		System.out.println("\n\n");
	}
	
	
	
	public static void searchBookByName() {
		System.out.print("Please enter book s name:");
		String name = sc.nextLine();
		try {
			books = userDAO.searchBookByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (books.isEmpty()) {
			System.out.println(name + " not exist in application");
		} else {
			System.out.println("About " + books.size() + " results :\n");

			System.out.println("Your BookCase has " + books.size() +" books:");
			System.out.printf("| %-6s| %-9s| %-35s| %-20s| %-25s| %-30s| %-18s|\n","STT","id","Name","Author"," Category", "Title"," Publisher");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
			int i = 1;
			
			for(Book x : books) {				
				System.out.printf("| %-6d| %-9d| %-35.35s| %-20.20s| %-25.25s| %-30.30s| %-18.18s|\n",
						i++,x.getBookID(),x.getBookName(),x.getAuthor(),x.getCategory(),x.getBookTitle(),x.getPublisher());
			}
		}
		System.out.println("\n\n");
	}
	public static void searchBookByAuthor() {
		System.out.print("Please enter author:");
		String author = sc.nextLine();
		try {
			books = userDAO.searchBookByAuthor(author);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (books.isEmpty()) {
			System.out.println("Not any book in application by " + author);
		} else {
			System.out.println("About " + books.size() + " results :\n");

			System.out.printf("| %-6s| %-9s| %-35s| %-20s| %-25s| %-30s| %-18s|\n","STT","id","Name","Author"," Category", "Title"," Publisher");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
			int i = 1;
			
			for(Book x : books) {				
				System.out.printf("| %-6d| %-9d| %-35.35s| %-20.20s| %-25.25s| %-30.30s| %-18.18s|\n",
						i++,x.getBookID(),x.getBookName(),x.getAuthor(),x.getCategory(),x.getBookTitle(),x.getPublisher());
			}
		}
		System.out.println("\n\n");
	}
	public static void searchBookByCategory() {
		System.out.print("Please enter category:");
		String category = sc.nextLine();
		try {
			books = userDAO.searchBookByCategory(category);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (books.isEmpty()) {
			System.out.println("Not any book in application by " + category);
		} else {
			System.out.println("About " + books.size() + " results :\n");

			System.out.printf("| %-6s| %-9s| %-35s| %-20s| %-25s| %-30s| %-18s|\n","STT","id","Name","Author"," Category", "Title"," Publisher");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
			int i = 1;
			
			for(Book x : books) {				
				System.out.printf("| %-6d| %-9d| %-35.35s| %-20.20s| %-25.25s| %-30.30s| %-18.18s|\n",
						i++,x.getBookID(),x.getBookName(),x.getAuthor(),x.getCategory(),x.getBookTitle(),x.getPublisher());
			}
		}
		System.out.println("\n\n");
	}
	
	public static void readBook() {
		System.out.println("Please enter the book's id: ");
		int id = Integer.parseInt(sc.nextLine());
		try {
			book = userDAO.readBook(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(book.getBookName() == null) {
			System.out.println("This book is not exist!");
		} else {
			System.out.println(book.getBookName());
			System.out.println(book.getContent());
		}
		System.out.println("\n\n");
	}
	
	public static void viewBookCase(int bookcaseId) {
		try {
			books = userDAO.viewBookCase(bookcaseId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (books.isEmpty()) {
			System.out.println("Your BookCase is empty!");
		} else {
			System.out.println("Your BookCase has " + books.size() +" books:\n");
			System.out.printf("| %-6s| %-9s| %-35s| %-20s| %-25s| %-30s| %-18s|\n","STT","id","Name","Author"," Category", "Title"," Publisher");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
			int i = 1;
			
			for(Book x : books) {				
				System.out.printf("| %-6d| %-9d| %-35.35s| %-20.20s| %-25.25s| %-30.30s| %-18.18s|\n",
						i++,x.getBookID(),x.getBookName(),x.getAuthor(),x.getCategory(),x.getBookTitle(),x.getPublisher());
			}
		}
		System.out.println("\n\n");
	}
	public static void addBookInBookCase(int bookCaseId) {
		System.out.print("Please enter the id: ");
		int book_id = 0;
		boolean err1 = true;
		while (err1){
			if(sc.hasNextInt()){
				book_id = Integer.parseInt(sc.nextLine());
			}else {
				
				System.out.println("Please enter number: ");
				sc.nextLine();
				continue;
			}
			err1=false;
		}
		try {
			if(userDAO.checkBook(book_id)) {
				if(userDAO.addBookIntoBookCase(bookCaseId, book_id)) {
					System.out.println("Add successfully!");
				} else {
					System.out.println(book_id + " exist in yourBookCase\n");
				}
			} else {
				System.out.println(book_id + " is not exist!");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n\n");
		
	}
	
	public static void deleteBookInBookCase(int bookCaseId) {
		System.out.print("Please enter book s id: ");
		int bookid = 0;
		boolean err1 = true;
		while (err1){
			if(sc.hasNextInt()){
				bookid = Integer.parseInt(sc.nextLine());
			}else {
				
				System.out.println("Please enter number: ");
				sc.nextLine();
				continue;
			}
			err1=false;
		}
		try {
			if(userDAO.deleteBookInBookCase(bookCaseId, bookid)) {
				System.out.println("Remove is successfully!");
			} else {
				System.out.println(bookid + " Not exist in your BookCase");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\n\n");
	}
	
	public static void clearBookCase(int bookCaseId) {
		try {
			if(userDAO.clearBookCase(bookCaseId)) {
				System.out.println("Your BookCase is empty!");
			}
			else {
				System.out.println("Error!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\n\n");
	}
	
}
