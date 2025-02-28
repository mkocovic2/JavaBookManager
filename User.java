public class User {
    private String firstName;
    private String lastName;
    private String userId;
    private String bookBorrowed = "None";

    // Constructor
    public User(String firstName, String lastName, String userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
    }

    // Getter and Setter for firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter for lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and Setter for userId
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Getter and Setter for bookBorrowed
    public String getBookBorrowed(){
        return this.bookBorrowed;
    }

    public void setBookBorrowed(String bookBorrowed){
        this.bookBorrowed = bookBorrowed;
    }

    // Get all details of the user
    public String getAllUserInfo() {
        return "User ID: " + userId + ", Name: " + firstName + " " + lastName + ", Book Borrowed: " + bookBorrowed; 
    }
}
