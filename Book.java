public class Book {
    private String bookTitle;
    private String bookAuthor;
    private String bookIsbn;
    private String bookYear;
    private boolean bookBorrowed = false;
    private String borrowerId = "Available";

    // Constructor
    public Book(String bookTitle, String bookAuthor, String bookIsbn, String bookYear) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookIsbn = bookIsbn;
        this.bookYear = bookYear;
    }

    // Getter and Setter for bookTitle
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    // Getter and Setter for bookAuthor
    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    // Getter and Setter for bookIsbn
    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    // Getter and Setter for bookYear
    public String getBookYear() {
        return bookYear;
    }

    public void setBookYear(String bookYear) {
        this.bookYear = bookYear;
    }

    // Getter and Setter for bookBorrowed
    public boolean isBookBorrowed() {
        return bookBorrowed;
    }

    public void setBookBorrowed(boolean bookBorrowed) {
        this.bookBorrowed = bookBorrowed;
    }

    public void setBorrowerId(String borrowerId){
        this.borrowerId = borrowerId;
    }

    public String getBorrowerId(){
        return this.borrowerId;
    }

    // Get all details of the book
    public String getAllBookInfo() {
        String seperator = "-----------------------------------------------------\n";
        return  seperator + "Title: " + bookTitle + ", Author: " + bookAuthor +
               ", ISBN: " + bookIsbn + ", Year: " + bookYear +
               ", Borrower ID: " + borrowerId + ", Borrowed: " + bookBorrowed;
    }
}
