package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBUtils;
import common.SQLCommand;
import entities.Book;

public class AdminDAOImpl implements AdminDAO{

    
    
    private PreparedStatement preparedStatement = null;
    private Connection connection = null;
    private ResultSet result = null;

	
	@Override
	public boolean createBook(Book book) throws SQLException {
		boolean check = false;
        
        try {
            connection = DBUtils.getInstance().getConnection();
            
            preparedStatement = connection.prepareStatement(SQLCommand.CREATE_BOOK);

            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getBookTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getBrief());
            preparedStatement.setString(5, book.getPublisher());
            preparedStatement.setString(6, book.getContent());
            preparedStatement.setString(7, book.getCategory());
            preparedStatement.executeUpdate();
            
            check = true;
        } finally {
            try {
                if (connection != null)
					connection.close();
				
				if (preparedStatement != null)
					preparedStatement.close();
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
        return check;
	}

	@Override
	public boolean deleteBook(int bookID) throws SQLException {
		boolean check = false;
		boolean c = false;
        try {
            connection = DBUtils.getInstance().getConnection();
           
	            preparedStatement = connection.prepareStatement(SQLCommand.DELETE_BOOK);
	            
	            preparedStatement.setInt(1, bookID);
	            preparedStatement.executeUpdate();
	
	            check = true;
            
        } finally {
            try {
                if (connection != null)
					connection.close();
				
				if (preparedStatement != null)
					preparedStatement.close();
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }
        
        return check;
	}

	@Override
	public boolean editBookContent(int bookID, String newContent) throws SQLException {
		boolean check = false;
        try {
            connection = DBUtils.getInstance().getConnection();
            
	            preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_BOOK_CONTENT);
	
	            preparedStatement.setString(1, newContent);
	            preparedStatement.setInt(2, bookID);
	            preparedStatement.executeUpdate();
	            check = true;
            
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
	
	@Override
	public boolean checkBook(int bookID) throws SQLException {
		boolean check = false;
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQLCommand.BOOK_QUERY_FIND);
            result = preparedStatement.executeQuery();
            while (result.next()) {
            	 if(result.getInt(1) == bookID) {
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
