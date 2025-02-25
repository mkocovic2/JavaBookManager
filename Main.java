import java.util.Scanner;
class Main{
  public static void main(String[] args) {
    LibraryManager lib = new LibraryManager();
    Scanner userInput = new Scanner(System.in);
    int answer = 0; 
    System.out.println("Welcome to the library!\n");
    while(answer != 7){
      printInstructions();
      answer = userInput.nextInt();
      switch (answer) {
            case 1 -> lib.displayAllBooks();
            case 2 -> lib.displayAllUsers();
            case 3 -> {
                System.out.print("Enter user credentials: ");
                String userCred = userInput.nextLine();
                lib.displayUserInformation(userCred);
            }
            case 4 -> {
                System.out.print("Enter book ISBN: ");
                String bookIsbn = userInput.nextLine();
                lib.displayBookInformation(bookIsbn);
            }
            case 5 -> {
                System.out.print("Enter user ID: ");
                String userId = userInput.nextLine();
                System.out.print("Enter book ISBN: ");
                String bookIsbn = userInput.nextLine();
                lib.borrowBook(userId, bookIsbn);
            }
            case 7 -> System.out.println("Exiting the library system...");
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }
    userInput.close();
  }

  static void printInstructions(){
    System.out.println("Choose on of the following options (number)\n");
    System.out.println("1. Display all books");
    System.out.println("2. Display all users");
    System.out.println("3. User information");
    System.out.println("4. Book information");
    System.out.println("5. Borrowing Books");
    System.out.println("6. Returning Books (Advanced)");
    System.out.println("7. Quit");
  }
}
