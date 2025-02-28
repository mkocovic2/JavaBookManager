import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Library{
    private static Library instance = null; 
    private final List<Book> bookList = new ArrayList<>();
    private final List<User> userList = new ArrayList<>(); 
    private final HashMap<String, Book> bookHash = new HashMap<>();
    private final HashMap<String, User> userHash = new HashMap<>();
    String border = "-------------------------------------------------------------------------------";
    
    /**
    * Returns the singleton instance of the Library class.
    * Creates a new instance if one doesn't exist.
    * 
    * @return The Library instance
    */
    public static Library getInstance(){
      if(instance == null){
        instance = new Library();
      }
      return instance; 
    }

    /**
    * Private constructor for the Library class.
    * Initializes the library by reading data from file.
    */
    private Library(){
        readData();
    }
    
    /**
    * Reads book and user data from the input file and populates
    * the library's collections.
    */
    private void readData() {
        try {
            Scanner scanner = new Scanner(new File("java_hw1_input.txt"));
            
            int bookCount = Integer.parseInt(scanner.nextLine());
            
            for (int i = 0; i < bookCount; i++) {
                String title = scanner.nextLine();
                String author = scanner.nextLine();
                String isbn = scanner.nextLine();
                String year = scanner.nextLine();
            
                Book book = new Book(title, author, isbn, year);
                bookList.add(book);
                bookHash.put(book.getBookIsbn(), book);
            }
        
            int userCount = Integer.parseInt(scanner.nextLine());
        
            for (int i = 0; i < userCount; i++) {
                String firstName = scanner.nextLine();
                String lastName = scanner.nextLine();
                String userId = scanner.nextLine();
            
                User user = new User(firstName, lastName, userId);
                userList.add(user);
                userHash.put(user.getUserId(), user);
            }
        
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: Could not find file 'java_hw1_input.txt'");
            e.printStackTrace();
        }
    }

    /**
    * Displays information for all books in the library.
    */
    public void displayAllBooks(){
        System.out.println(border);
        for(int i = 0; i < bookList.size(); i++){
            System.out.println(bookList.get(i).getAllBookInfo());
        }
        System.out.println(border);
    }
    
    /**
    * Displays information for all users registered in the library.
    */
    public void displayAllUsers(){
        System.out.println(border);
        for(int i = 0; i < userList.size(); i++){
            System.out.println(userList.get(i).getAllUserInfo());
        }
        System.out.println(border);
    }

    /**
    * Displays information for a specific user.
    * 
    * @param userId The ID of the user to display information for
    */
    public void displayUserInformation(String userId){
        System.out.println(border);
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getUserId().equals(userId)){
                System.out.println(userList.get(i).getAllUserInfo());
                break;
            }
        }
        System.out.println(border);
    }

    /**
    * Displays information for a specific book.
    * 
    * @param bookIsbn The ISBN of the book to display information for
    */
    public void displayBookInformation(String bookIsbn){
        System.out.println(border);
        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).getBookIsbn().equals(bookIsbn)){
                System.out.println(bookList.get(i).getAllBookInfo());
                break;
            }
        }
        System.out.println(border);
    }

    /**
    * Processes a book borrowing request from a user.
    * Checks if the user and book exist and if the book is available.
    * Updates the book's status if the borrowing is successful.
    * 
    * @param userId The ID of the user borrowing the book
    * @param bookIsbn The ISBN of the book to be borrowed
    */
    public void borrowBook(String userId, String bookIsbn) {
        System.out.println(border);
        if (!userHash.containsKey(userId)) {
            System.out.println("Error: User ID " + userId + " does not exist.");
            return;
        }
        
        if (!bookHash.containsKey(bookIsbn)) {
            System.out.println("Error: Book with ISBN " + bookIsbn + " does not exist.");
            return;
        }
        
        Book book = bookHash.get(bookIsbn);
        User user = userHash.get(userId);
        
        if (book.isBookBorrowed()) {
            System.out.println("Error: " + book.getBookTitle() + " is already borrowed by user " + book.getBorrowerId() + ".");
            return;
        }
        
        book.setBookBorrowed(true);
        book.setBorrowerId(userId);
        user.setBookBorrowed(book.getBookTitle());
        System.out.println("Success: " + book.getBookTitle() + " has been borrowed by " + user.getFirstName() + " " + user.getLastName() + ".");
        System.out.println(border);
    }
    

    /**
    * Processes a book return request from a user.
    * Checks if the user and book exist, if the book is borrowed, 
    * and if the user returning the book is the one who borrowed it.
    * Updates the book's status if the return is successful.
    * 
    * @param userId The ID of the user returning the book
    * @param bookIsbn The ISBN of the book to be returned
    */
    public void returnBook(String userId, String bookIsbn) {
        System.out.println(border);
        if (!userHash.containsKey(userId)) {
            System.out.println("Error: User ID " + userId + " does not exist.");
            return;
        }
        
        if (!bookHash.containsKey(bookIsbn)) {
            System.out.println("Error: Book with ISBN " + bookIsbn + " does not exist.");
            return;
        }
        
        Book book = bookHash.get(bookIsbn);
        User user = userHash.get(userId);
        
        if (!book.isBookBorrowed()) {
            System.out.println("Error: " + book.getBookTitle() + " is not currently borrowed.");
            return;
        }
        
        if (!book.getBorrowerId().equals(userId)) {
            System.out.println("Error: " + book.getBookTitle() + " was borrowed by user " + book.getBorrowerId() + ", not by " + userId + ".");
            return;
        }
        
        book.setBookBorrowed(false);
        book.setBorrowerId("Available");
        user.setBookBorrowed("None");
        System.out.println("Success: " + book.getBookTitle() + " has been returned by " + user.getFirstName() + " " + user.getLastName() + ".");
        System.out.println(border);
    }

    /* 
    private void populateBooksList(){
        try {
            File bookFile = new File("books.txt");
            Scanner myReader = new Scanner(bookFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dataFields = data.split(", ?");
                Book createdBook = new Book(dataFields[0], dataFields[1], dataFields[2], dataFields[3]);
                bookHash.put(createdBook.getBookIsbn(), createdBook);
                bookList.add(createdBook);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    */

    /*
    private void populateUserList(){
        try {
            File bookFile = new File("users.txt");
            Scanner myReader = new Scanner(bookFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dataFields = data.split(", ?");
                User createdUser = new User(dataFields[0], dataFields[1], dataFields[2]);
                userHash.put(createdUser.getUserId(), createdUser);
                userList.add(createdUser);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    */
}
