package service;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import dao.AdminDAO;
import dao.AdminDAOImpl;
import entities.Book;
import entities.User;

public class AdminService {
    static AdminDAO adminDAO = new AdminDAOImpl();
    static Scanner scanner = new Scanner(System.in);
    static User user = null;
    static List<Book> books = new LinkedList<Book>();
    static Book book = null;

	public static void createBook() {
		try {
			String loop = "N";
			book = new Book();
			String bookName, bookTitle, author, brief, publisher, category;
			String content = "";

			do {

				System.out.print("Book Name: ");
				bookName = scanner.nextLine();
				book.setBookName(bookName);

				System.out.print("Enter Book Title:");
				bookTitle = scanner.nextLine();
				book.setBookTitle(bookTitle);

				System.out.print("Enter author: ");
				author = scanner.nextLine();
				book.setAuthor(author);

				System.out.print("Enter category: ");
				category = scanner.nextLine();
				book.setCategory(category);

				System.out.println("Enter brief: ");
				brief = scanner.nextLine();
				book.setBrief(brief);

				System.out.println("Enter publisher:");
				publisher = scanner.nextLine();
				book.setPublisher(publisher);

				System.out.println("Enter content and enter '///' to stop : ");
				book.setContent(content);
				String s = "";

				while (!s.equals("///")) {
					content += s + "\n";
					s = scanner.nextLine();
				}
				book = new Book(bookName, bookTitle, author, brief, publisher, content, category);

				if (adminDAO.createBook(book)) {
					System.out.println("book successfully created !!");
				} else {
					System.out.println("book fail created !!");
				}
				System.out.println("Do you want to create book [Y/N]: ?");
				loop = scanner.nextLine();
			} while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
			System.out.println("\n\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public static void deleteBook() {
        System.out.print("Enter book ID: ");
        int bookid = Integer.parseInt(scanner.nextLine());
        try {
			if(adminDAO.checkBook(bookid)) {
				if(adminDAO.deleteBook(bookid)){
			        System.out.println("Remove is successfully !");
			    } 
			} else {
				System.out.println(bookid + " is not exist !");
			}
			System.out.println("\n\n");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public static void editBookContent(){
        System.out.print("Enter book ID: ");
        int bookid = Integer.parseInt(scanner.nextLine());
        try {
			if (adminDAO.checkBook(bookid)) {
				System.out.println("Enter new content and enter '///' to stop :");
			    String newContent = "";
			    String s = "";
        		
        		while(!s.equals("///") ) {
        			newContent += s + "\n";
        			s = scanner.nextLine();
        		}
			    if (adminDAO.editBookContent(bookid, newContent)) {
	                System.out.println("Book successfully update !!");
	            } 
			}
			else {
                System.out.println(bookid + " is not exist !!");
            }
			System.out.println("\n\n");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    
        try {
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}