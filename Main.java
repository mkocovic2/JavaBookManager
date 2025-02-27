import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try {
            Library lib = Library.getInstance();
            Scanner userInput = new Scanner(System.in);
            int answer;
            boolean runProgram = true;
            System.out.println("Welcome to the library!\n");
            
            while(runProgram) {
                printInstructions();
                answer = userInput.nextInt();
                userInput.nextLine();  // Consume the newline character
                
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
                    case 6 -> {
                        System.out.print("Enter user ID: ");
                        String userId = userInput.nextLine();
                        System.out.print("Enter book ISBN: ");
                        String bookIsbn = userInput.nextLine();
                        lib.returnBook(userId, bookIsbn);
                    }
                    case 7 -> runProgram = false;
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
            
            System.out.println("Exiting the library system...");
            userInput.close();
        } catch (Exception e) {
            System.out.println("Invalid operation, please enter the correct value");
        }
    }
    
    static void printInstructions() {
        System.out.println("Choose one of the following options (number)\n");
        System.out.println("1. Display all books");
        System.out.println("2. Display all users");
        System.out.println("3. User information");
        System.out.println("4. Book information");
        System.out.println("5. Borrowing Books");
        System.out.println("6. Returning Books (Advanced)");
        System.out.println("7. Quit");
    }
}