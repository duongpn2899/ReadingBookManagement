 
package entities;

public class Book {
    private int bookID;
    private String bookName, bookTitle, author, brief, publisher, content, category;

    public Book() {

    }

    public Book(String bookName, String bookTitle , String author, String brief, String publisher, String content, String category) {
        super();
        
        this.bookName = bookName;
        this.bookTitle = bookTitle;
        this.author = author;
        this.brief = brief;
        this.publisher = publisher;
        this.content = content;
        this.category = category;

    }public Book(String bookName,   String content) {
        super();
        
        this.bookName = bookName;
      
        this.content = content;
        

    }

    public int getBookID() {
        return bookID;
    }
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBrief() {
        return brief;
    }
    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString(){
        return "Book [ bookID = "+bookID+", bookName = "+bookName+", bookTitle = "+bookTitle+", author = "+author+", brief ="+brief+", publisher = "+publisher+", category = "+category;
    }

}

