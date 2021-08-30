package dao;

import java.sql.SQLException;

import entities.Book;

public interface AdminDAO {
	public boolean createBook(Book book) throws SQLException;
	
	public boolean deleteBook(int bookID) throws SQLException;
	
	public boolean editBookContent(int bookID, String newContent) throws SQLException;
	
	 boolean checkBook(int bookID) throws SQLException;
}
