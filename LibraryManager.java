import java.io.File;
import java.io.FileNotFoundException;  
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LibraryManager{
    private LibraryManager libmanager = null; 
    private final List<Book> bookList = new ArrayList<>();
    private final List<User> userList = new ArrayList<>(); 
    private final HashMap<String, Book> bookHash = new HashMap<>();
    private final HashMap<String, User> userHash = new HashMap<>();
    
    LibraryManager(){
        populateBooksList();
        populateUserList();
    }

    public void displayAllBooks(){
        for(int i = 0; i < bookList.size(); i++){
            System.out.println(bookList.get(i).getAllBookInfo());
        }
    }

    public void displayAllUsers(){
        for(int i = 0; i < userList.size(); i++){
            System.out.println(userList.get(i).getAllUserInfo());
        }
    }

    public void displayUserInformation(String userId){
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getUserId().equals(userId)){
                System.out.println(userList.get(i).getAllUserInfo());
                break;
            }
        }
    }

    public void displayBookInformation(String bookIsbn){
        for(int i = 0; i < bookList.size(); i++){
            if(bookList.get(i).getBookIsbn().equals(bookIsbn)){
                System.out.println(bookList.get(i).getAllBookInfo());
                break;
            }
        }
    }

    public void borrowBook(String userId, String bookIsbn){
        Book retrievedBook = bookHash.get(bookIsbn);
    }


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
}
