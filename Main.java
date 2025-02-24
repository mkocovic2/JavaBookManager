import java.util.Scanner;
class Main{
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    int answer = 0; 
    System.out.println("Welcome to the library!\n");
    while(answer != 7){
      printInstructions();
      answer = userInput.nextInt();
    }
    userInput.close();
    LibraryManager lib = new LibraryManager();
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
