package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Book;
import entities.User;

public interface UserDAO {
	 boolean loginUser(User user) throws SQLException;
	
	 User getUser(User user) throws SQLException;
	 
	 List<Book> viewListBooks() throws SQLException;
	 
	 List<Book> searchBookByName(String name) throws SQLException;
	 
	 List<Book> searchBookByAuthor(String author) throws SQLException;
	 
	 List<Book> searchBookByCategory(String category) throws SQLException;
	 
	 Book readBook(int book_id) throws SQLException;
	 List<Book> viewBookCase(int bookCaseId) throws SQLException;
	 
	 boolean addBookIntoBookCase(int bookCaseID,int bookId) throws SQLException;
	 
	 boolean deleteBookInBookCase(int bookCaseID,int bookId) throws SQLException;
	 
	 boolean clearBookCase(int bookCaseID) throws SQLException;
	 
	 public boolean checkBook(int bookID) throws SQLException ;
	 
}
