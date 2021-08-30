package common;

public class SQLCommand {
	public static String USER_QUERY_FIND = 
			"SELECT * FROM Users WHERE user_name =? AND password=?";
	
	public static String BOOK_QUERY_FIND = 
			"SELECT * FROM Book";
	public static String BOOK_QUERY_SEARCH_BY_NAME =
			"SELECT * FROM Book WHERE book_name = ?";
	
	public static String BOOK_QUERY_SEARCH_BY_AUTHOR =
			"SELECT * FROM Book WHERE author = ?";
	
	public static String BOOK_QUERY_SEARCH_BY_CATEGORY =
			"SELECT * FROM Book WHERE category = ?";
	
	public static String BOOK_QUERY_SEARCH_BY_ID =
			"SELECT * FROM Book WHERE book_id = ?";
	
	public static String BOOK_QUERY_SEARCH_BOOKCASE =
			"SELECT * FROM Contain,Book \n"
			+ "WHERE book_case_id=? AND Contain.book_id = Book.book_id";
	
	public static String BOOK_QUERY_ADD_INTO_BOOKCASE =
			"INSERT INTO Contain( book_case_id, book_id, creat_date) VALUES (?,?,?)";
	
	public static String BOOK_QUERY_DELETE_BY_BOOKID = 
			"DELETE FROM Contain WHERE book_case_id = ? AND book_id = ?";
	
	public static String BOOK_QUERY_FIND_IN_BOOKCASE = 
			"SELECT * FROM Contain";
	
	public static String QUERY_CLEAR_BOOKCASE = 
			"DELETE FROM Contain WHERE book_case_id = ?";
	
	public static String CREATE_BOOK =	
			"INSERT INTO Book (book_name, book_title, author, brief, publisher, content, category) VALUES (?,?,?,?,?,?,?)";
	
	public static String DELETE_BOOK =
			"DELETE FROM Book WHERE book_id = ?";
	
	public static String UPDATE_BOOK_CONTENT =
			"UPDATE Book SET content = ? WHERE book_id = ?";
}
