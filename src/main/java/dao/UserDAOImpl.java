package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import common.DBUtils;
import common.SQLCommand;
import entities.Book;
import entities.User;

public class UserDAOImpl implements UserDAO {
	
	private Connection connection = null;
	 private PreparedStatement preparedStatement = null;
	 private ResultSet results = null;
	 
	 
	 
	public boolean loginUser(User user) throws SQLException {
		
		
		boolean check = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.USER_QUERY_FIND);
			
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			results = preparedStatement.executeQuery();	
			
			if(results.next()) {
				System.out.println("Hello " + results.getString(2) +
								   ". Please select a function bellow by entering the corresponding number");
				check = true;
			}else {
				System.out.println("UserName or Password is wrong!\n"
						+ "Please enter again:");
			}
		} finally {
			try {
				if (connection != null)
					connection.close();
				
				if (preparedStatement != null)
					preparedStatement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return check;
	}
	public User getUser(User user) throws SQLException{
		User user2 = new User();
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.USER_QUERY_FIND);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			results = preparedStatement.executeQuery();	
			
			if(results.next()) {
				user2.setUserName(results.getString(2));
				user2.setPassword(results.getString(3));
				user2.setRole(results.getInt(4));
				user2.setBookcase(results.getInt(5));
			}
			
		} finally {
			try {
				if (connection != null)
					connection.close();
				
				if (preparedStatement != null)
					preparedStatement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return user2;
	}
	@Override
	public List<Book> viewListBooks() throws SQLException {
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<>();
		Book book = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BOOK_QUERY_FIND);
			
			results = preparedStatement.executeQuery();	
			
			while (results.next()) {
				book = new Book();
				
				book.setBookID(results.getInt(1));
				book.setBookName(results.getString(2));
				book.setBookTitle(results.getString(3));
				book.setAuthor(results.getString(4));
				book.setBrief(results.getString(5));
				book.setPublisher(results.getString(6));
				book.setCategory(results.getString(8));
				books.add(book);
				
			}
			
		} finally {
			try {
				if (connection != null)
					connection.close();
				
				if (preparedStatement != null)
					preparedStatement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return books;
	}
	@Override
	public List<Book> searchBookByName(String name) throws SQLException {
		List<Book> books = new ArrayList<>();
		Book book = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BOOK_QUERY_SEARCH_BY_NAME);
			preparedStatement.setString(1, name);
			results = preparedStatement.executeQuery();	
			
			while (results.next()) {
				book = new Book();
				
				book.setBookID(results.getInt(1));
				book.setBookName(results.getString(2));
				book.setBookTitle(results.getString(3));
				book.setAuthor(results.getString(4));
				book.setBrief(results.getString(5));
				book.setPublisher(results.getString(6));
				book.setCategory(results.getString(8));
				books.add(book);
				
			}
			
		} finally {
			try {
				if (connection != null)
					connection.close();
				
				if (preparedStatement != null)
					preparedStatement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return books;
	}
	@Override
	public List<Book> searchBookByAuthor(String author) throws SQLException {
		List<Book> books = new ArrayList<>();
		Book book = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BOOK_QUERY_SEARCH_BY_AUTHOR);
			preparedStatement.setString(1, author);
			results = preparedStatement.executeQuery();	
			
			while (results.next()) {
				book = new Book();
				
				book.setBookID(results.getInt(1));
				book.setBookName(results.getString(2));
				book.setBookTitle(results.getString(3));
				book.setAuthor(results.getString(4));
				book.setBrief(results.getString(5));
				book.setPublisher(results.getString(6));
				book.setCategory(results.getString(8));
				books.add(book);
				
			}
			
		} finally {
			try {
				if (connection != null)
					connection.close();
				
				if (preparedStatement != null)
					preparedStatement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return books;
	}
	@Override
	public List<Book> searchBookByCategory(String category) throws SQLException {
		List<Book> books = new ArrayList<>();
		Book book = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BOOK_QUERY_SEARCH_BY_CATEGORY);
			preparedStatement.setString(1, category);
			results = preparedStatement.executeQuery();	
			
			while (results.next()) {
				book = new Book();
				
				book.setBookID(results.getInt(1));
				book.setBookName(results.getString(2));
				book.setBookTitle(results.getString(3));
				book.setAuthor(results.getString(4));
				book.setBrief(results.getString(5));
				book.setPublisher(results.getString(6));
				book.setCategory(results.getString(8));
				books.add(book);
				
			}
			
		} finally {
			try {
				if (connection != null)
					connection.close();
				
				if (preparedStatement != null)
					preparedStatement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return books;
	}
	@Override
	public Book readBook(int book_id) throws SQLException {
		Book book = new Book();
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BOOK_QUERY_SEARCH_BY_ID);
			preparedStatement.setInt(1, book_id);
			results = preparedStatement.executeQuery();	
			
			while (results.next()) {
				
				String name = results.getString(2);
				String content = results.getString(7);
				book = new Book(name, content);
				
			}
			
		} finally {
			try {
				if (connection != null)
					connection.close();
				
				if (preparedStatement != null)
					preparedStatement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return book;
		
	}
	@Override
	public List<Book> viewBookCase(int bookCaseId) throws SQLException {
		List<Book> books = new ArrayList<>();
		Book book = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BOOK_QUERY_SEARCH_BOOKCASE);
			preparedStatement.setInt(1, bookCaseId);
			results = preparedStatement.executeQuery();	
			
			while (results.next()) {	
				book = new Book();
				book.setBookID(results.getInt(4));
				book.setBookName(results.getString(5));
				book.setBookTitle(results.getString(6));
				book.setAuthor(results.getString(7));
				book.setPublisher(results.getString(8));
				book.setCategory(results.getString(9));
				books.add(book);
			
				
			}
			
		} finally {
			try {
				if (connection != null)
					connection.close();
				
				if (preparedStatement != null)
					preparedStatement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		return books;
	}
	@Override
	public boolean addBookIntoBookCase(int bookCaseId, int bookId) throws SQLException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); 
		Calendar cal = Calendar.getInstance();  
		
		boolean check = false;
		boolean c = true;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BOOK_QUERY_SEARCH_BOOKCASE);
			preparedStatement.setInt(1, bookCaseId);
			results = preparedStatement.executeQuery();
			while (results.next()) {
				if (results.getInt(2) == bookId) {
					c = false;
				}
			}
			if(c) {
				preparedStatement = connection.prepareStatement(SQLCommand.BOOK_QUERY_FIND);
				results = preparedStatement.executeQuery();	
				while(results.next()) {
					if(results.getInt(1) == bookId) {
						preparedStatement = connection.prepareStatement(SQLCommand.BOOK_QUERY_ADD_INTO_BOOKCASE);
						try {
							preparedStatement.setInt(1, bookCaseId);
							preparedStatement.setInt(2, bookId);
							preparedStatement.setObject(3, dateFormat.format(cal.getTime()));
							preparedStatement.executeUpdate();
						}catch(SQLException e) {
							e.printStackTrace();
						}
						check = true;
						break;
					}
				}
			}
			
			
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return check;
	}
	@Override
	public boolean deleteBookInBookCase(int bookCaseID, int bookId) throws SQLException {
		
		boolean check = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.BOOK_QUERY_FIND_IN_BOOKCASE);
			results = preparedStatement.executeQuery();	
			while (results.next()) {
				if (results.getInt(2) == bookId) {
					preparedStatement = connection.prepareStatement(SQLCommand.BOOK_QUERY_DELETE_BY_BOOKID);
					try {
						preparedStatement.setInt(1, bookCaseID);
						preparedStatement.setInt(2, bookId);						
						preparedStatement.executeUpdate();
					}catch (SQLException e) {
						e.printStackTrace();
					}
					check = true;
					break;
				}
			}
			
			
			
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return check;
	}
	@Override
	public boolean clearBookCase(int bookCaseID) throws SQLException {
		boolean check = false;		
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.QUERY_CLEAR_BOOKCASE);
			try {
				preparedStatement.setInt(1, bookCaseID);
				int row = preparedStatement.executeUpdate();
				if (row == 1) {
					check = true;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return check;
	}
	
	@Override
	public boolean checkBook(int bookID) throws SQLException {
		boolean check = false;
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.BOOK_QUERY_FIND);
            results = preparedStatement.executeQuery();
            while (results.next()) {
            	 if(results.getInt(1) == bookID) {
                 	check = true;
                 	break;
                 }
            }
           
        } finally {
            try {
                if (connection != null)
					connection.close();
				
				if (preparedStatement != null)
					preparedStatement.close();
            } catch (Exception e) {
               
                e.printStackTrace();
            }
        }

        return check;
	}


}
